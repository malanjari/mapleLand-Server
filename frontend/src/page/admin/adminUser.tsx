import { useEffect, useState } from "react";
import { getAdminallUsers } from "@/entity/user/api/getAllUsers";
import { getBannedUsers } from "@/entity/user/api/getBannedUsers";
import { AdminUsersInfo, BannedUserInfo } from "@/entity/user/model/type";
import { useNavigate } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import BannedUserCard from "@/feature/user/ui/UserBannedCard";

const AdminUserPage = () => {
  const [allUsers, setAllUsers] = useState<AdminUsersInfo[]>([]);
  const [bannedUsers, setBannedUsers] = useState<BannedUserInfo[]>([]);
  const [page, setPage] = useState(0);
  const [loading, setLoading] = useState(true);
  const [showBannedOnly, setShowBannedOnly] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const loadUsers = async () => {
      try {
        setLoading(true);
        const [allUsersData, bannedData] = await Promise.all([
          getAdminallUsers(page),
          getBannedUsers(),
        ]);
        setAllUsers(allUsersData);
        setBannedUsers(bannedData);
        console.log(bannedData);
      } catch (error) {
        console.error("유저 목록 불러오기 실패:", error);
      } finally {
        setLoading(false);
      }
    };

    loadUsers();
  }, [page]);

  // 보여줄 유저 리스트
  const usersToRender = showBannedOnly ? bannedUsers : allUsers;

  return (
    <div>
      <h1 className="text-xl font-bold mb-4">
        {showBannedOnly
          ? "밴된 사용자 목록"
          : `전체 사용자 목록 (페이지 ${page + 1})`}
      </h1>

      <Button
        className="mb-4 bg-red-600 hover:bg-red-700 text-white text-sm px-3 py-1 rounded"
        onClick={() => setShowBannedOnly((prev) => !prev)}
      >
        {showBannedOnly ? "전체 사용자 보기" : "밴된 사용자만 보기"}
      </Button>

      {loading ? (
        <p>로딩 중...</p>
      ) : (
        <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {usersToRender.map((user) =>
            showBannedOnly ? (
              <BannedUserCard key={user.userId} user={user as BannedUserInfo} />
            ) : (
              <li
                key={user.userId}
                className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-blue-400 transition"
              >
                <p className="text-lg font-semibold mb-1">{user.globalName}</p>
                <p className="text-sm text-neutral-400">{user.userName}</p>
                <p className="text-sm text-neutral-400">ID: {user.userId}</p>
                <p className="text-sm text-neutral-400">
                  Discord: {user.discordId}
                </p>
                <p className="text-sm text-neutral-400">
                  역할: {user.role.replace("ROLE_", "")}
                </p>
                <p className="text-sm text-neutral-400">
                  신고당한 횟수: {user.reportedCount}
                </p>
                <p className="text-sm text-neutral-500 mt-1">
                  가입일: {new Date(user.createTime).toLocaleString("ko-KR")}
                </p>
                <div className="flex justify-end">
                  <Button
                    onClick={() => navigate(`/profile/${user.userId}`)}
                    className="px-2 py-1 h-6 text-xs bg-blue-500 hover:bg-blue-600 rounded text-white"
                  >
                    프로필 보기
                  </Button>
                </div>
              </li>
            )
          )}
        </ul>
      )}

      {/* 페이지네이션은 전체 목록일 때만 표시 */}
      {!showBannedOnly && (
        <div className="mt-4 space-x-2">
          <button onClick={() => setPage((p) => Math.max(p - 1, 0))}>
            이전
          </button>
          <button onClick={() => setPage((p) => p + 1)}>다음</button>
        </div>
      )}
    </div>
  );
};

export default AdminUserPage;
