import { API_BASE_URL } from "@/shared/config/api";

export const getAdminJari = async () => {
  try {
    const token = localStorage.getItem("accessToken");

    const res = await fetch(`${API_BASE_URL}/api/admin/jari`, {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
        Authorization: `Bearer ${token}`,
      },
    });

    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(message || "관리자 자리 리스트 로딩 실패");
    }

    const data = await res.json();

    return data;
  } catch (err) {
    console.error("adminJari 에러:", err);
    throw err;
  }
};
