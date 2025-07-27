import { useEffect, useState } from "react";
import { API_BASE_URL } from "@/shared/config/api";

export interface CompletedTrade {
  jariId: number;
  mapName: string;
  globalName: string;
  tradeType: "SELL" | "BUY";
  price: number;
  completedTime: string;
  completed: boolean;
}

export const useLatestCompletedTrade = () => {
  const [trade, setTrade] = useState<CompletedTrade | null>(null);

  useEffect(() => {
    const eventSource = new EventSource(`${API_BASE_URL}/sse/jari`);

    const handleCompleted = (e: MessageEvent) => {
      const data: CompletedTrade = JSON.parse(e.data);
      setTrade(data); // 항상 마지막 거래 하나만 유지
    };

    eventSource.addEventListener("jari-complete", handleCompleted);

    return () => {
      eventSource.removeEventListener("jari-complete", handleCompleted);
      eventSource.close();
    };
  }, []);

  return trade;
};
