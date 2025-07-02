import { create } from "zustand";
import { getCurrentUser } from "@/entity/user/api/user";
import { User } from "@/entity/user/model/type";

interface AuthStore {
  user: User | null;
  initialized: boolean;
  setToken: (accessToken: string) => void;
  logout: () => void;
  initialize: () => void;
}

export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  initialized: false, // ✅ 초기값 false
  setToken: (accessToken: string) => {
    try {
      localStorage.setItem("accessToken", accessToken);
    } catch (err) {
      console.error("Invalid access token:", err);
    }
  },
  logout: () => {
    localStorage.removeItem("accessToken");
    set({ user: null, initialized: true }); // ✅ 로그아웃 시에도 초기화 완료 상태로
  },
  initialize: async () => {
    const token = localStorage.getItem("accessToken");
    if (!token) {
      set({ user: null, initialized: true }); // ✅ 토큰 없을 경우에도 완료 표시
      return;
    }
    try {
      const user = await getCurrentUser();
      set({ user, initialized: true });
    } catch (err) {
      console.error("유저 정보를 가져오지 못했습니다:", err);
      set({ user: null, initialized: true }); // ✅ 실패해도 초기화는 완료해야 함
    }
  },
}));
