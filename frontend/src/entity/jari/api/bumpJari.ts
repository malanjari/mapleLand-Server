import { API_BASE_URL } from "@/shared/constants/api";

export async function bumpJari(jariId: number) {
  const token = localStorage.getItem("accessToken");
  try {
    const res = await fetch(`${API_BASE_URL}/api/maps/${jariId}/bump`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
        "ngrok-skip-browser-warning": "true",
      },
    });

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }
    return await res.json();
  } catch (err) {
    console.error("bumpJari 요청 중 에러 발생:", err);
    throw err;
  }
}
