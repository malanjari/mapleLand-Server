export type TradeType = "sell" | "buy";

export interface JariItem {
  id: string;
  name: string;
  seller: string;
  price: number;
  postedMinutesAgo: number;
  type: TradeType;
}
