export type TradeType = "BUY" | "SELL";

export interface JariItem {
  userMapId: string;
  mapName: string;
  price: number;
  tradeType: TradeType;
  monsterImageUrl: string;
  negotiationOption: boolean;
  area: string;
  comment: string;
  serverColor: string;
  createTime: string;
  userImage: string;
  uniqueId: string;
  globalName: string;
  miniMapImageLogo: string;
  userId: string | number;
  isCompleted: boolean;
}
