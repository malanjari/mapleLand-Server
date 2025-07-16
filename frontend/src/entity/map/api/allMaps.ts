import { API_BASE_URL } from "@/shared/config/api";

export interface MapItem {
  mapId: number;
  mapName: string;
  miniMapImageLogoUrl: string;
  monsterImageUrl: string;
  miniMapImageUrl: string;
}

export const fetchAllMaps = async (): Promise<MapItem[]> => {
  try {
    const res = await fetch(`${API_BASE_URL}/api/maps/all`, {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
      },
    });

    if (!res.ok) {
      const text = await res.text();
      console.error("fetchAllMaps 응답 오류:", text);
      throw new Error("전체 맵 정보 불러오기 실패");
    }

    const json = await res.json();

    return json.MapNameList;
  } catch (err) {
    console.error("fetchAllMaps 에러:", err);
    throw err;
  }
};
