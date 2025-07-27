import { create } from "zustand";

export interface Trade {
  mapName: string;
  price: number;
  tradeType: "SELL" | "BUY";
}

interface RecentTradeStore {
  recentTrade: Trade | null;
  setRecentTrade: (trade: Trade) => void;
}

export const useRecentTradeStore = create<RecentTradeStore>((set) => ({
  recentTrade: null,
  setRecentTrade: (trade) => set({ recentTrade: trade }),
}));
