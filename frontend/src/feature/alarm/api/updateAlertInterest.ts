import { API_BASE_URL } from "@/shared/config/api";

type AlertStatus = "ALERT_ON" | "ALERT_OFF";

interface AlertInterestPayload {
  userId: number;
  mapId: number;
  alertStatus: AlertStatus;
}

export const updateAlertInterest = async ({
  userId,
  mapId,
  alertStatus,
}: AlertInterestPayload) => {
  const token = localStorage.getItem("accessToken");

  if (!token) {
    throw new Error("인증 토큰이 없습니다.");
  }

  const res = await fetch(`${API_BASE_URL}/api/alert/interest`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify({
      userId,
      mapId,
      alertStatus,
    }),
  });

  if (!res.ok) {
    const data = await res.json().catch(() => null);
    const message = data?.error?.message || "알림 설정 실패";
    throw new Error(message);
  }

  return await res.json();
};
