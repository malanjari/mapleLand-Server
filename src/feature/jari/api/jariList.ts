import { API_BASE_URL } from "@/shared/config/api";

export const jariList = async (keyword: string) => {
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
      const text = await res.text();
      console.error("jariList 응답 오류:", text);
      throw new Error("자리 리스트 로딩 실패");
    }

    const json = await res.json();
    console.log(json);
    return json;
  } catch (err) {
    console.error("jariList 에러:", err);
    throw err;
  }
};
