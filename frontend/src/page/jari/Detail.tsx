import { useParams, Navigate } from "react-router-dom";
import { lazy, Suspense } from "react";
import { JariItem } from "@/entity/jari/model/type";
import { Spinner } from "@/shared/ui/spinner/Spinner";
import { useJariList } from "@/feature/trade/hooks/useJariList";
import { JariMiniMapCard } from "@/feature/jari/ui/JariMiniMapCard";
import { PriceStatInfo } from "@/feature/price/ui/PriceStatInfo";
import { PriceChart } from "@/feature/price/ui/PriceChart";
import { TradeSections } from "@/feature/trade/ui/TradeSections";
import { useJariDetailData } from "@/feature/trade/hooks/useJariDetailData";

import { useAlertStatus } from "@/feature/alert/hooks/useAlertState";

const DropItemSection = lazy(() => import("@/feature/jari/ui/DropItemSection"));

const JariDetailPage = () => {
  const { name } = useParams();

  // 커스텀 훅들 사용
  const {
    mapMeta,
    dropItems,
    priceStats,
    errorMessage,
    loadingMeta,
    loadingPriceStat,
  } = useJariDetailData(name);

  const { data: jari, refetch } = useJariList(name ?? "");

  const mapId = mapMeta?.mapleLandMapListId;
  const mapName = mapMeta?.mapName.split(":")[1] ?? "";

  const { isAlarmOn, toggleAlarm } = useAlertStatus(mapId, mapName);
  const buyJari =
    jari?.filter((item: JariItem) => item.tradeType === "BUY") ?? [];
  const sellJari =
    jari?.filter((item: JariItem) => item.tradeType === "SELL") ?? [];

  if (errorMessage) {
    return <Navigate to="/404" replace />;
  }

  if (loadingMeta) return <Spinner />;

  return (
    <div className="grid grid-cols-1 lg:grid-cols-8 gap-4">
      {/* 왼쪽: 자리 정보 */}
      <div className="col-span-8 lg:col-span-2 lg:sticky top-24 self-start flex flex-col gap-4 mb-10 lg:mb-0">
        <JariMiniMapCard
          mapMeta={mapMeta}
          name={name}
          isAlarmOn={isAlarmOn}
          onToggle={toggleAlarm}
        />

        {loadingPriceStat ? (
          <p>가격 정보 로딩 중...</p>
        ) : (
          <>
            <PriceChart data={priceStats} />
            <PriceStatInfo />
          </>
        )}
      </div>

      {/* 오른쪽: 드랍 아이템 + 거래 목록 */}
      <div className="col-span-8 lg:col-span-6 flex flex-col gap-6">
        <Suspense fallback={<p className="text-white">드랍 정보 로딩 중...</p>}>
          <DropItemSection dropItems={dropItems} />
        </Suspense>

        <Suspense
          fallback={
            <div className="text-white text-center col-span-2">
              거래 목록 로딩 중...
            </div>
          }
        >
          <TradeSections
            sellJari={sellJari}
            buyJari={buyJari}
            refetch={refetch}
          />
        </Suspense>
      </div>
    </div>
  );
};

export default JariDetailPage;
