// feature/admin/hooks/useAdminUserSum.ts
import { useEffect, useState } from "react";
import { getUsersSum } from "@/entity/user/api/getUsersSum";

export const useAdminUserSum = () => {
  const [sumUsers, setSumUsers] = useState<number | undefined>();

  useEffect(() => {
    const loadUserSum = async () => {
      try {
        const data = await getUsersSum();
        setSumUsers(data);
      } catch (error) {
        console.error("유저 숫자 불러오기 실패:", error);
      }
    };
    loadUserSum();
  }, []);

  return { sumUsers };
};
