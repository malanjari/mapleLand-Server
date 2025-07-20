// feature/admin/hooks/useAdminUserSum.ts
import { useEffect, useState } from "react";
import { getAdminUsersSum } from "@/entity/user/api/getAdminUsersSum";

export const useAdminUserSum = () => {
  const [sumUsers, setSumUsers] = useState<number | undefined>();

  useEffect(() => {
    const loadUserSum = async () => {
      try {
        const data = await getAdminUsersSum();
        setSumUsers(data);
      } catch (error) {
        console.error("유저 숫자 불러오기 실패:", error);
      }
    };
    loadUserSum();
  }, []);

  return { sumUsers };
};
