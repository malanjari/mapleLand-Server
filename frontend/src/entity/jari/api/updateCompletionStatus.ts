import { API_BASE_URL } from "@/shared/config/api";
export const updateCompletionStatus = async (
  mapId: number,
  isCompleted: boolean
) => {
  try {
    const token = localStorage.getItem("accessToken");

    const res = await fetch(`${API_BASE_URL}/api/maps/update/isCompleted`, {
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

    if (!res.ok) throw new Error("거래 완료 상태 변경 실패");

    const data = await res.json();
    console.log("거래 완료 처리 성공:", data);
    return data;
  } catch (err) {
    console.error(err);
    throw err;
  }
};
