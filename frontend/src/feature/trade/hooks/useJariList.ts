// src/feature/jari/hooks/useJariList.ts
import { useQuery, UseQueryResult } from "@tanstack/react-query";
import { getJariList } from "@/entity/jari/api/getJariList";
import { JariItem } from "@/entity/jari/model/type";

export const useJariList = (keyword: string): UseQueryResult<JariItem[]> => {
  return useQuery({
    queryKey: ["jariList", keyword],
    queryFn: () => getJariList(keyword),
    staleTime: 1000 * 60,
    retry: 1,
  });
};
