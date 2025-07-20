import { useQuery } from "@tanstack/react-query";
import { getUserInfo } from "@/entity/user/api/getUseInfor";
import { User } from "@/entity/user/model/type"; // 필요 시 import
import { RegionMap } from "@/entity/jari/api/getWorldJari";
export interface UserInfoResponse {
  userInfo: User;
  mapRegistrations: RegionMap[];
}
export const useUserInfo = (userId: string | undefined) => {
  return useQuery<UserInfoResponse>({
    queryKey: ["userInfo", userId],
    queryFn: () => getUserInfo(userId!),
    enabled: !!userId, // userId가 있을 때만 fetch 실행
    staleTime: 1000 * 60, // 1분간 캐시
    retry: 1,
  });
};
