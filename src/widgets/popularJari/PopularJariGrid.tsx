// src/widgets/popularJari/PopularJariGrid.tsx

import { useEffect, useState } from "react";
import { fetchPopularMaps, PopularMap } from "@/feature/jari/api/popularJari";
import { JariCard } from "@/entity/jari/ui/JariCard";

export const PopularJariGrid = () => {
  const [popularMaps, setPopularMaps] = useState<PopularMap[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      try {
        const data = await fetchPopularMaps();
        setPopularMaps(data);
      } catch (err) {
        console.error("인기 맵 로딩 실패:", err);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, []);

  const half = Math.ceil(popularMaps.length / 2);
  const leftColumn = popularMaps.slice(0, half);
  const rightColumn = popularMaps.slice(half);

  return (
    <div className="bg-neutral-900 p-4 mb:p-8 rounded-lg">
      <h2 className="text-xl font-bold mb-5">🔥 인기 자리</h2>
      <div className="flex flex-col sm:flex-row gap-3 px-1">
        <div className="flex flex-col w-full sm:w-1/2 gap-3">
          {loading ? (
            <p className="text-white text-center">로딩 중...</p>
          ) : (
            leftColumn.map((spot, idx) => (
              <JariCard key={spot.mapName} spot={spot} rank={idx + 1} />
            ))
          )}
        </div>
        <div className="flex flex-col w-full sm:w-1/2 gap-3">
          {!loading &&
            rightColumn.map((spot, idx) => (
              <JariCard key={spot.mapName} spot={spot} rank={idx + 1 + half} />
            ))}
        </div>
      </div>
    </div>
  );
};
