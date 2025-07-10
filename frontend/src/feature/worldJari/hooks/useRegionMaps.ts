import { useQuery } from "@tanstack/react-query";
import { getRegionMaps } from "@/feature/worldJari/api/worldJari";
import { RegionMap } from "@/feature/worldJari/api/worldJari";

export const useRegionMaps = (keyword: string) => {
  return useQuery<RegionMap[]>({
    queryKey: ["regionMaps", keyword],
    queryFn: () => getRegionMaps(keyword),
    enabled: !!keyword, // keyword 없으면 fetch 안 함
    staleTime: 1000 * 60, // 1분간 캐시 유지
    retry: 1,
  });
};
