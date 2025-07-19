import { SummaryCard } from "@/feature/admin/ui/SummaryCard";
import { ActivityLog } from "@/feature/admin/ui/ActivityLog";
import { useEffect, useState } from "react";
import { getAdminUsersSum } from "@/entity/user/api/getAdminUsersSum";

const DashboardPage = () => {
  const [sumUsers, setSumUsers] = useState();

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

  return (
    <div className="p-6 space-y-8">
      <h1 className="text-2xl font-bold text-white">📊 어드민 대시보드</h1>
      {/* 요약 카드 */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        <SummaryCard
          title="총 회원 및 밴된 유저"
          to="/admin/users"
          sumUsers={sumUsers}
        />
        <SummaryCard title="월간 가입자 통계" to="/admin/signupcount" />
        <SummaryCard title="신고된 게시글" to="/admin/reports" />
      </div>
      {/* 최근 활동 */}
      <ActivityLog />
    </div>
  );
};

export default DashboardPage;
