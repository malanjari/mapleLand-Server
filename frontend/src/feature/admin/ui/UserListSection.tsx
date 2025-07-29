import { BannedUserInfo, AdminUsersInfo } from "@/entity/user/model/type";
import { Button } from "@/shared/ui/button/Button";
import BannedUserCard from "@/feature/ban/ui/UserBannedCard";
import { UserCard } from "./UserCard";

interface UserListSectionProps {
  searchResult: AdminUsersInfo[] | null;
  searchLoading: boolean;
  searchError: string;
  usersToRender: AdminUsersInfo[];
  loading: boolean;
  showBannedOnly: boolean;
  toggleBannedFilter: () => void;
  setPage: React.Dispatch<React.SetStateAction<number>>;
}

export const UserListSection = ({
  searchResult,
  searchLoading,
  searchError,
  usersToRender,
  loading,
  showBannedOnly,
  toggleBannedFilter,
  setPage,
}: UserListSectionProps) => {
  if (searchLoading) return <p>검색 중...</p>;
  if (searchError) return <p className="text-red-500">{searchError}</p>;

  if (searchResult) {
    return (
      <ul className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {searchResult.length === 0 ? (
          <li className="text-white">검색 결과가 없습니다.</li>
        ) : (
          searchResult.map((user) => <UserCard key={user.userId} user={user} />)
        )}
      </ul>
    );
  }

  return (
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
              <BannedUserCard key={user.userId} user={user as BannedUserInfo} />
            ) : (
              <UserCard key={user.userId} user={user} />
            )
          )}
        </ul>
      )}

      {!showBannedOnly && (
        <div className="mt-4 space-x-2">
          <button onClick={() => setPage((p) => Math.max(p - 1, 0))}>
            이전
          </button>
          <button onClick={() => setPage((p) => p + 1)}>다음</button>
        </div>
      )}
    </>
  );
};
