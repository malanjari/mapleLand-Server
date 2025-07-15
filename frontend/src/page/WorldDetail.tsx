import { useParams } from "react-router-dom";
import { useRegionMaps } from "@/feature/worldJari/hooks/useRegionMaps";
import TradeSection from "@/feature/trade/ui/TradeSection";
import { WorldInfoPanel } from "@/feature/worldJari/ui/WorldInfoPanel";
import { Spinner } from "@/shared/ui/spinner/Spinner";
import { PopularJariList } from "@/feature/popularJari/ui/PopularJariList";
import { useMemo } from "react";

const WorldDetailPage = () => {
  const { world } = useParams();

  const {
    data: jari = [],
    isLoading,
    error,
    refetch,
  } = useRegionMaps(world || ""); // keyword로 world 전달

  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");
  const top5 = useMemo(() => {
    if (!jari || jari.length === 0) return [];

    const countMap = new Map<string, number>();

    for (const item of jari) {
      countMap.set(item.mapName, (countMap.get(item.mapName) || 0) + 1);
    }

    return Array.from(countMap.entries())
      .sort((a, b) => b[1] - a[1])
      .slice(0, 5)
      .map(([mapName, count]) => ({ mapName, count }));
  }, [jari]);

  if (isLoading) return <Spinner />;
  if (error) return <p className="text-red-500">에러 발생</p>;

  return (
    <div className="grid grid-cols-1 lg:grid-cols-8 gap-4">
      {/* 왼쪽: 자리 정보 */}
      <div className="col-span-8 lg:col-span-2 lg:sticky top-24 self-start">
        <WorldInfoPanel worldKey={world} />
        <PopularJariList items={top5} />
      </div>

      {/* 오른쪽: 거래 목록 */}
      <div className="grid grid-cols-1 sm:grid-cols-2 col-span-8 lg:col-span-6 gap-10 sm:gap-3 lg:mt-0">
        <TradeSection
          title="팝니다"
          color="red"
          jari={sellJari}
          refetch={refetch}
        />
        <TradeSection
          title="삽니다"
          color="blue"
          jari={buyJari}
          refetch={refetch}
        />
      </div>
    </div>
  );
};

export default WorldDetailPage;
