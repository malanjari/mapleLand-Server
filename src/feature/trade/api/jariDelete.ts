import { API_BASE_URL } from "@/shared/config/api";

export async function jariDelete(mapId: string) {
  try {
    const res = await fetch(`${API_BASE_URL}/api/maps/${mapId}/delete`, {
      method: "DELETE",
    });

    const data = await res.json();

    if (!res.ok) {
      throw new Error(data?.message || "자리 정보 삭제에 실패했습니다.");
    }

    return data;
  } catch (error) {
    console.error("deleteJari 요청 실패:", error);
    throw error;
  }
}
