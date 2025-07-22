import * as Popover from "@radix-ui/react-popover";
import { Button } from "@/shared/ui/button/Button";
import { ServerColor } from "../../trade/ui/TradeCard";

interface Props {
  editServerColor: ServerColor;
  editPrice: number;
  editNegotiationOption: boolean;
  editComment: string;
  setEditServerColor: (v: "Red" | "Yellow" | "Green") => void;
  setEditPrice: (v: number) => void;
  setEditNegotiationOption: (v: boolean) => void;
  setEditComment: (v: string) => void;
  handleMarkAsCompleted: () => void;
  handleDelete: () => void;
  handleUpdate: () => void;
  showEditBox: boolean;
  setShowEditBox: (open: boolean) => void;
  handleBump: () => void;
}

export const EditJariPopover = ({
  editServerColor,
  editPrice,
  editNegotiationOption,
  editComment,
  setEditServerColor,
  setEditPrice,
  setEditNegotiationOption,
  setEditComment,
  handleMarkAsCompleted,
  handleDelete,
  handleUpdate,
  showEditBox,
  setShowEditBox,
  handleBump,
}: Props) => {
  return (
    <div className="relative flex items-center">
      <Popover.Root open={showEditBox} onOpenChange={setShowEditBox}>
        <Popover.Trigger asChild>
          <button className="text-xs text-gray-200 bg-zinc-700 px-2 py-0.5 rounded-sm hover:bg-zinc-600 hover:text-white border border-zinc-500 transition">
            수정
          </button>
        </Popover.Trigger>

        <Popover.Content
          side="bottom"
          align="start"
          sideOffset={4}
          className="w-[200px] z-50 bg-zinc-800 border border-zinc-700 rounded-md text-xs text-gray-300 p-3 flex flex-col gap-2 shadow-lg"
        >
          <form
            onSubmit={(e) => e.preventDefault()}
            className="flex flex-col gap-2"
          >
            {/* 색상 선택 */}
            <div className="flex flex-col gap-1">
              <label className="text-gray-400">맵 상태를 선택해주세요</label>
              <div className="flex gap-2">
                {["Red", "Yellow", "Green"].map((color) => {
                  const selected = editServerColor === color;
                  const base = color.toLowerCase();
                  return (
                    <button
                      key={color}
                      type="button"
                      onClick={() =>
                        setEditServerColor(color as "Red" | "Yellow" | "Green")
                      }
                      className={`px-2 py-1 rounded-sm border text-xs transition ${
                        selected
                          ? `bg-${base}-500 text-white border-${base}-500`
                          : `border-${base}-500 text-${base}-400 hover:bg-${base}-500 hover:text-white`
                      }`}
                    >
                      {color === "Red"
                        ? "빨채"
                        : color === "Yellow"
                        ? "노채"
                        : "초채"}
                    </button>
                  );
                })}
              </div>
            </div>

            {/* 가격 입력 */}
            <div className="flex flex-col gap-1">
              <label className="text-gray-400">가격</label>
              <input
                type="number"
                value={editPrice}
                onChange={(e) => setEditPrice(Number(e.target.value))}
                placeholder="거래 가격을 입력해주세요"
                className="bg-zinc-900 border border-zinc-600 rounded-sm px-2 py-1 text-sm text-white"
              />
            </div>

            {/* 흥정 체크 */}
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

            {/* 코멘트 */}
            <div className="flex flex-col gap-1">
              <label className="text-gray-400">거래 메모</label>
              <textarea
                rows={2}
                value={editComment}
                onChange={(e) => setEditComment(e.target.value)}
                placeholder="코멘트를 입력해주세요"
                className="bg-zinc-900 border border-zinc-600 rounded-sm px-2 py-1 text-sm text-white resize-none"
              />
            </div>

            {/* 거래 완료, 삭제 버튼 */}
            <Button
              variant="outline"
              type="button"
              className="px-3 py-1 text-xs text-blue-600 border border-blue-400 bg-white rounded-sm hover:bg-blue-50 transition h-auto"
              onClick={handleBump}
            >
              끌어 올리기
            </Button>
            <Button
              variant="blue"
              type="button"
              className="px-3 py-1 text-xs text-white rounded-sm transition h-auto"
              onClick={handleMarkAsCompleted}
            >
              거래 완료
            </Button>
            <button
              type="button"
              onClick={handleDelete}
              className="px-3 py-1 text-xs bg-red-600 text-white rounded-sm hover:bg-red-700 transition"
            >
              삭제
            </button>

            {/* 저장 / 취소 */}
            <div className="flex justify-end gap-2 pt-2">
              <button
                type="submit"
                onClick={handleUpdate}
                className="px-3 py-1 text-xs bg-zinc-700 border border-zinc-600 rounded-sm hover:bg-zinc-600 transition"
              >
                수정
              </button>
              <Popover.Close asChild>
                <button
                  type="button"
                  className="px-3 py-1 text-xs border border-zinc-500 rounded-sm hover:text-white transition"
                >
                  취소
                </button>
              </Popover.Close>
            </div>
          </form>
        </Popover.Content>
      </Popover.Root>
    </div>
  );
};
