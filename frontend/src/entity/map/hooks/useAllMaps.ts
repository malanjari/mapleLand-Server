// src/entity/jari/hooks/useAllMaps.ts
import { useQuery } from "@tanstack/react-query";
import { fetchAllMaps } from "../api/allMaps";

export const useAllMaps = () => {
  return useQuery({
    queryKey: ["allMaps"],
    queryFn: fetchAllMaps,
    staleTime: 1000 * 60 * 60,
  });
};
