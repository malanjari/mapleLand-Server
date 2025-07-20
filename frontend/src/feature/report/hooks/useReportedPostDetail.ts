// feature/report/hooks/useReportedPostDetail.ts
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getReportedPosts } from "@/feature/report/ui/api/getReportedPosts";
import { ReportedPost } from "@/feature/report/ui/model/type";

export const useReportedPostDetail = () => {
  const { userMapId } = useParams();
  const [post, setPost] = useState<ReportedPost | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      try {
        setLoading(true);
        const res = await getReportedPosts(0); // 임시로 전체 페이지 조회
        const found = res.content.find(
          (item) => item.userMapId === Number(userMapId)
        );
        setPost(found || null);
      } catch (e) {
        console.error("신고 상세 불러오기 실패:", e);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [userMapId]);

  return { post, loading, userMapId };
};
