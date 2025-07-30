import { API_BASE_URL } from "@/shared/constants/api";

export const getBannedUsers = async () => {
  const token = localStorage.getItem("accessToken");

  try {
    const res = await fetch(`${API_BASE_URL}/api/admin/users/banned`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "ngrok-skip-browser-warning": "true",
        Authorization: `Bearer ${token}`,
      },
    });

    const data = await res.json();

    if (!res.ok) {
      const message = data?.message || "밴 유저 목록 불러오기 실패";
      throw new Error(message);
    }

    return data;
  } catch (err) {
    console.error("getBannedUsers error:", err);
    throw err;
  }
};
