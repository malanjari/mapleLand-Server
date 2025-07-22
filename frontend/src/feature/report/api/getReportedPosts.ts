// src/entity/report/api/getReportedPosts.ts

import { API_BASE_URL } from "@/shared/config/api";
import { ReportedPostsResponse } from "../model/type";

export const getReportedPosts = async (
  page: number
): Promise<ReportedPostsResponse> => {
  try {
    const token = localStorage.getItem("accessToken");
    if (!token) throw new Error("인증 토큰이 없습니다.");

    const res = await fetch(
      `${API_BASE_URL}/api/admin/reports/posts?page=${page}`,
      {
        method: "GET",
        headers: {
          Authorization: `Bearer ${token}`,
          "ngrok-skip-browser-warning": "true",
        },
      }
    );

    if (!res.ok) {
      const errorJson = await res.text();
      throw errorJson;
    }

    const data = await res.json();
    return data;
  } catch (error) {
    console.error("❌ 신고 게시글 불러오기 실패:", error);
    throw error;
  }
};
