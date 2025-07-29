import { API_BASE_URL } from "@/shared/constants/api";
import { UserReportsResponse } from "../model/type";

export const getUserReports = async (
  userId: string
): Promise<UserReportsResponse> => {
  try {
    const token = localStorage.getItem("accessToken");
    if (!token) throw new Error("인증 토큰이 없습니다.");

    const res = await fetch(
      `${API_BASE_URL}/api/admin/reports/users/${userId}`,
      {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "ngrok-skip-browser-warning": "true",
        },
      }
    );

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }

    const data = await res.json();
    return data;
  } catch (error) {
    console.error("❌ 사용자 신고 내역 불러오기 실패:", error);
    throw error;
  }
};
