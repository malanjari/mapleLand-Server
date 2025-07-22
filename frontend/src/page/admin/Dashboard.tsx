import { SummaryCard } from "@/feature/admin/ui/SummaryCard";
import { ActivityLog } from "@/feature/admin/ui/ActivityLog";

import { useAdminUserSum } from "@/feature/admin/ui/hooks/useAdminUserSum";
import { useActivityLogSocket } from "@/feature/admin/ui/hooks/useActivityLogSocket";

export interface ActivityLogItem {
  globalName: string;
  mapName: string;
  crateTime: string;
  userId: number;
}

const DashboardPage = () => {
  const { sumUsers } = useAdminUserSum();
  const { activityLogs, socketConnected } = useActivityLogSocket();

  return (
    <div className="p-6 space-y-8">
      <h1 className="text-2xl font-bold text-white">📊 어드민 대시보드</h1>

      {/* 요약 카드 */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        <SummaryCard title="총 회원" to="/admin/users" sumUsers={sumUsers} />
        <SummaryCard title="월간 가입자 통계" to="/admin/signupcount" />
        <SummaryCard title="신고된 게시글" to="/admin/reports" />
      </div>

      {/* 최근 활동 */}
      <ActivityLog logs={activityLogs} isConnected={socketConnected} />
    </div>
  );
};

export default DashboardPage;
