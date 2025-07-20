// feature/admin/hooks/useAdminUsers.ts
import { useEffect, useState } from "react";
import { getAdminallUsers } from "@/entity/user/api/getAllUsers";
import { getBannedUsers } from "@/entity/user/api/getBannedUsers";
import { AdminUsersInfo, BannedUserInfo } from "@/entity/user/model/type";

export const useAdminUsers = () => {
  const [allUsers, setAllUsers] = useState<AdminUsersInfo[]>([]);
  const [bannedUsers, setBannedUsers] = useState<BannedUserInfo[]>([]);
  const [page, setPage] = useState(0);
  const [loading, setLoading] = useState(true);
  const [showBannedOnly, setShowBannedOnly] = useState(false);

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
      } catch (error) {
        console.error("유저 목록 불러오기 실패:", error);
      } finally {
        setLoading(false);
      }
    };

    loadUsers();
  }, [page]);

  const toggleBannedFilter = () => setShowBannedOnly((prev) => !prev);

  const usersToRender = showBannedOnly ? bannedUsers : allUsers;

  return {
    usersToRender,
    showBannedOnly,
    toggleBannedFilter,
    page,
    setPage,
    loading,
  };
};
