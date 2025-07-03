import { useEffect, useState, useRef } from "react";

import { Button } from "@/shared/ui/button/Button";
import { Input } from "@/shared/ui/input/Input";
import { useParams } from "react-router-dom";

import { useUser } from "@/entity/user/hooks/useUser";
import { fetchAutocomplete, MapItem } from "@/feature/jari/api/autocomplete";
import { JariRegisterPayload } from "@/feature/jari/api/registerJari";
import { registerJari } from "@/feature/jari/api/registerJari";
import { toast } from "@/shared/hooks/use-toast";
const JariRegisterDetailPage = () => {
  const { name } = useParams();
  const [mapData, setMapData] = useState<MapItem | null>(null);

  const [isPreviewOpen, setIsPreviewOpen] = useState(false);
  const [aspectRatio, setAspectRatio] = useState("4 / 3");
  const imgRef = useRef<HTMLImageElement>(null);
  const user = useUser();

  const [form, setForm] = useState({
    tradeType: null as "SELL" | "BUY" | null,
    mapName: name,
    serverColor: null as "Red" | "Yellow" | "Green" | null,
    price: "",
    comment: "",
    negotiationOption: false,
  });

  const handleSubmit = async () => {
    const payload: JariRegisterPayload = {
      ...form,
      mapName: form.mapName!,
      userId: Number(user!.user.userId),
      serverColor: form.serverColor! as "Red" | "Yellow" | "Green",
      price: Number(form.price),
      tradeType: form.tradeType!,
    };
    console.log(payload);
    try {
      await registerJari(payload);
      toast({
        title: "자리 등록 완료",
        description: "성공적으로 등록되었습니다.",
      });

      setForm({
        mapName: form.mapName,
        serverColor: null,
        price: "",
        comment: "",
        negotiationOption: false,
        tradeType: null,
      });
    } catch (err: any) {
      let message = "알 수 없는 오류가 발생했습니다.";

      if (err?.errors?.comment) {
        message = err.errors.comment;
      } else if (err?.error) {
        message = err.error;
      }

      toast({
        variant: "destructive",
        title: "자리 등록 실패",
        description: message,
      });
    }
  };

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
  useEffect(() => {
    const fetchMap = async () => {
      console.log(name);
      if (!name) return;
      try {
        const res = await fetchAutocomplete(name);
        const matched = res.find((m) => m.mapName === decodeURIComponent(name));
        if (matched) {
          setMapData(matched);
          setForm((prev) => ({ ...prev, mapName: matched.mapName }));
        }
      } catch (e) {
        console.error("맵 정보 불러오기 실패", e);
      }
    };

    fetchMap();
  }, [name]);
  const handleImageLoad = (e: React.SyntheticEvent<HTMLImageElement>) => {
    const img = e.currentTarget;
    if (img.naturalWidth && img.naturalHeight) {
      setAspectRatio(`${img.naturalWidth} / ${img.naturalHeight}`);
    }
  };

  return (
    <div className="flex flex-col items-center pt-10 h-full gap-5 px-4 pb-20">
      {/* 안내 박스 */}
      <div className="space-y-3 text-sm sm:text-base text-left leading-relaxed bg-neutral-900 text-white p-6 rounded-md border border-neutral-700 w-full max-w-2xl">
        <p>
          ⚠️ 메랜자리 등록은{" "}
          <span className="font-semibold text-yellow-400">
            동시에 하나만 등록
          </span>
          할 수 있습니다.
        </p>
        <p>
          ⚠️ <span className="text-red-400">현금 거래나 허위 매물</span>은 사전
          통보 없이 삭제 및 제재될 수 있습니다.
        </p>
        <p>
          ✅{" "}
          <span className="text-green-400">정확하고 신뢰할 수 있는 정보</span>만
          등록해 주세요!
        </p>
      </div>
      {/* 서치바
      <div className="w-full max-w-2xl">
        <SearchInputWithSuggestions
          placeholder="자리를 입력해주세요"
          className="w-full"
          onSelect={(val) => {
            navigate(`/jari/register/${encodeURIComponent(val)}`);
          }}
        />
      </div> */}
      {/* tradeType */}
      <div className="w-full max-w-2xl space-y-2">
        <p className="text-white text-sm font-medium text-center">
          거래 타입을 선택해주세요
        </p>
        <div className="flex gap-4">
          <Button
            variant="none"
            onClick={() => setForm((prev) => ({ ...prev, tradeType: "SELL" }))}
            className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
              form.tradeType === "SELL"
                ? "bg-red-600 text-white border-red-600"
                : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
            }`}
          >
            팝니다
          </Button>
          <Button
            variant="none"
            onClick={() => setForm((prev) => ({ ...prev, tradeType: "BUY" }))}
            className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
              form.tradeType === "BUY"
                ? "bg-blue-600 text-white border-blue-600"
                : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
            }`}
          >
            삽니다
          </Button>
        </div>
      </div>
      {/* 거래 폼 */}
      {form.tradeType && (
        <>
          {mapData && (
            <div className="w-full flex flex-col items-center gap-3  mt-10 mb-10 text-white relative">
              {/* 맵 이름 */}
              <div className="flex items-center gap-4 p-3 rounded-lg bg-slate-700 shadow-md hover:shadow-lg transition duration-200">
                <img
                  src={mapData.miniMapImageLogoUrl}
                  alt="minimap"
                  className="w-10 h-10 rounded-md object-contain bg-slate-600 p-1"
                />
                <p className="text-lg sm:text-xl font-semibold text-white">
                  {mapData.mapName}
                </p>
              </div>
              {/* 미니맵 이미지 + 클릭 확대 */}
              <div className="relative">
                <div className="w-96 relative" style={{ aspectRatio }}>
                  <img
                    ref={imgRef}
                    src={mapData.miniMapImageUrl}
                    alt="맵로고"
                    onLoad={handleImageLoad}
                    className="absolute inset-0 w-full h-full object-contain rounded-md cursor-pointer transition "
                    onClick={() => setIsPreviewOpen(true)}
                  />
                </div>
                {isPreviewOpen && (
                  <div
                    className="fixed inset-0 bg-black/80 z-[9999] flex items-center justify-center"
                    onClick={() => setIsPreviewOpen(false)}
                  >
                    <div
                      className="relative max-w-[90%] max-h-[90%] animate-fade-in"
                      onClick={(e) => e.stopPropagation()}
                    >
                      <img
                        src={mapData.miniMapImageUrl}
                        alt="전체 보기"
                        className="max-w-screen max-h-screen object-contain rounded-lg shadow-2xl border border-neutral-600"
                      />
                      <Button
                        variant="none"
                        onClick={() => setIsPreviewOpen(false)}
                        className="absolute top-2 right-2 text-white text-xl bg-black/60 rounded-full px-3 py-1 hover:bg-black/80"
                      >
                        ✕
                      </Button>
                    </div>
                  </div>
                )}
              </div>
            </div>
          )}
          <div className="w-full max-w-2xl text-white">
            {/* mapColor (빨/노/초 라디오) */}
            <div className="border-b border-neutral-700 pb-4 mb-4">
              <p className=" font-medium mb-2">맵 상태를 선택해주세요</p>
              <div className="flex gap-4">
                <label className="flex items-center gap-2 cursor-pointer">
                  <Input
                    type="radio"
                    name="mapColor"
                    value="red"
                    checked={form.serverColor === "Red"}
                    onChange={() =>
                      setForm((prev) => ({ ...prev, serverColor: "Red" }))
                    }
                    className="accent-red-500 w-5 cursor-pointer"
                  />
                  <span className="text-white">빨채</span>
                </label>
                <label className="flex items-center gap-2 cursor-pointer">
                  <Input
                    type="radio"
                    name="mapColor"
                    value="yellow"
                    checked={form.serverColor === "Yellow"}
                    onChange={() =>
                      setForm((prev) => ({ ...prev, serverColor: "Yellow" }))
                    }
                    className="accent-yellow-400 w-5 cursor-pointer"
                  />
                  <span className="text-white">노채</span>
                </label>
                <label className="flex items-center gap-2 cursor-pointer">
                  <Input
                    type="radio"
                    name="mapColor"
                    value="green"
                    checked={form.serverColor === "Green"}
                    onChange={() =>
                      setForm((prev) => ({ ...prev, serverColor: "Green" }))
                    }
                    className="accent-green-500 w-5 cursor-pointer"
                  />
                  <span className="text-white">초채</span>
                </label>
              </div>
            </div>

            {/* price */}
            <div className="border-b border-neutral-700 pb-4 mb-4">
              <label className="block mb-1 text-sm font-medium">가격</label>
              <input
                type="number"
                value={form.price}
                onChange={(e) =>
                  setForm((prev) => ({ ...prev, price: e.target.value }))
                }
                className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
                placeholder="거래 가격을 입력해주세요"
              />
              {form.price && (
                <p className="mt-1 px-2 text-sm text-white">
                  {formatToWonStyle(form.price)}
                </p>
              )}
            </div>

            {/* negotiationOption */}

            <div className="flex items-center gap-2 border-b border-neutral-700 pb-4 mb-4">
              <Input
                type="checkbox"
                checked={form.negotiationOption}
                onChange={(e) =>
                  setForm((prev) => ({
                    ...prev,
                    negotiationOption: e.target.checked,
                  }))
                }
                id="negotiation"
                className="w-3 cursor-pointer"
              />
              <label htmlFor="negotiation" className="text-sm cursor-pointer">
                흥정 가능
              </label>
            </div>

            {/* comment */}
            <div className="border-neutral-700 pb-4 mb-4">
              <label className="block mb-1 text-sm font-medium">
                거래 메모
              </label>
              <textarea
                value={form.comment}
                onChange={(e) =>
                  setForm((prev) => ({ ...prev, comment: e.target.value }))
                }
                className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
                placeholder="거래 관련 안내 메시지"
                minLength={0}
                maxLength={60}
              />
            </div>

            {/* 등록 버튼 */}
            <Button
              className="w-full bg-green-600 hover:bg-green-700 text-white"
              onClick={handleSubmit}
            >
              등록하기
            </Button>
          </div>
        </>
      )}
    </div>
  );
};

export default JariRegisterDetailPage;
