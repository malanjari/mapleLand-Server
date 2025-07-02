export interface User {
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
  user: User;
  loggedIn: boolean;
}
