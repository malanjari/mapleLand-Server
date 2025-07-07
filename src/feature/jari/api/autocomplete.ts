// src/shared/api/map/autocomplete.ts
import { API_BASE_URL } from "@/shared/config/api";

export interface MapItem {
  mapleLandMapListId: number;
  mapName: string;
  region: string;
  subRegion: string;
  monsterImageUrl: string;
  miniMapImageUrl: string;
  miniMapImageLogoUrl: string;
}

export const fetchAutocomplete = async (
  keyword: string,
  signal?: AbortSignal
): Promise<MapItem[]> => {
  const trimmed = keyword.trim();
  if (!trimmed) return [];

  const res = await fetch(
    `${API_BASE_URL}/api/map/autocomplete?keyword=${encodeURIComponent(
      trimmed
    )}`,
    {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
      },
      signal,
    }
  );

  if (!res.ok) {
    const { message } = await res.json();
    throw new Error(message || "자동완성 요청 실패");
  }

  return res.json();
};
