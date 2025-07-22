import { useState } from "react";
import { getUserByGlobalName } from "@/entity/user/api/getUserByGlobalName";
import { AdminUsersInfo } from "@/entity/user/model/type";

export const useSearchUser = () => {
  const [search, setSearch] = useState("");
  const [result, setResult] = useState<AdminUsersInfo[] | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSearch = async () => {
    if (!search) return;
    setLoading(true);
    setError("");
    try {
      const res = await getUserByGlobalName(search);
      setResult(res as AdminUsersInfo[]);
    } catch (err) {
      setResult(null);
      setError(err instanceof Error ? err.message : "검색 실패");
    } finally {
      setLoading(false);
    }
  };

  const clearSearch = () => {
    setSearch("");
    setResult(null);
    setError("");
  };

  return {
    search,
    setSearch,
    result,
    loading,
    error,
    handleSearch,
    clearSearch,
  };
};
