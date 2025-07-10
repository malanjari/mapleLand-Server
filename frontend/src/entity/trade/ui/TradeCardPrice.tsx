import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import { JariItem } from "@/entity/trade/model/type";
import { formatDistanceToNow } from "date-fns";
import { ko } from "date-fns/locale";
import clsx from "clsx";

const TradeCardPrice = ({ item }: { item: JariItem }) => (
  <div className="w-full flex flex-col gap-2 border-b border-neutral-700 pb-2">
    {/* 💰 가격 + 등록 시간 */}
    <div className="text-sm text-gray-200 flex items-center justify-between gap-1">
      <div className="relative flex items-center gap-1 md:text-sm">
        {item.price.toLocaleString()}
        <img className="w-4 relative top-[1.3px]" src={mesoIcon} alt="메소" />
      </div>
      <span className="text-xs">
        {formatDistanceToNow(new Date(item.createTime), {
          addSuffix: true,
          locale: ko,
        })}
      </span>
    </div>

    {/* 서버 색상, 흥정 여부, 메모 뱃지 */}
    <div className="flex flex-wrap items-center gap-2 text-xs">
      {/* 서버 색상 */}
      <span
        className={clsx(
          "inline-flex items-center gap-1 px-2 py-0.5 rounded-sm font-medium",
          item.serverColor === "Red"
            ? "bg-red-100 text-red-600"
            : item.serverColor === "Yellow"
            ? "bg-yellow-100 text-yellow-700"
            : "bg-green-100 text-green-700"
        )}
      >
        <span
          className={clsx(
            "w-2 h-2 rounded-full",
            item.serverColor === "Red"
              ? "bg-red-400"
              : item.serverColor === "Yellow"
              ? "bg-yellow-400"
              : "bg-green-400"
          )}
        />
        {item.serverColor === "Red"
          ? "빨채"
          : item.serverColor === "Yellow"
          ? "노채"
          : "초채"}
      </span>

      {/* 흥정 가능 여부 */}
      <span className="truncate bg-zinc-800 text-gray-300 px-2 py-0.5 rounded-sm border border-zinc-600">
        {item.negotiationOption ? "흥정가능" : "흥정불가"}
      </span>

      {/* 거래 메모 */}
      {item.comment && (
        <span
          className="max-w-[100px] truncate bg-zinc-800 text-gray-300 italic px-2 py-0.5 rounded-sm border border-zinc-600"
          title={item.comment}
        >
          {item.comment}
        </span>
      )}
    </div>
  </div>
);

export default TradeCardPrice;
