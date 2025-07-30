import { AuthResponse } from "../model/type";
import { API_BASE_URL } from "@/shared/constants/api";
export const getCurrentUser = async (): Promise<AuthResponse> => {
  const token = localStorage.getItem("accessToken");

  const res = await fetch(`${API_BASE_URL}/api/user`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
      "ngrok-skip-browser-warning": "true",
    },
  });

  if (!res.ok) {
    throw new Error("유저 정보를 불러오는 데 실패했습니다");
  }

  const data = await res.json();

  return data;
};
