import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { useUser } from "@/entity/user/hooks/useUser";
import { useAllMaps } from "@/entity/map/hooks/useAllMaps";
import { MapItem } from "@/entity/map/api/getAllMaps";
import {
  JariRegisterPayload,
  registerJari,
} from "@/entity/jari/api/registerJari";
import { toast } from "@/shared/hooks/use-toast";
import { useQueryClient } from "@tanstack/react-query";

type TradeType = "SELL" | "BUY";
type ServerColor = "Red" | "Yellow" | "Green";

interface FormState {
  tradeType: TradeType | null;
  mapName: string | undefined;
  serverColor: ServerColor | null;
  price: string;
  comment: string;
  negotiationOption: boolean;
}

export const useJariRegisterForm = () => {
  const { name } = useParams();
  const queryClient = useQueryClient();

  const user = useUser();
  const navigate = useNavigate();
  const { data: allMaps } = useAllMaps();
  const [mapData, setMapData] = useState<MapItem | null>(null);
  const [errorMessage, setErrorMessage] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [form, setForm] = useState<FormState>({
    tradeType: null,
    mapName: name,
    serverColor: null,
    price: "",
    comment: "",
    negotiationOption: false,
  });

  useEffect(() => {
    if (!name || !allMaps) return;

    try {
      const matched = allMaps.find(
        (m) => m.mapName === decodeURIComponent(name)
      );

      if (matched) {
        setMapData(matched);
        setForm((prev) => ({ ...prev, mapName: matched.mapName }));
        setErrorMessage("");
      } else {
        setErrorMessage("존재하지 않는 맵입니다.");
      }
    } catch (e) {
      if (e instanceof Error) {
        setErrorMessage(e.message);
      } else {
        setErrorMessage("맵 정보를 불러오는 중 오류가 발생했습니다.");
      }
    }
  }, [name, allMaps]);

  const formatToWonStyle = (value: number | string): string => {
    let num = Number(value);
    if (isNaN(num) || num <= 0) return "";
    const units = [
      { label: "억", value: 100000000 },
      { label: "만", value: 10000 },
      { label: "", value: 1 },
    ];
    const parts: string[] = [];
    for (const unit of units) {
      const unitAmount = Math.floor(num / unit.value);
      if (unitAmount > 0 || unit.label === "") {
        const formatted = unitAmount.toLocaleString();
        parts.push(`${formatted}${unit.label}`);
      }
      num %= unit.value;
    }
    return parts.join(" ") + "메소";
  };

  const handleSubmit = async () => {
    if (isSubmitting) return;
    setIsSubmitting(true);
    const payload: JariRegisterPayload = {
      ...form,
      mapName: form.mapName!,
      userId: Number(user!.user.userId),
      serverColor: form.serverColor!,
      price: Number(form.price),
      tradeType: form.tradeType!,
      mapId: mapData!.mapId,
    };

    try {
      await registerJari(payload);

      toast({
        title: "자리 등록 완료",
        variant: "success",
        description: "성공적으로 등록되었습니다.",
      });
      navigate(`/jari/${form.mapName}`);
      queryClient.invalidateQueries({ queryKey: ["jariList"] });
      setForm((prev) => ({
        ...prev,
        tradeType: null,
        serverColor: null,
        price: "",
        comment: "",
        negotiationOption: false,
      }));
    } catch (err: unknown) {
      let message = "알 수 없는 오류가 발생했습니다.";
      if (typeof err === "string") {
        message = err;
      }

      toast({
        variant: "destructive",
        title: "자리 등록 실패",
        description: message,
      });
    } finally {
      setIsSubmitting(false);
    }
  };
  return {
    form,
    setForm,
    mapData,
    formatToWonStyle,
    handleSubmit,
    errorMessage,
  };
};
