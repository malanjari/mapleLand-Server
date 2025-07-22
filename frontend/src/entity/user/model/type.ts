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
// 다른유저
export interface User {
  discordId: string;
  email: string;
  userName: string;
  globalName: string;
  image?: string;
  mapTicket: boolean;
  createTime: string;
  userId: number;
  isActive: boolean;
}

export interface AdminUsersInfo {
  discordId: string;
  image: string;
  createTime: string;
  role: string;
  userId: number;
  userName: string;
  reportedCount: number;
  globalName: string;
}
export interface BannedUserInfo {
  userId: number;
  userName: string;
  discordId: string;
  globalName: string;
  role: string;
  email: string;
  mapTicket: boolean;
  pianusTicket: number;
  manonTicket: number;
  banedReason: string;
  image: string;
  createTime: string; // ISO 8601
  reportedCount: number;
  bannedHours: string; // ISO 8601
}
