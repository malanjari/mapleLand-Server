import { useQuery } from "@tanstack/react-query";
import { getPopularJari } from "../api/getPopularJari";

export const usePopularJari = () => {
  return useQuery({
    queryKey: ["popularJari"],
    queryFn: getPopularJari,
    staleTime: 1000 * 60 * 9, // 9분 (백엔드와 오차 보정)
  });
};
