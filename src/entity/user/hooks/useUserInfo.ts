import { useQuery } from "@tanstack/react-query";
import { getUserInfo } from "@/entity/user/api/user";
import { User } from "@/entity/user/model/type"; // 필요 시 import

export const useUserInfo = (userId: string | undefined) => {
  return useQuery<User>({
    queryKey: ["userInfo", userId],
    queryFn: () => getUserInfo(userId!),
    enabled: !!userId, // userId가 있을 때만 fetch 실행
    staleTime: 1000 * 60, // 1분간 캐시
    retry: 1,
  });
};
