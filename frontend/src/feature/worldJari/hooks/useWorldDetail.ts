import { useEffect, useState } from "react";
import { getRegionMaps, RegionMap } from "../api/worldJari";

export const useWorldDetail = (worldKey?: string) => {
  const [jari, setJari] = useState<RegionMap[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    if (!worldKey) return;

    const load = async () => {
      try {
        setLoading(true);
        const data = await getRegionMaps(worldKey);
        setJari(data);
      } catch (err) {
        setError("데이터 로딩 실패");
        console.error(err);
      } finally {
        setLoading(false);
      }
    };

    load();
  }, [worldKey]);

  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");

  return { loading, error, buyJari, sellJari };
};
