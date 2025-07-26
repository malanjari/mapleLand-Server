import { API_BASE_URL } from "@/shared/config/api";

export const getJariList = async (keyword: string) => {
  try {
    const res = await fetch(
      `${API_BASE_URL}/api/maps?keyword=${encodeURIComponent(keyword)}`,
      {
        method: "GET",
        headers: {
          "ngrok-skip-browser-warning": "true",
        },
      }
    );

    if (!res.ok) {
      const { message } = await res.json();
      throw new Error(message || "자리 리스트 로딩 실패");
    }

    const data = await res.json();

    return data;
  } catch (err) {
    console.error("jariList 에러:", err);
    throw err;
  }
};
