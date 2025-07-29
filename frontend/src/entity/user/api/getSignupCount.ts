import { API_BASE_URL } from "@/shared/constants/api";

export const getMonthlySignupStats = async (year: number, month: number) => {
  const token = localStorage.getItem("accessToken");

  try {
    const res = await fetch(
      `${API_BASE_URL}/api/admin/users/signup-count?year=${year}&month=${month}`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
          "ngrok-skip-browser-warning": "true",
          Authorization: `Bearer ${token}`,
        },
      }
    );

    const data = await res.json();

    if (!res.ok) {
      const { message } = data;
      throw new Error(
        message || "가입자 수 데이터를 불러오는 데 실패했습니다."
      );
    }

    return data; // ex) [{ date: "2025-07-01", count: 10 }, ...]
  } catch (error) {
    console.error("getMonthlySignupStats error:", error);
    throw error;
  }
};
