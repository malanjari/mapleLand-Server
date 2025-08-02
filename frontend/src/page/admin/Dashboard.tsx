import { SummaryCard } from "@/feature/admin/ui/SummaryCard";

import TradeList from "@/feature/trade/ui/TradeList";

import { useAdminUserSum } from "@/feature/admin/ui/hooks/useAdminUserSum";

import { getAdminJari } from "@/entity/jari/api/getAdminJari";
import { JariItem } from "@/entity/jari/model/type";
import { useEffect, useState } from "react";

export interface ActivityLogItem {
  globalName: string;
  mapName: string;
  crateTime: string;
  userId: number;
}

const DashboardPage = () => {
  const { sumUsers } = useAdminUserSum();

  const [jariList, setJariList] = useState<JariItem[]>([]);
  const [loading, setLoading] = useState(true);

  const fetchJariList = async () => {
    try {
      setLoading(true);
      const data = await getAdminJari();

      setJariList(data);
    } catch (error) {
      console.error("자리 목록 로딩 실패:", error);
      setJariList([]);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchJariList();
  }, []);

  return (
    <div className="p-6 space-y-8">
      <h1 className="text-2xl font-bold text-white">📊 어드민 대시보드</h1>

      {/* 요약 카드 */}
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
        <SummaryCard title="총 회원" to="/admin/users" sumUsers={sumUsers} />
        <SummaryCard title="월간 가입자 통계" to="/admin/signupcount" />
        <SummaryCard title="월간 거래 완료 통계" to="/admin/trade-stats" />
        <SummaryCard title="신고된 게시글" to="/admin/reports" />
        <SummaryCard title="공지사항 쓰기" to="/admin/notice/new" />
      </div>

      {/* 자리 목록 */}
      <div className="space-y-4">
        <h2 className="text-xl font-semibold text-white">
          📋 등록된 자리 목록
        </h2>
        {loading ? (
          <div className="flex justify-center items-center h-32">
            <div className="text-white">로딩 중...</div>
          </div>
        ) : (
          <TradeList items={jariList} showEditButton={false} />
        )}
      </div>
    </div>
  );
};

export default DashboardPage;
