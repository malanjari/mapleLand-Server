// src/features/trade/ui/TradeEditForm.tsx
import { JariItem } from "@/entity/trade/model/type";
import { toast } from "@/shared/hooks/use-toast";
import { jariEdit } from "../jariEdit";
import { jariDelete } from "../jariDelete";
import clsx from "clsx";
import { useTradeEditForm } from "@/entity/trade/hooks/useTradeEditForms";

interface Props {
  item: JariItem;
  refetch: () => void;
  onClose: () => void;
}

export const TradeEditForm = ({ item, refetch, onClose }: Props) => {
  const {
    editBoxRef,
    editPrice,
    editComment,
    editServerColor,
    editNegotiationOption,
    setEditPrice,
    setEditComment,
    setEditServerColor,
    setEditNegotiationOption,
  } = useTradeEditForm(item, onClose);

  const handleUpdate = async () => {
    try {
      await jariEdit({
        mapId: item.userMapId,
        price: Number(editPrice),
        serverColor: editServerColor,
        comment: editComment,
        negotiationOption: editNegotiationOption,
      });
      toast({ title: "수정 완료", description: "자리 정보가 수정되었습니다." });
      refetch();
      onClose();
    } catch (err: unknown) {
      let message = "알 수 없는 오류가 발생했습니다.";

      if (typeof err === "object" && err !== null && "message" in err) {
        message = (err as { message?: string }).message ?? message;
      }
      toast({
        title: "수정 실패",
        description: message,
        variant: "destructive",
      });
    }
  };

  const handleDelete = async () => {
    const confirmed = window.confirm("정말 삭제하시겠습니까?");
    if (!confirmed) return;
    try {
      await jariDelete(item.userMapId);
      toast({ title: "삭제 완료", description: "삭제되었습니다." });
      refetch();
      onClose();
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <form
      ref={editBoxRef}
      onSubmit={(e) => e.preventDefault()}
      className="flex flex-col gap-2"
    >
      <div className="flex flex-col gap-1">
        <label className="text-gray-400">맵 상태를 선택해주세요</label>
        <div className="flex gap-2">
          {["Red", "Yellow", "Green"].map((color) => (
            <button
              key={color}
              type="button"
              onClick={() =>
                setEditServerColor(color as "Red" | "Yellow" | "Green")
              }
              className={clsx(
                "px-2 py-1 rounded-sm border text-xs transition",
                editServerColor === color
                  ? `bg-${color.toLowerCase()}-500 text-white border-${color.toLowerCase()}-500`
                  : `border-${color.toLowerCase()}-500 text-${color.toLowerCase()}-400 hover:bg-${color.toLowerCase()}-500 hover:text-white`
              )}
            >
              {color === "Red" ? "빨채" : color === "Yellow" ? "노채" : "초채"}
            </button>
          ))}
        </div>
      </div>

      <div className="flex flex-col gap-1">
        <label className="text-gray-400">가격</label>
        <input
          type="number"
          value={editPrice}
          onChange={(e) => setEditPrice(e.target.value)}
          className="bg-zinc-900 border border-zinc-600 rounded-sm px-2 py-1 text-sm text-white"
        />
      </div>

      <div className="flex items-center gap-2">
        <input
          type="checkbox"
          id="negotiation"
          checked={editNegotiationOption}
          onChange={(e) => setEditNegotiationOption(e.target.checked)}
          className="accent-zinc-500"
        />
        <label htmlFor="negotiation" className="text-sm">
          흥정 가능
        </label>
      </div>

      <div className="flex flex-col gap-1">
        <label className="text-gray-400">거래 메모</label>
        <textarea
          rows={2}
          value={editComment}
          onChange={(e) => setEditComment(e.target.value)}
          className="bg-zinc-900 border border-zinc-600 rounded-sm px-2 py-1 text-sm text-white resize-none"
        />
      </div>

      <button
        type="button"
        onClick={handleDelete}
        className="px-3 py-1 text-xs bg-red-600 text-white rounded-sm hover:bg-red-700 transition"
      >
        삭제
      </button>

      <div className="flex justify-end gap-2 pt-2">
        <button
          type="submit"
          onClick={handleUpdate}
          className="px-3 py-1 text-xs bg-zinc-700 border border-zinc-600 rounded-sm hover:bg-zinc-600 transition"
        >
          저장
        </button>
        <button
          type="button"
          onClick={onClose}
          className="px-3 py-1 text-xs border border-zinc-500 rounded-sm hover:text-white transition"
        >
          취소
        </button>
      </div>
    </form>
  );
};
