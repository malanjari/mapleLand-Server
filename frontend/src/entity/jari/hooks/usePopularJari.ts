import { useQuery } from "@tanstack/react-query";
import { getPopularJari } from "../api/getPopularJari";

export const usePopularJari = () => {
  return useQuery({
    queryKey: ["popularJari"],
    queryFn: getPopularJari,
    refetchInterval: 1000 * 60 * 9,
    staleTime: 1000 * 60 * 9,
    refetchOnWindowFocus: false,
  });
};
