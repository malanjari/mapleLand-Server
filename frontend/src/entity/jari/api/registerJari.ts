import { API_BASE_URL } from "@/shared/config/api";

export interface JariRegisterPayload {
  mapName: string;
  userId: number;
  serverColor: "Red" | "Yellow" | "Green";
  comment: string;
  price: number;
  negotiationOption: boolean;
  tradeType: "SELL" | "BUY";
  mapId: number;
}

export const registerJari = async (
  payload: JariRegisterPayload
): Promise<void> => {
  try {
    const token = localStorage.getItem("accessToken");

    const res = await fetch(`${API_BASE_URL}/api/create/mapRegister`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
        "ngrok-skip-browser-warning": "true",
      },
      body: JSON.stringify(payload),
    });

    if (!res.ok) {
      const errorJson = await res.json();
      throw errorJson;
    }
  } catch (err) {
    console.error("registerJari 요청 중 에러 발생:", err);
    throw err;
  }
};
