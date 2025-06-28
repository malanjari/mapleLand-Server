// src/lib/hooks/useUser.ts
import { useAuthStore } from "@/lib/store/useAuthStore";

export const useUser = () => {
  const user = useAuthStore((state) => state.user);
  return user;
};

export const useAuthActions = () => {
  const { setToken, logout, initialize } = useAuthStore();
  return { setToken, logout, initialize };
};
