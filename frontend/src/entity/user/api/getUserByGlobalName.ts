import { API_BASE_URL } from "@/shared/config/api";

export async function getUserByGlobalName(globalName: string) {
  const token = localStorage.getItem("accessToken");
  try {
    const res = await fetch(
      `${API_BASE_URL}/api/admin/users/search?globalName=${encodeURIComponent(
        globalName
      )}`,
      {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "ngrok-skip-browser-warning": "true",
        },
      }
    );

    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(message || "유저 정보 조회 실패");
    }

    return res.json();
  } catch (err) {
    console.error("getUserByGlobalName 에러:", err);
    throw err;
  }
}
