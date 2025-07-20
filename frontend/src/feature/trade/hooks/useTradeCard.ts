import { useEffect, useRef, useState } from "react";
import { toast } from "@/shared/hooks/use-toast";
import { editJari } from "@/entity/jari/api/editJari";
import { deleteJari } from "@/feature/delete/api/deleteJari";
import { updateCompletionStatus } from "@/entity/jari/api/updateCompletionStatus";
import { JariItem } from "@/entity/jari/model/type";
import { ServerColor } from "../ui/TradeCard";

export const useTradeCard = (item: JariItem, refetch: () => void) => {
  const editBoxRef = useRef<HTMLFormElement>(null);
  const [showEditBox, setShowEditBox] = useState(false);
  const [editPrice, setEditPrice] = useState(item.price);
  const [editComment, setEditComment] = useState(item.comment);
  const [editServerColor, setEditServerColor] = useState<ServerColor>(
    item.serverColor as ServerColor
  );
  const [editNegotiationOption, setEditNegotiationOption] = useState(
    item.negotiationOption
  );

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (
        editBoxRef.current &&
        !editBoxRef.current.contains(event.target as Node)
      ) {
        setShowEditBox(false);
      }
    };
    if (showEditBox) {
      document.addEventListener("mousedown", handleClickOutside);
    }
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [showEditBox]);

  const handleUpdate = async () => {
    const confirmed = window.confirm("정말로 수정 하시겠습니까?");
    if (!confirmed) return;
    try {
      await editJari({
        mapId: item.userMapId,
        price: Number(editPrice),
        serverColor: editServerColor,
        comment: editComment,
        negotiationOption: editNegotiationOption,
      });
      refetch();
      toast({
        variant: "success",
        title: "수정 완료",
        description: "자리 정보가 성공적으로 수정되었습니다.",
      });
      setShowEditBox(false);
    } catch (err) {
      const errorMessage =
        err instanceof Error
          ? err.message
          : "자리 수정 중 문제가 발생했습니다.";
      toast({
        title: "❌ 수정 실패",
        description: errorMessage,
        variant: "destructive",
      });
    }
  };

  const handleDelete = async () => {
    const confirmed = window.confirm("정말로 삭제하시겠습니까?");
    if (!confirmed) return;
    try {
      await deleteJari(item.userMapId);
      toast({
        variant: "success",
        title: "삭제 완료",
        description: "자리 정보가 성공적으로 삭제되었습니다.",
      });
      setShowEditBox(false);
      refetch();
    } catch (err) {
      const errorMessage =
        err instanceof Error ? err.message : "삭제 중 문제가 발생했습니다.";
      toast({
        title: "❌ 삭제 실패",
        description: errorMessage,
        variant: "destructive",
      });
    }
  };

  const handleMarkAsCompleted = async () => {
    const confirmed = window.confirm("정말로 거래완료 처리 하시겠습니까?");
    if (!confirmed) return;
    try {
      await updateCompletionStatus(item.userMapId, true);
      toast({
        variant: "success",
        title: "거래 완료 처리가 성공적으로 되었습니다.",
      });
      refetch();
      setShowEditBox(false);
    } catch (err) {
      toast({
        title: "❌ 거래 완료 처리 실패",
        description:
          err instanceof Error
            ? err.message
            : "알 수 없는 오류가 발생했습니다.",
        variant: "destructive",
      });
    }
  };

  return {
    editBoxRef,
    showEditBox,
    setShowEditBox,
    editPrice,
    setEditPrice,
    editComment,
    setEditComment,
    editServerColor,
    setEditServerColor,
    editNegotiationOption,
    setEditNegotiationOption,
    handleUpdate,
    handleDelete,
    handleMarkAsCompleted,
  };
};
