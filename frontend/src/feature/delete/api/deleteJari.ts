import { API_BASE_URL } from "@/shared/config/api";

export async function deleteJari(mapId: number) {
  const token = localStorage.getItem("accessToken");
  console.log(token);
  if (!token) {
    throw new Error("로그인이 필요합니다.");
  }

  try {
    const res = await fetch(`${API_BASE_URL}/api/maps/${mapId}/delete`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`,
      },
    });

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }
  } catch (error) {
    console.error("deleteJari 요청 실패:", error);
    throw error;
  }
}
