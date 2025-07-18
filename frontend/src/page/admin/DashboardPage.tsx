import { SummaryCard } from "@/feature/admin/ui/SummaryCard";
import { ActivityLog } from "@/feature/admin/ui/ActivityLog";

const DashboardPage = () => {
  return (
    <div className="p-6 space-y-8">
      <h1 className="text-2xl font-bold text-white">📊 어드민 대시보드</h1>

      {/* 요약 카드 */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        {/* <SummaryCard title="전체 자리 등록 수" value={420} />
        <SummaryCard title="오늘 등록된 자리" value={12} /> */}
        <SummaryCard title="총 회원 보기" to="/admin/users" />
      </div>

      {/* 최근 활동 */}
      <ActivityLog />
    </div>
  );
};

export default DashboardPage;
