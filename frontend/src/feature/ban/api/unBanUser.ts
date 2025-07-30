import { API_BASE_URL } from "@/shared/constants/api";

export const unBanUser = async (userId: number) => {
  const token = localStorage.getItem("accessToken");

  if (!token) {
    throw new Error("인증 토큰이 없습니다.");
  }

  const res = await fetch(`${API_BASE_URL}/api/admin/userUnBan/${userId}`, {
    method: "POST",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  if (!res.ok) {
    const data = await res.json();
    throw new Error(data?.message || "유저 차단 해제에 실패했습니다.");
  }

  return await res.json();
};
