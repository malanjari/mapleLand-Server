import { API_BASE_URL } from "@/shared/config/api";
export const updateCompletionStatus = async (
  mapId: number,
  isCompleted: boolean
) => {
  try {
    const token = localStorage.getItem("accessToken");

    const res = await fetch(`${API_BASE_URL}/api/jari/isCompleted`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify({
        mapId,
        isCompleted,
      }),
    });

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }
  } catch (err) {
    console.error("updateCompletionStatus 요청 중 에러 발생:", err);
    throw err;
  }
};
