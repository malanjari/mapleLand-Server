interface TradeBadgesProps {
  serverColor: "Red" | "Yellow" | "Green";
  negotiationOption: boolean;
  comment: string;
}

export const TradeBadges = ({
  serverColor,
  negotiationOption,
  comment,
}: TradeBadgesProps) => {
  const bgClass =
    serverColor === "Red"
      ? "bg-red-100 text-red-600"
      : serverColor === "Yellow"
      ? "bg-yellow-100 text-yellow-700"
      : "bg-green-100 text-green-700";

  const dotClass =
    serverColor === "Red"
      ? "bg-red-400"
      : serverColor === "Yellow"
      ? "bg-yellow-400"
      : "bg-green-400";

  const label =
    serverColor === "Red" ? "빨채" : serverColor === "Yellow" ? "노채" : "초채";

  return (
    <div className="flex gap-1 ">
      {/* 서버 색상 뱃지 */}
      <span
        className={`inline-flex items-center gap-1 px-2 py-0.5 rounded-sm text-xs font-medium ${bgClass}`}
      >
        <span className={`w-2 h-2 rounded-full ${dotClass}`} />
        {label}
      </span>

      {/* 흥정 여부 뱃지 */}
      <span className="truncate bg-zinc-800 text-xs text-gray-300 px-2 py-0.5 rounded-sm border border-zinc-600">
        {negotiationOption ? "흥정가능" : "흥정불가"}
      </span>

      {/* 코멘트 뱃지 */}
      <div className="flex relative group">
        <span className="max-w-[70px] truncate bg-gray-300 text-xs text-black italic px-2 py-0.5 rounded-sm border border-zinc-500 shadow-sm">
          {comment}
        </span>

        {/* 툴팁 */}
        <div className="absolute bottom-full left-1/2 mb-1 -translate-x-1/2 w-[120px] px-2 py-1 rounded bg-neutral-900 text-white text-xs opacity-0 group-hover:opacity-100 hover:opacity-100 transition pointer-events-auto z-10 break-words">
          {comment}
        </div>
      </div>
    </div>
  );
};
