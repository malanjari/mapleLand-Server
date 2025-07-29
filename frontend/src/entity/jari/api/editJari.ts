import { API_BASE_URL } from "@/shared/constants/api";

interface jariEditPayload {
  mapId: number;
  price?: number;
  serverColor?: "Red" | "Yellow" | "Green";
  comment?: string;
  negotiationOption?: boolean;
}

export async function editJari(payload: jariEditPayload) {
  const token = localStorage.getItem("accessToken");
  try {
    const res = await fetch(`${API_BASE_URL}/api/jari`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
        "ngrok-skip-browser-warning": "true",
      },
      body: JSON.stringify(payload),
    });

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }
  } catch (err) {
    console.error("editJari 요청 중 에러 발생:", err);
    throw err;
  }
}
