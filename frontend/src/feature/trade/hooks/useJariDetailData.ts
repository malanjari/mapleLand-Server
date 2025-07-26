import { useState, useCallback, useEffect } from "react";
import { useAllMaps } from "@/entity/map/hooks/useAllMaps";
import { MapItem } from "@/entity/map/api/getAllMaps";
import { DropItem } from "@/entity/jari/api/getMonsterInfo";
import { DailyPriceStat } from "@/feature/price/model/type";
import { API_BASE_URL } from "@/shared/config/api";

export const useJariDetailData = (name: string | undefined) => {
  const { data: allMaps } = useAllMaps();
  const [mapMeta, setMapMeta] = useState<MapItem | null>(null);
  const [dropItems, setDropItems] = useState<DropItem[]>([]);
  const [priceStats, setPriceStats] = useState<DailyPriceStat[]>([]);
  const [errorMessage, setErrorMessage] = useState("");
  const [loadingMeta, setLoadingMeta] = useState(true);
  const [loadingPriceStat, setLoadingPriceStat] = useState(true);

  const loadLazyData = useCallback(async () => {
    if (!name) return;

    try {
      const res = await fetch(
        `${API_BASE_URL}/api/mapList?keyword=${encodeURIComponent(name)}`,
        {
          headers: {
            "ngrok-skip-browser-warning": "true",
          },
        }
      );

      if (!res.ok) throw new Error("맵 상세 데이터 요청 실패");

      const data = await res.json();

      const { dropItemResponse, priceStatDtoList } = data;

      setDropItems(dropItemResponse ?? []);
      setPriceStats(priceStatDtoList ?? []);
    } catch (error) {
      console.error("레이지 데이터 로딩 실패:", error);
    } finally {
      setLoadingPriceStat(false);
    }
  }, [name]);

  useEffect(() => {
    if (!name || !allMaps) return;

    const fetchMapData = async () => {
      setLoadingMeta(true);
      setErrorMessage("");
      setLoadingPriceStat(true);

      try {
        const decodedName = decodeURIComponent(name).replace(/\s/g, "");
        const matched = allMaps.find(
          (m) => m.mapName.replace(/\s/g, "") === decodedName
        );

        if (!matched) {
          setErrorMessage("존재하지 않는 맵입니다.");
          return;
        }

        setMapMeta(matched);
        // 메타데이터 로드 완료 후 레이지 데이터 로드
        await loadLazyData();
      } catch (error) {
        if (error instanceof Error) {
          setErrorMessage(error.message);
        } else {
          setErrorMessage("메타데이터 로딩 중 오류 발생");
        }
      } finally {
        setLoadingMeta(false);
      }
    };

    fetchMapData();
  }, [name, allMaps, loadLazyData]);

  return {
    mapMeta,
    dropItems,
    priceStats,
    errorMessage,
    loadingMeta,
    loadingPriceStat,
  };
};
