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

    const text = await res.text();
    const data = text ? JSON.parse(text) : {};

    if (!res.ok) {
      throw new Error(data?.message || "자리 정보 삭제에 실패했습니다.");
    }

    return data;
  } catch (error) {
    console.error("deleteJari 요청 실패:", error);
    throw error;
  }
}
