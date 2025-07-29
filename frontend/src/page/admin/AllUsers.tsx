import { useAdminUsers } from "@/feature/admin/ui/hooks/useAdminUsers";

import { UserSearchBar } from "@/feature/admin/ui/UserSearchBar";
import { UserListSection } from "@/feature/admin/ui/UserListSection";
import { useUserSearch } from "@/feature/admin/ui/hooks/useUserSearch";

const AdminUserPage = () => {
  const {
    usersToRender,
    showBannedOnly,
    toggleBannedFilter,
    page,
    setPage,
    loading,
  } = useAdminUsers();

  const {
    search,
    setSearch,
    searchResult,
    searchLoading,
    searchError,
    handleSearch,
    handleClearSearch,
  } = useUserSearch();

  return (
    <div>
      <h1 className="text-xl font-bold mb-4">
        {showBannedOnly
          ? "밴된 사용자 목록"
          : `전체 사용자 목록 (페이지 ${page + 1})`}
      </h1>

      <UserSearchBar
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
