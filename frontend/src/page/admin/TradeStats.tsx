import { useState } from "react";
import { TradeStatsChart } from "@/feature/trade/ui/TradeStatsChart";

const TradeStatsPage = () => {
  const today = new Date();
  const [selectedDate, setSelectedDate] = useState(today);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedDate(new Date(e.target.value));
  };

  const year = selectedDate.getFullYear();
  const month = selectedDate.getMonth() + 1; // 0-indexed → 1월이면 0

  return (
    <div className="p-6">
      <h1 className="text-2xl font-bold text-white mb-4">
        📊 월간 거래 완료 통계
      </h1>

      <label className="text-white font-medium mb-2 block">
        날짜 선택:
        <input
          type="month"
          value={`${year}-${month.toString().padStart(2, "0")}`}
          onChange={handleChange}
          className="ml-2 p-2 rounded bg-neutral-700 text-white"
        />
      </label>

      <TradeStatsChart year={year} month={month} />
    </div>
  );
};
export default TradeStatsPage;
