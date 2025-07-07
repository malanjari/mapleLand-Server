import { JariItem } from "@/entity/trade/model/type";

import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import clsx from "clsx";
import { formatDistanceToNow } from "date-fns";
import { ko } from "date-fns/locale";
import { Link } from "react-router-dom";
interface Props {
  item: JariItem;
}

const TradeCard = ({ item }: Props) => {
  return (
    <div
      className={clsx(
        "bg-neutral-800 text-white rounded-md py-4 px-2 lg:px-4 flex flex-col gap-3 items-start shadow transition duration-300",
        {
          "opacity-40 grayscale pointer-events-none": item.isCompleted,
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
