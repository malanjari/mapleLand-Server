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

  try {
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
      const errorRes = await res.json();
      throw new Error(errorRes?.message || "자동완성 요청 실패");
    }

    const data: MapItem[] = await res.json();
    return data;
  } catch (err) {
    console.error("fetchAutocomplete 에러:", err);
    throw new Error("자동완성 요청 중 에러 발생");
  }
};
