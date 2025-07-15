import { API_BASE_URL } from "@/shared/config/api";

interface jariEditPayload {
  mapId: number;
  price?: number;
  serverColor?: "Red" | "Yellow" | "Green";
  comment?: string;
  negotiationOption?: boolean;
}

export async function jariEdit(payload: jariEditPayload) {
  try {
    const res = await fetch(`${API_BASE_URL}/api/maps/update/filed`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    });

    const data = await res.json();

    if (!res.ok) {
      throw new Error(data?.message || "자리 정보 수정에 실패했습니다.");
    }

    return data;
  } catch (error) {
    console.error("postEdit 요청 실패:", error);
    throw error;
  }
}
