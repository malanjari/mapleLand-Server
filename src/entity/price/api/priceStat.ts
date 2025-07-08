import { API_BASE_URL } from "@/shared/config/api";

export interface DailyPriceStat {
  dateTime: string; // ex: "2025-07-01T00:00:00"
  price: number;
}

export const getPriceStat = async (
  keyword: string
): Promise<DailyPriceStat[]> => {
  try {
    const res = await fetch(
      `${API_BASE_URL}/api/maps/price-stat?keyword=${encodeURIComponent(
        keyword
      )}`,
      {
        headers: {
          "ngrok-skip-browser-warning": "true",
        },
      }
    );
    const data = await res.json();
    if (!res.ok) {
      const errorMessage =
        typeof data === "string"
          ? data
          : data?.message || "알 수 없는 서버 오류";

      throw new Error(errorMessage);
    }

    return data;
  } catch (error) {
    console.error("가격 통계 데이터를 불러오는 중 에러 발생:", error);
    throw error; // 상위에서 useQuery 등으로 핸들링
  }
};
