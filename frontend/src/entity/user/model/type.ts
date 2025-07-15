export interface Me {
  id: string; // Discord ID
  userId: number; // 내부 DB ID
  username: string;
  globalName: string;
  role: string;
  avatar?: string;
  exp: string; // ISO8601 형식
  iat: string; // ISO8601 형식
}
export interface AuthResponse {
  user: Me;
  loggedIn: boolean;
  alertDtoList: AlertDto[];
}
export interface AlertDto {
  mapId: number;
  alertStatus: "ALERT_ON" | "ALERT_OFF";
}
// 프로필 API 응답용 (다른 유저든 내 정보든)
export interface User {
  discordId: string;
  email: string;
  userName: string;
  globalName: string;
  image?: string;
  mapTicket: boolean;
  createTime: string;
}
