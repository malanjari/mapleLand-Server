import { create } from "zustand";

import { getCurrentUser } from "@/entity/user/api/user";
import { User } from "@/entity/user/model/type";

interface AuthStore {
  user: User | null;
  setToken: (accessToken: string) => void;
  logout: () => void;
  initialize: () => void;
}

export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  setToken: (accessToken: string) => {
    try {
      localStorage.setItem("accessToken", accessToken);
    } catch (err) {
      console.error("Invalid access token:", err);
    }
  },
  logout: () => {
    localStorage.removeItem("accessToken");

    set({ user: null });
  },
  initialize: async () => {
    const token = localStorage.getItem("accessToken");
    if (!token) return;
    try {
      // 1. 서버로부터 유저 정보 가져오기
      const user: User = await getCurrentUser();
      // 2. Zustand에 저장
      set({ user });
    } catch (err) {
      console.error("유저 정보를 가져오지 못했습니다:", err);
    }
  },
}));
