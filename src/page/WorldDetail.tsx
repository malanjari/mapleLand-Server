import { useParams } from "react-router-dom";
import TradeSection from "@/feature/jari/ui/TradeSection";
import { WorldInfoPanel } from "@/feature/worldJari/ui/WorldInfoPanel";
import { useWorldDetail } from "@/feature/worldJari/hooks/useWorldDetail";

const WorldDetailPage = () => {
  const { world } = useParams();
  const { loading, error, buyJari, sellJari } = useWorldDetail(world);

  if (loading) return <p className="text-white">로딩 중...</p>;
  if (error) return <p className="text-red-500">{error}</p>;

  return (
    <div className="grid grid-cols-1 lg:grid-cols-5 gap-4">
      {/* 왼쪽: 월드 정보 */}
      <div className="col-span-4 lg:col-span-1 lg:sticky top-24 self-start">
        <WorldInfoPanel worldKey={world} />
      </div>

      {/* 오른쪽: 자리 거래 */}
      <div className="col-span-4 gap-6">
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-16 lg:mt-0">
          <TradeSection title="📦 팝니다" color="red" jari={sellJari} />
          <TradeSection title="🔍 삽니다" color="blue" jari={buyJari} />
        </div>
      </div>
    </div>
  );
};

export default WorldDetailPage;
