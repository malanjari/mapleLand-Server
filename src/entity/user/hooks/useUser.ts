import { useAuthStore } from "@/entity/user/store/useAuthStore";

// 유저 정보만 가져오는 훅
export const useUser = () => {
  const user = useAuthStore((state) => state.user);
  return user;
};

// 유저 상태 초기화 여부 가져오는 훅
export const useAuthInitialized = () => {
  return useAuthStore((state) => state.initialized);
};

// 액션 묶음 훅
export const useAuthActions = () => {
  const { setToken, logout, initialize } = useAuthStore();
  return { setToken, logout, initialize };
};
