// src/feature/admin/ui/hooks/useAdminUserSearch.ts
import { useState } from "react";
import { AdminUsersInfo } from "@/entity/user/model/type";
import { getUserByGlobalName } from "@/entity/user/api/getUserByGlobalName";

export const useUserSearch = () => {
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

  return {
    search,
    setSearch,
    searchResult,
    searchLoading,
    searchError,
    handleSearch,
    handleClearSearch,
  };
};
