import { useQuery } from "@tanstack/react-query";
import { getUserReports } from "../api/getUserReports";

export const useUserReports = (userId: string | null) => {
  return useQuery({
    queryKey: ["userReports", userId],
    queryFn: () => getUserReports(userId!),
    enabled: !!userId,
  });
};
