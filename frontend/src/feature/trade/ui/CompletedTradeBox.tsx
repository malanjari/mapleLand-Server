export const CompletedTradeBox = () => {
  return (
    <div className="self-start bg-gradient-to-r from-neutral-700 to-neutral-800 border border-green-500 text-green-300 px-4 py-3 rounded-lg text-sm font-medium shadow-sm flex items-center gap-2 w-full">
      <span className="text-lg">✅</span>
      <span className="leading-snug">
        [엘나스] 설산정상2 — 5천만 메소{" "}
        <span className="text-green-400 text-sm">(2시간 전 거래 완료)</span>
      </span>
    </div>
  );
};
