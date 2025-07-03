import { API_BASE_URL } from "@/shared/config/api";
export interface PopularMap {
  mapName: string;
  registerCount: number;
  area: string;
  monsterImageUrl: string;
}

export const fetchPopularMaps = async (): Promise<PopularMap[]> => {
  try {
    const res = await fetch(`${API_BASE_URL}/api/popular`, {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
      },
    });

    if (!res.ok) {
      const text = await res.text();
      console.error("fetchPopularMaps 응답 오류:", text);
      throw new Error("인기 맵 로딩 실패");
    }

    const json = await res.json();
    console.log(json);
    return json;
  } catch (err) {
    console.error("fetchPopularMaps 에러:", err);
    throw err;
  }
};
