import { API_BASE_URL } from "@/shared/config/api";

export interface ReportPayload {
  reason: string;
  userId: number;
  jariId: number;
  reportImage?: File | null;
}

export async function submitReport(payload: ReportPayload) {
  try {
    const token = localStorage.getItem("accessToken");
    if (!token) {
      throw new Error("인증 토큰이 없습니다.");
    }

    // JSON 데이터를 하나의 Blob으로 감싸 request라는 key로 FormData에 추가
    const requestPayload = {
      reason: payload.reason,
      userId: payload.userId,
      jariId: payload.jariId,
    };

    const formData = new FormData();
    formData.append(
      "request",
      new Blob([JSON.stringify(requestPayload)], {
        type: "application/json",
      })
    );

    if (payload.reportImage) {
      formData.append("reportImage", payload.reportImage);
    }

    const res = await fetch(`${API_BASE_URL}/api/reports`, {
      method: "POST",
      headers: {
        Authorization: `Bearer ${token}`,
      },
      body: formData,
    });

    const data = await res.json();
    console.log(data);
    if (!res.ok) {
      throw new Error(data?.error.message || "신고에 실패했습니다.");
    }

    return data;
  } catch (error) {
    console.error("신고 요청 실패:", error);
    throw error;
  }
}
