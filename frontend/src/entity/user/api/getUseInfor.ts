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
      const errorJson = await res.text();
      throw errorJson;
    }
    return await res.json();
  } catch (error) {
    console.error("getUserInfo error:", error);
    throw error;
  }
};
