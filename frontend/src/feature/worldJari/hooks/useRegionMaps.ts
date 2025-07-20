import { useQuery } from "@tanstack/react-query";
import { getWorldJari } from "@/entity/jari/api/getWorldJari";
import { RegionMap } from "@/entity/jari/api/getWorldJari";

export const useRegionMaps = (keyword: string) => {
  return useQuery<RegionMap[]>({
    queryKey: ["regionMaps", keyword],
    queryFn: () => getWorldJari(keyword),
    enabled: !!keyword, // keyword 없으면 fetch 안 함
    staleTime: 1000 * 60, // 1분간 캐시 유지
    retry: 1,
  });
};
