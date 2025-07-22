// feature/report/hooks/useReportedPosts.ts
import { useEffect, useState } from "react";
import { getReportedPosts } from "@/feature/report/api/getReportedPosts";
import { ReportedPost } from "@/feature/report/model/type";

export const useReportedPosts = () => {
  const [reports, setReports] = useState<ReportedPost[]>([]);
  const [page, setPage] = useState(0);
  const [lastPage, setLastPage] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      try {
        setLoading(true);
        const res = await getReportedPosts(page);
        setReports(res.content);
        setLastPage(res.last);
      } catch (e) {
        console.error("신고 목록 불러오기 실패:", e);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [page]);

  return {
    reports,
    page,
    setPage,
    lastPage,
    loading,
  };
};
