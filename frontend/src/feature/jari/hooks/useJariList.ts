// src/feature/jari/hooks/useJariList.ts
import { useQuery, UseQueryResult } from "@tanstack/react-query";
import { jariList } from "@/feature/jari/api/jariList";
import { JariItem } from "@/entity/trade/model/type";

export const useJariList = (keyword: string): UseQueryResult<JariItem[]> => {
  return useQuery({
    queryKey: ["jariList", keyword],
    queryFn: () => jariList(keyword),
    staleTime: 1000 * 60,
    retry: 1,
  });
};
