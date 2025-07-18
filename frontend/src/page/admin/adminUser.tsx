import { useEffect, useState } from "react";
import { adminUsers } from "@/entity/user/api/adminUser";
import { AdminUsersInfo } from "@/entity/user/model/type";
import { useNavigate } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
const AdminUserPage = () => {
  const [users, setUsers] = useState<AdminUsersInfo[]>([]);
  const [page, setPage] = useState(0);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  useEffect(() => {
    const loadUsers = async () => {
      try {
        setLoading(true);
        const data = await adminUsers(page);
        console.log(data);
        setUsers(data);
      } catch (error) {
        console.error("유저 목록 불러오기 실패:", error);
      } finally {
        setLoading(false);
      }
    };

    loadUsers();
  }, [page]); // 페이지 바뀔 때마다 재호출

  return (
    <div>
      <h1>유저 목록 (페이지 {page + 1})</h1>
      {loading ? (
        <p>로딩 중...</p>
      ) : (
        <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {users.map((user: AdminUsersInfo) => (
            <li
              key={user.userId}
              className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-blue-400 transition"
            >
              {" "}
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
                신고당한 횟수: {user.userReportCount}
              </p>
              <p className="text-sm text-neutral-500 mt-1">
                가입일: {new Date(user.localDateTime).toLocaleString("ko-KR")}
              </p>
              <div className="flex justify-end">
                <Button
                  onClick={() => navigate(`/profile/${user.userId}`)}
                  className="  px-2 py-1 h-6 text-xs bg-blue-500 hover:bg-blue-600 rounded text-white"
                >
                  프로필 보기
                </Button>
              </div>
            </li>
          ))}
        </ul>
      )}
      <div className="mt-4 space-x-2">
        <button onClick={() => setPage((p) => Math.max(p - 1, 0))}>이전</button>
        <button onClick={() => setPage((p) => p + 1)}>다음</button>
      </div>
    </div>
  );
};

export default AdminUserPage;
