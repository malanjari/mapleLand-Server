import { BannedUserInfo, AdminUsersInfo } from "@/entity/user/model/type";
import { useNavigate } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import BannedUserCard from "@/feature/ban/ui/UserBannedCard";
import { useAdminUsers } from "@/feature/admin/ui/hooks/useAdminUsers";
import { useState } from "react";
import { getUserByGlobalName } from "@/entity/user/api/getUserByGlobalName";

const AdminUserPage = () => {
  const {
    usersToRender,
    showBannedOnly,
    toggleBannedFilter,
    page,
    setPage,
    loading,
  } = useAdminUsers();

  const navigate = useNavigate();

  const [search, setSearch] = useState("");
  const [searchResult, setSearchResult] = useState<AdminUsersInfo[] | null>(
    null
  );
  const [searchLoading, setSearchLoading] = useState(false);
  const [searchError, setSearchError] = useState("");

  const handleSearch = async () => {
    if (!search) return;
    setSearchLoading(true);
    setSearchError("");
    try {
      const result = await getUserByGlobalName(search);
      setSearchResult(result as AdminUsersInfo[]);
    } catch (err: unknown) {
      setSearchResult(null);
      if (err instanceof Error) {
        setSearchError(err.message);
      } else {
        setSearchError("검색 실패");
      }
    } finally {
      setSearchLoading(false);
    }
  };

  const handleClearSearch = () => {
    setSearch("");
    setSearchResult(null);
    setSearchError("");
  };

  return (
    <div>
      <h1 className="text-x  l font-bold mb-4">
        {showBannedOnly
          ? "밴된 사용자 목록"
          : `전체 사용자 목록 (페이지 ${page + 1})`}
      </h1>

      {/* 검색 영역 */}
      <div className="flex items-center gap-2 mb-4">
        <input
          type="text"
          placeholder="GlobalName으로 검색"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          onKeyDown={(e) => {
            if (e.key === "Enter") {
              handleSearch();
            }
          }}
          className="px-2 py-1 border rounded text-black"
        />
        <Button
          onClick={handleSearch}
          className="bg-blue-500 hover:bg-blue-600 text-white px-2 py-1 text-xs"
        >
          검색
        </Button>
        {search && (
          <Button
            onClick={handleClearSearch}
            className="bg-gray-400 hover:bg-gray-500 text-white px-2 py-1 text-xs"
          >
            초기화
          </Button>
        )}
      </div>
      {searchLoading && <p>검색 중...</p>}
      {searchError && <p className="text-red-500">{searchError}</p>}
      {searchResult ? (
        <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {searchResult.length === 0 ? (
            <li className="text-white">검색 결과가 없습니다.</li>
          ) : (
            searchResult.map((user) => (
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
                  역할: {user.role?.replace("ROLE_", "")}
                </p>
                <p className="text-sm text-neutral-400">
                  신고당한 횟수: {user.reportedCount}
                </p>
                <p className="text-sm text-neutral-500 mt-1">
                  가입일:{" "}
                  {(() => {
                    const koreaTime = new Date(
                      new Date(user.createTime).getTime() +
                        (8 * 60 * 60 + 59 * 60 + 50) * 1000
                    );
                    return koreaTime.toLocaleString("ko-KR");
                  })()}
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
            ))
          )}
        </ul>
      ) : (
        <>
          <Button
            className="mb-4 bg-red-600 hover:bg-red-700 text-white text-sm px-3 py-1 rounded"
            onClick={toggleBannedFilter}
          >
            {showBannedOnly ? "전체 사용자 보기" : "밴된 사용자만 보기"}
          </Button>

          {loading ? (
            <p>로딩 중...</p>
          ) : (
            <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
              {usersToRender.map((user) =>
                showBannedOnly ? (
                  <BannedUserCard
                    key={user.userId}
                    user={user as BannedUserInfo}
                  />
                ) : (
                  <li
                    key={user.userId}
                    className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-blue-400 transition"
                  >
                    <p className="text-lg font-semibold mb-1">
                      {user.globalName}
                    </p>
                    <p className="text-sm text-neutral-400">{user.userName}</p>
                    <p className="text-sm text-neutral-400">
                      ID: {user.userId}
                    </p>
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
                      가입일:{" "}
                      {new Date(user.createTime).toLocaleString("ko-KR")}
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
        </>
      )}
    </div>
  );
};

export default AdminUserPage;
