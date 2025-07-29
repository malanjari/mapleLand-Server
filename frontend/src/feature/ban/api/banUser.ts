import { API_BASE_URL } from "@/shared/constants/api";
export const banUser = async (
  userId: number,
  reason: string,
  bannedHours: number
) => {
  const token = localStorage.getItem("accessToken");

  if (!token) {
    throw new Error("인증 토큰이 없습니다.");
  }

  const res = await fetch(`${API_BASE_URL}/api/admin/userBan`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify({ userId, reason, bannedHours }),
  });

  if (!res.ok) {
    const data = await res.json();
    throw new Error(data?.message || "유저 차단에 실패했습니다.");
  }

  return await res.json();
};
