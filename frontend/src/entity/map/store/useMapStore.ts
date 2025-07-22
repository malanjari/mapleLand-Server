import { create } from "zustand";
import { MapItem } from "@/entity/map/api/getAllMaps";

interface MapStore {
  allMaps: MapItem[] | null;
  setAllMaps: (maps: MapItem[]) => void;
}

export const useMapStore = create<MapStore>((set) => ({
  allMaps: (() => {
    const stored = localStorage.getItem("allMaps");
    return stored ? JSON.parse(stored) : null;
  })(),
  setAllMaps: (maps) => {
    localStorage.setItem("allMaps", JSON.stringify(maps));
    set({ allMaps: maps });
  },
}));
