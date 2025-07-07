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

  const visibleMaps = popularMaps.slice(0, 10);

  return (
    <div className=" p-4 mb:p-8 rounded-lg bg-neutral-800">
      <h2 className="text-xl font-bold mb-5">🔥 인기 자리</h2>
      {loading ? (
        <p className="text-white text-center">로딩 중...</p>
      ) : (
        <div className="flex flex-col gap-5 px-1 lg:grid lg:grid-cols-3">
          {visibleMaps.slice(0, 3).map((spot, idx) => (
            <JariCard key={spot.mapName} spot={spot} rank={idx + 1} />
          ))}
        </div>
      )}
    </div>
  );
};
