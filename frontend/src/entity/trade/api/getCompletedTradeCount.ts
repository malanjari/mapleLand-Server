import { API_BASE_URL } from "@/shared/constants/api";

export interface CompletedTradeStats {
  completionTime: string;
  count: number;
}

export const getMonthlyCompletedTradeStats = async (
  year: number,
  month: number
): Promise<CompletedTradeStats[]> => {
  const token = localStorage.getItem("accessToken");
  try {
    const res = await fetch(
      `${API_BASE_URL}/api/admin/trade/completed-count?year=${year}&month=${month}`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          "ngrok-skip-browser-warning": "true",
          Authorization: `Bearer ${token}`,
        },
      }
    );

    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(
        message || "완료된 거래 통계를 불러오는 데 실패했습니다."
      );
    }

    const data = await res.json();
    return data;
  } catch (error) {
    console.error("getCompletedTradeStats error:", error);
    throw error;
  }
};
