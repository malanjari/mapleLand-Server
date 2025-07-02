import { create } from "zustand";
import { getCurrentUser } from "@/entity/user/api/user";
import { AuthResponse } from "@/entity/user/model/type";

interface AuthStore {
  user: AuthResponse | null; // ✅ null 허용
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
      const authResponse: AuthResponse = await getCurrentUser();
      set({ user: authResponse }); //
    } catch (err) {
      console.error("유저 정보를 가져오지 못했습니다:", err);
    }
  },
}));
