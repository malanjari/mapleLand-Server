import { useParams, Navigate, useSearchParams } from "react-router-dom";
import { lazy, useEffect } from "react";
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
  const [searchParams] = useSearchParams();
  const focusId = searchParams.get("focus");
  const {
    mapMeta,
    dropItems,
    priceStats,
    errorMessage,
    loadingMeta,
    loadingPriceStat,
  } = useJariDetailData(name);

  const { data: jari, refetch } = useJariList(name ?? "");
  const mapId = mapMeta?.mapId;
  const mapName = mapMeta?.mapName.split(":")[1] ?? "";

  const { isAlarmOn, toggleAlarm } = useAlertStatus(mapId, mapName);
  const buyJari =
    jari?.filter((item: JariItem) => item.tradeType === "BUY") ?? [];
  const sellJari =
    jari?.filter((item: JariItem) => item.tradeType === "SELL") ?? [];
  useEffect(() => {
    if (!focusId) return;

    const targetId = `trade-${focusId}`;

    const tryScroll = () => {
      const el = document.getElementById(targetId);
      if (el) {
        el.scrollIntoView({ behavior: "smooth", block: "center" });
        el.classList.add(
          "ring",
          "ring-4",
          "ring-pink-500", // 더 강한 색상 (눈에 확 띔)
          "ring-offset-2",
          "ring-offset-neutral-800", // 배경 어두운 톤과 어울림
          "bg-pink-500/20", // 배경 강조도 더 진하게
          "scale-105",
          "transition",
          "duration-500",
          "rounded-sm"
        );
        setTimeout(() => {
          el.classList.remove(
            "ring",
            "ring-4",
            "ring-pink-500",
            "ring-offset-2",
            "ring-offset-neutral-800",
            "bg-pink-500/20",
            "scale-105",
            "rounded-sm"
          );
        }, 3000);
        return true;
      }
      return false;
    };

    if (tryScroll()) return;

    const observer = new MutationObserver(() => {
      if (tryScroll()) observer.disconnect();
    });

    observer.observe(document.body, { childList: true, subtree: true });

    return () => observer.disconnect();
  }, [focusId]);

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
        <DropItemSection dropItems={dropItems} />

        <TradeSections
          sellJari={sellJari}
          buyJari={buyJari}
          refetch={refetch}
        />
      </div>
    </div>
  );
};

export default JariDetailPage;
