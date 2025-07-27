import { useRecentTradeStore } from "@/entity/trade/store/useRecentTradeStore";

export const useLatestCompletedTrade = () => {
  const trade = useRecentTradeStore((s) => s.recentTrade);
  return trade;
};
