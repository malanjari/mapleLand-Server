// src/entity/jari/hooks/useAllMaps.ts
import { useQuery } from "@tanstack/react-query";
import { getAllMaps } from "../api/getAllMaps";

export const useAllMaps = () => {
  return useQuery({
    queryKey: ["allMaps"],
    queryFn: getAllMaps,
    staleTime: Infinity,
  });
};
