import { API_BASE_URL } from "@/shared/config/api";

export const getUserInfo = async (userId: string) => {
  try {
    const res = await fetch(`${API_BASE_URL}/api/user/${userId}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "ngrok-skip-browser-warning": "true",
      },
    });
    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(message || "유저 정보를 불러오는 데 실패했습니다.");
    }
    const data = await res.json();
    return data;
  } catch (error) {
    console.error("getUserInfo error:", error);
    throw error;
  }
};
