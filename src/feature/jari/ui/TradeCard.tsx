import { JariItem } from "@/entity/trade/model/type";
import { useUser } from "@/entity/user/hooks/useUser";
import { toast } from "@/shared/hooks/use-toast";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import * as Popover from "@radix-ui/react-popover";
import clsx from "clsx";
import { formatDistanceToNow } from "date-fns";
import { ko } from "date-fns/locale";
import { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";
import { jariEdit } from "../../trade/api/jariEdit";
import { jariDelete } from "../../trade/api/jariDelete";
interface Props {
  item: JariItem;
  refetch: () => void;
}

const TradeCard = ({ item, refetch }: Props) => {
  const user = useUser();
  const editBoxRef = useRef<HTMLFormElement>(null);
  const isOwner = user?.user?.userId === item.userId;
  const [showEditBox, setShowEditBox] = useState(false);
  const [editPrice, setEditPrice] = useState(item.price.toString());
  const [editComment, setEditComment] = useState(item.comment);
  const [editServerColor, setEditServerColor] = useState<
    "Red" | "Yellow" | "Green"
  >(item.serverColor as "Red" | "Yellow" | "Green");

  const [editNegotiationOption, setEditNegotiationOption] = useState(
    item.negotiationOption
  ); // boolean

  // 자리수정함수
  const handleUpdate = async () => {
    try {
      await jariEdit({
        mapId: item.userMapId,
        price: Number(editPrice),
        serverColor: editServerColor,
        comment: editComment,
        negotiationOption: editNegotiationOption,
      });
      refetch();
      toast({
        title: "수정 완료",
        description: "자리 정보가 성공적으로 수정되었습니다.",
      });
      setShowEditBox(false);
    } catch (err) {
      console.error("수정 실패:", err);
      alert("수정 중 오류가 발생했습니다.");
    }
  };
  //자리 삭제함수
  const handleDelete = async () => {
    const confirmed = window.confirm("정말로 삭제하시겠습니까?");
    if (!confirmed) return;

    try {
      await jariDelete(item.userMapId);
      toast({
        title: "삭제 완료",
        description: "자리 정보가 성공적으로 삭제되었습니다.",
      });
      setShowEditBox(false); // 수정 폼 닫기
      refetch();
    } catch (error) {
      console.log(error);
    }
  };
  // 바깥 클릭 감지
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
  return (
    <div
      className={clsx(
        "bg-neutral-800 text-white rounded-md py-4 px-2 lg:px-4 flex flex-col gap-3 items-start shadow transition duration-300",
        {
          "opacity-40 grayscale": item.isCompleted,
        }
      )}
    >
      <div className="flex items-center justify-center gap-3 w-full">
        {/* 몬스터 이미지 */}
        <img
          src={item.monsterImageUrl}
          alt={item.mapName}
          className="w-16 h-16 object-contain "
        />

        {/* 맵 이름 + 가격 */}
        <div className="flex flex-col   w-full ">
          <div className="flex justify-between items-center pb-1 border-b border-neutral-700  ">
            <p className="text-xs lg:text-base font-bold">
              {item.mapName.includes(":")
                ? item.mapName.split(":")[1].trim()
                : item.mapName}
            </p>
            <Link
              to={`/profile/${item.userId}`}
              className="flex gap-1 items-center cursor-pointer"
            >
              <img
                src={
                  item.userImage
                    ? `https://cdn.discordapp.com/avatars/${item.uniqueId}/${item.userImage}.png`
                    : "https://cdn.discordapp.com/embed/avatars/0.png"
                }
                alt="user avatar"
                className="w-4 h-4 lg:w-6 lg:h-6 rounded-full"
              />{" "}
              <span className="text-[10px] lg:text-xs">{item.globalName}</span>
            </Link>
          </div>
          <div className="text-sm text-gray-200 flex items-center  justify-between gap-1 border-b py-1 border-neutral-700 ">
            <div className="relative flex items-center gap-1  md:text-sm">
              {item.price.toLocaleString()}
              <img
                className="w-4 relative top-[1.3px]"
                src={mesoIcon}
                alt="메소"
              />
            </div>
            <span className="text-xs  ">
              {formatDistanceToNow(new Date(item.createTime), {
                addSuffix: true,
                locale: ko,
              })}
            </span>
          </div>
        </div>
      </div>

      {/* 협의 옵션 및 코멘트 */}
      <div className="w-full flex border-b pb-1 border-neutral-700 justify-between">
        <div className="flex items-center gap-2">
          {isOwner && (
            <div className="relative flex items-center">
              <Popover.Root>
                <Popover.Trigger asChild>
                  <button className="text-xs text-gray-200 bg-zinc-700 px-2 py-0.5 rounded-sm hover:bg-zinc-600 hover:text-white border border-zinc-500 transition">
                    수정
                  </button>
                </Popover.Trigger>

                <Popover.Content
                  side="bottom"
                  align="start"
                  className="w-[200px]  z-50 bg-zinc-800 border border-zinc-700 rounded-md text-xs text-gray-300 p-3 flex flex-col gap-2 shadow-lg"
                  sideOffset={4}
                >
                  <form
                    onSubmit={(e) => e.preventDefault()}
                    className="flex flex-col gap-2"
                  >
                    <div className="flex flex-col gap-1">
                      <label className="text-gray-400">
                        맵 상태를 선택해주세요
                      </label>
                      <div className="flex gap-2">
                        {["Red", "Yellow", "Green"].map((color) => (
                          <button
                            key={color}
                            type="button"
                            onClick={() =>
                              setEditServerColor(
                                color as "Red" | "Yellow" | "Green"
                              )
                            }
                            className={`px-2 py-1 rounded-sm border text-xs transition ${
                              editServerColor === color
                                ? `bg-${color.toLowerCase()}-500 text-white border-${color.toLowerCase()}-500`
                                : `border-${color.toLowerCase()}-500 text-${color.toLowerCase()}-400 hover:bg-${color.toLowerCase()}-500 hover:text-white`
                            }`}
                          >
                            {color === "Red"
                              ? "빨채"
                              : color === "Yellow"
                              ? "노채"
                              : "초채"}
                          </button>
                        ))}
                      </div>
                    </div>

                    {/* 가격 */}
                    <div className="flex flex-col gap-1">
                      <label className="text-gray-400">가격</label>
                      <input
                        type="number"
                        value={editPrice}
                        onChange={(e) => setEditPrice(e.target.value)}
                        placeholder="거래 가격을 입력해주세요"
                        className="bg-zinc-900 border border-zinc-600 rounded-sm px-2 py-1 text-sm text-white"
                      />
                    </div>

                    {/* 흥정 가능 */}
                    <div className="flex items-center gap-2">
                      <input
                        type="checkbox"
                        id="negotiation"
                        checked={editNegotiationOption}
                        onChange={(e) =>
                          setEditNegotiationOption(e.target.checked)
                        }
                        className="accent-zinc-500"
                      />
                      <label htmlFor="negotiation" className="text-sm">
                        흥정 가능
                      </label>
                    </div>

                    {/* 거래 메모 */}
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
          )}

          <span
            className={`
    inline-flex items-center gap-1 px-2 py-0.5 rounded-sm text-xs font-medium
    ${
      item.serverColor === "Red"
        ? "bg-red-100 text-red-600"
        : item.serverColor === "Yellow"
        ? "bg-yellow-100 text-yellow-700"
        : "bg-green-100 text-green-700"
    }
  `}
          >
            <span
              className={`
      w-2 h-2 rounded-full
      ${
        item.serverColor === "Red"
          ? "bg-red-400"
          : item.serverColor === "Yellow"
          ? "bg-yellow-400"
          : "bg-green-400"
      }
    `}
            />
            {item.serverColor === "Red"
              ? "빨채"
              : item.serverColor === "Yellow"
              ? "노채"
              : "초채"}
          </span>
          <span className="  truncate bg-zinc-800 text-xs text-gray-300  px-2 py-0.5 rounded-sm border border-zinc-600">
            {item.negotiationOption ? "흥정가능" : "흥정불가"}
          </span>
          <span
            className="max-w-[100px]  truncate bg-zinc-800 text-xs text-gray-300 italic px-2 py-0.5 rounded-sm border border-zinc-600"
            title={item.comment}
          >
            {item.comment}
          </span>
        </div>
      </div>
    </div>
  );
};

export default TradeCard;
