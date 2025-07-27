import { API_BASE_URL } from "@/shared/config/api";
import { JariItem } from "../../jari/model/type";

export const getRecentCompletedTrades = async (): Promise<JariItem[]> => {
  try {
    const response = await fetch(`${API_BASE_URL}/api/jari/recent`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    });

    if (!response.ok) {
      throw new Error(`요청 실패: ${response.status}`);
    }

    const data = await response.json();

    if (!Array.isArray(data)) {
      throw new Error("응답 형식이 배열이 아님");
    }

    return data;
  } catch (error) {
    console.error("최근 완료된 거래 불러오기 실패:", error);
    return []; // 실패 시 빈 배열 반환
  }
};
