import { API_BASE_URL } from "@/shared/config/api";
export type DropItem = {
  dropRate: number;
  itemImageUrl: string;
  mapName: string;
  itemName: string;
};
export const getMonsterInfo = async (keyword: string) => {
  try {
    const res = await fetch(
      `${API_BASE_URL}/api/monsterInfo?keyword=${encodeURIComponent(keyword)}`,
      {
        method: "GET",
        headers: {
          "ngrok-skip-browser-warning": "true",
        },
      }
    );

    if (!res.ok) {
      const text = await res.text();
      console.error("getMonsterInfo 응답 오류:", text);
      throw new Error("몬스터 정보 로딩 실패");
    }

    const json = await res.json();

    return json;
  } catch (err) {
    console.error("getMonsterInfo 에러:", err);
    throw err;
  }
};
