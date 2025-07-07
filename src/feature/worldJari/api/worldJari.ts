import { API_BASE_URL } from "@/shared/config/api";
export interface RegionMap {
  area: string;
  comment: string;
  createTime: string;
  globalName: string;
  mapName: string;
  miniMapImageLogo: string;
  monsterImageUrl: string;
  negotiationOption: boolean;
  price: number;
  serverColor: string;
  socialId: string;
  tradeType: "SELL" | "BUY";
  uniqueId: string;
  userId: number;
  userImage: string;
  userMapId: string;
  isCompleted: boolean;
}
export const getRegionMaps = async (keyword: string): Promise<RegionMap[]> => {
  try {
    const res = await fetch(`${API_BASE_URL}/api/region?keyword=${keyword}`, {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
      },
    });

    if (!res.ok) {
      const text = await res.text();
      console.error("fetchRegionMaps 응답 오류:", text);
      throw new Error("지역 맵 로딩 실패");
    }

    const json = await res.json();
    console.log("📍 fetchRegionMaps 응답:", json);
    return json;
  } catch (err) {
    console.error("fetchRegionMaps 에러:", err);
    throw err;
  }
};
