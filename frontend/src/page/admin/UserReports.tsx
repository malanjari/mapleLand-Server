import { useNavigate, useSearchParams } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import { useUserReports } from "@/feature/report/hooks/useUserReports";
import { convertToKoreaTime } from "@/shared/utils/date";

const UserReportsPage = () => {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const userId = searchParams.get("userId");

  const { data: userReportsData, isLoading, error } = useUserReports(userId);
  const userReports = userReportsData?.reportDetailsList || [];

  if (!userId) {
    return (
      <div className="text-center py-8">
        <p className="text-white text-lg">사용자 ID가 필요합니다.</p>
        <Button
          onClick={() => navigate("/admin/users")}
          className="mt-4 bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded"
        >
          사용자 목록으로 돌아가기
        </Button>
      </div>
    );
  }

  if (error) {
    return (
      <div className="text-center py-8">
        <p className="text-white text-lg">
          사용자 신고 내역을 불러오는데 실패했습니다.
        </p>
        <Button
          onClick={() => navigate("/admin/users")}
          className="mt-4 bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded"
        >
          사용자 목록으로 돌아가기
        </Button>
      </div>
    );
  }

  // 사용자 정보 (첫 번째 신고에서 가져옴)
  const userInfo =
    userReports.length > 0
      ? {
          reportedName: userReports[0].reportedName,
          reportedId: userReports[0].reportedId,
        }
      : null;

  return (
    <div>
      <div className="flex items-center justify-between mb-4">
        <div>
          <h1 className="text-xl font-bold">🚨 사용자 신고 내역</h1>
          {userInfo && (
            <p className="text-sm text-gray-400 mt-1">
              {userInfo.reportedName} - ID: {userInfo.reportedId}
            </p>
          )}
        </div>
        <div className="flex gap-2">
          <Button
            onClick={() => navigate(`/profile/${userId}`)}
            className="text-xs bg-blue-600 hover:bg-blue-700 px-3 py-1 rounded"
          >
            프로필 보기
          </Button>
          <Button
            onClick={() => navigate("/admin/users")}
            className="text-xs bg-gray-600 hover:bg-gray-700 px-3 py-1 rounded"
          >
            사용자 목록
          </Button>
        </div>
      </div>

      {isLoading ? (
        <p className="text-white">로딩 중...</p>
      ) : userReports.length === 0 ? (
        <div className="text-center py-8">
          <p className="text-white text-lg">
            해당 사용자의 신고 내역이 없습니다.
          </p>
        </div>
      ) : (
        <>
          <div className="mb-4 p-4 bg-neutral-800 rounded-lg">
            <p className="text-white">
              <span className="font-semibold">총 신고 횟수:</span>{" "}
              {userReports.length}회
            </p>
          </div>

          <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
            {userReports.map((report, index) => (
              <li
                key={index}
                className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-red-500 transition"
              >
                <div className="flex items-center gap-2 mb-2">
                  <img
                    src={report.jariImage}
                    alt={report.jariName}
                    className="w-8 h-8 rounded"
                  />
                  <p className="text-base font-semibold">
                    🗺️ {report.jariName}
                  </p>
                </div>

                <div className="mb-3">
                  <p className="text-sm text-neutral-400">
                    <span className="font-semibold">신고자:</span>{" "}
                    {report.reporterName}
                  </p>
                  <p className="text-sm text-neutral-400">
                    <span className="font-semibold">신고 사유:</span>{" "}
                    {report.reason}
                  </p>
                </div>

                <p className="text-sm text-neutral-500">
                  신고일:{" "}
                  {convertToKoreaTime(report.createTime).toLocaleString(
                    "ko-KR"
                  )}
                </p>

                <div className="flex justify-end gap-3 mt-3">
                  <Button
                    className="text-xs bg-red-600 hover:bg-red-700 px-3 py-1 rounded"
                    onClick={() => navigate(`/admin/reports/${report.jariId}`)}
                  >
                    상세보기
                  </Button>
                </div>
              </li>
            ))}
          </ul>
        </>
      )}
    </div>
  );
};

export default UserReportsPage;
