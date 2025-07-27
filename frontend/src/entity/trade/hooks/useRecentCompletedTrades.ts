import { useQuery } from "@tanstack/react-query";
import { getRecentCompletedTrades } from "../api/getRecentCompletedTrades";
import { JariItem } from "../../jari/model/type";

export const useRecentCompletedTrades = () => {
  return useQuery<JariItem[]>({
    queryKey: ["recent-completed-trades"],
    queryFn: getRecentCompletedTrades,
    staleTime: 0,
    refetchInterval: 60000,
    gcTime: 1000 * 60 * 5,
  });
};
