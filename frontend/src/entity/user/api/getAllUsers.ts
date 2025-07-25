import { API_BASE_URL } from "@/shared/config/api";
import { AdminUsersInfo } from "../model/type";

export const getAdminallUsers = async (
  page: number
): Promise<AdminUsersInfo[]> => {
  const token = localStorage.getItem("accessToken");
  try {
    const res = await fetch(`${API_BASE_URL}/api/admin/users?page=${page}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "ngrok-skip-browser-warning": "true",
        Authorization: `Bearer ${token}`,
      },
    });

    const data = await res.json();
    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(message || "유저 정보를 불러오는 데 실패했습니다.");
    }
    return data;
  } catch (error) {
    console.error("getUserInfo error:", error);
    throw error;
  }
};
