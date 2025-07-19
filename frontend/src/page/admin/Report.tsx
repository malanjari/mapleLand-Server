import { useEffect, useState } from "react";
import { getReportedPosts } from "@/feature/report/ui/api/getReportedPosts";
import { ReportedPost } from "@/feature/report/ui/model/type";
import { useNavigate } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";

const ReportPage = () => {
  const [reports, setReports] = useState<ReportedPost[]>([]);
  const [page, setPage] = useState(0);
  const [lastPage, setLastPage] = useState(false);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const load = async () => {
      try {
        setLoading(true);
        const res = await getReportedPosts(page);
        setReports(res.content);
        console.log(res.content);
        setLastPage(res.last);
      } catch (e) {
        console.error("신고 목록 불러오기 실패:", e);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [page]);

  return (
    <div>
      <h1 className="text-xl font-bold mb-4">🚨 신고된 게시글 목록</h1>
      {loading ? (
        <p className="text-white">로딩 중...</p>
      ) : (
        <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {reports.map((post) => (
            <li
              key={post.userMapId}
              className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-red-500 transition"
            >
              <p className="text-base font-semibold mb-1">🗺️ {post.mapName}</p>
              <p className="text-sm text-neutral-400 mt-2">
                피신고자: {post.globalName}
              </p>
              <p className="text-sm text-neutral-400">
                유저아이디 : {post.userId}
              </p>

              <p className="text-sm text-neutral-400 mt-2">
                신고 당한 횟수: {post.reasons.length}회
              </p>
              <p className="text-sm text-neutral-500">
                최근 신고일:{" "}
                {new Date(
                  post.reasons[post.reasons.length - 1]?.createTime
                ).toLocaleString("ko-KR")}
              </p>
              <div className="flex justify-end gap-3">
                <Button
                  className=" text-xs bg-red-600 hover:bg-red-700 px-3 py-1 rounded"
                  onClick={() => navigate(`/admin/reports/${post.userMapId}`)}
                >
                  상세보기
                </Button>
              </div>
            </li>
          ))}
        </ul>
      )}

      <div className="mt-4 space-x-2">
        <button
          disabled={page === 0}
          onClick={() => setPage((p) => Math.max(p - 1, 0))}
        >
          이전
        </button>
        <button disabled={lastPage} onClick={() => setPage((p) => p + 1)}>
          다음
        </button>
      </div>
    </div>
  );
};

export default ReportPage;
