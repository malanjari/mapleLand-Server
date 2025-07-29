import { useState } from "react";
import { useAdminUsers } from "@/feature/admin/ui/hooks/useAdminUsers";
import { getUserByGlobalName } from "@/entity/user/api/getUserByGlobalName";
import { AdminUsersInfo } from "@/entity/user/model/type";

import { AdminUserSearchBar } from "@/feature/admin/ui/UserSearchBar";
import { UserListSection } from "@/feature/admin/ui/UserListSection";

const AdminUserPage = () => {
  const {
    usersToRender,
    showBannedOnly,
    toggleBannedFilter,
    page,
    setPage,
    loading,
  } = useAdminUsers();

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
      setSearchError(err instanceof Error ? err.message : "검색 실패");
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
      <h1 className="text-xl font-bold mb-4">
        {showBannedOnly
          ? "밴된 사용자 목록"
          : `전체 사용자 목록 (페이지 ${page + 1})`}
      </h1>

      <AdminUserSearchBar
        search={search}
        onChange={setSearch}
        onSearch={handleSearch}
        onClear={handleClearSearch}
      />

      <UserListSection
        searchResult={searchResult}
        searchLoading={searchLoading}
        searchError={searchError}
        usersToRender={usersToRender}
        loading={loading}
        showBannedOnly={showBannedOnly}
        toggleBannedFilter={toggleBannedFilter}
        setPage={setPage}
      />
    </div>
  );
};

export default AdminUserPage;
