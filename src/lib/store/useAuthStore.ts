import { create } from "zustand";
import { jwtDecode } from "jwt-decode";

interface User {
  username: string;
  discordId: string;
  globalName: string;
  role: string;
  avatar?: string;
  exp: number;
}

interface AuthStore {
  user: User | null;
  setToken: (token: string) => void;
  logout: () => void;
  initialize: () => void;
}

export const useAuthStore = create<AuthStore>((set) => ({
  user: null,
  setToken: (token: string) => {
    const decoded = jwtDecode<User>(token);
    localStorage.setItem("accessToken", token);
    set({ user: decoded });
  },
  logout: () => {
    localStorage.removeItem("accessToken");
    set({ user: null });
  },
  initialize: () => {
    const token = localStorage.getItem("accessToken");
    if (token) {
      try {
        const decoded = jwtDecode<User>(token);
        set({ user: decoded });
      } catch (err) {
        console.error("Invalid token:", err);
        localStorage.removeItem("accessToken");
      }
    }
  },
}));
