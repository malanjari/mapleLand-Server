import { create } from "zustand";
import { getCurrentUser } from "@/entity/user/api/getCurrentUser";
import { AuthResponse } from "@/entity/user/model/type";

interface AuthStore {
  user: AuthResponse | null;
  initialized: boolean;
  setToken: (accessToken: string) => void;
  logout: () => void;
  initialize: () => void;
}

export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  initialized: false,

  setToken: (accessToken: string) => {
    try {
      localStorage.setItem("accessToken", accessToken);
    } catch (error) {
      console.error("Failed to set access token:", error);
    }
  },

  logout: () => {
    localStorage.removeItem("accessToken");
    set({ user: null, initialized: true });
  },

  initialize: async () => {
    const token = localStorage.getItem("accessToken");

    if (!token) {
      set({ user: null, initialized: true });
      return;
    }

    try {
      const user = await getCurrentUser();
      set({ user, initialized: true });
    } catch (error) {
      console.error("유저 정보를 가져오지 못했습니다:", error);
      set({ user: null, initialized: true });
    }
  },
}));
