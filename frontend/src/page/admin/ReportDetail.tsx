import { useNavigate } from "react-router-dom";

import { Button } from "@/shared/ui/button/Button";
import { format } from "date-fns";

import { useReportedPostDetail } from "@/feature/report/hooks/useReportedPostDetail";
import { useJariDeleteHandler } from "@/feature/delete/hooks/useJariDeleteHandler";

const ReportDetailPage = () => {
  const navigate = useNavigate();

  const { post, loading, userMapId } = useReportedPostDetail();
  const { handleDelete } = useJariDeleteHandler({
    onSuccessNavigateTo: "/admin/reports",
  });
  if (loading) return <p className="text-white">로딩 중...</p>;
  if (!post)
    return <p className="text-white">해당 신고 게시글을 찾을 수 없습니다.</p>;

  return (
    <div className="text-white">
      <h1 className="text-xl font-bold mb-4">🚨 신고 상세 정보</h1>
      <p className="mb-2">🗺️ 맵 이름: {post.mapName}</p>
      <p className="mb-2">💬 코멘트: {post.comment}</p>
      <p className="mb-2">💰 가격: {post.price.toLocaleString()} 메소</p>
      <p className="mb-2">
        🧍 등록자: {post.globalName} ({post.userName}) - ID: {post.userId}
      </p>
      <p className="mb-2">📍 서버 색상: {post.serverColor}</p>
      <p className="mb-2">🌍 지역: {post.area}</p>
      <p className="mb-2">
        🕒 등록일: {format(new Date(post.createTime), "yyyy.MM.dd HH:mm")}
      </p>

      <div className="mt-6">
        <h2 className="text-lg font-semibold mb-2">🚩 신고 내역</h2>
        <ul className="space-y-4 text-sm">
          {post.reasons.map((reason, idx) => (
            <li
              key={idx}
              className="border border-red-400 p-4 rounded bg-neutral-900"
            >
              <p>📝 사유: {reason.reason}</p>
              <p className="text-neutral-400 text-xs mb-2">
                🕒 일시:{" "}
                {format(new Date(reason.createTime), "yyyy.MM.dd HH:mm")}
              </p>
              {reason.reportImageUrl && (
                <img
                  src={reason.reportImageUrl}
                  alt="신고 이미지"
                  className="w-full max-w-xs rounded border border-neutral-700"
                />
              )}
            </li>
          ))}
        </ul>
      </div>
      <div className="flex justify-between mt-6">
        <Button
          className=" bg-neutral-700 hover:bg-neutral-600"
          onClick={() => navigate("/admin/reports")}
        >
          🔙 목록으로 돌아가기
        </Button>
        <div className="flex gap-3">
          <Button
            className="bg-blue-600 hover:bg-blue-700"
            onClick={() => navigate(`/profile/${post.userId}`)}
          >
            🔍 프로필 보기
          </Button>
          <Button
            className="bg-red-600 hover:bg-red-700"
            onClick={() => handleDelete(Number(userMapId))}
          >
            ❌ 글 삭제
          </Button>
        </div>
      </div>
    </div>
  );
};

export default ReportDetailPage;
