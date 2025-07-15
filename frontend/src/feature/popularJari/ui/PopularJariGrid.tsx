import { useEffect, useState } from "react";
import { fetchPopularMaps, PopularMap } from "@/entity/jari/api/popularJari";
import { JariCard } from "@/feature/popularJari/ui/PopularJariCard";

const PopularJariGrid = () => {
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

  return (
    <div className=" p-4 mb:p-8 rounded-lg bg-neutral-700">
      <h2 className="text-xl font-bold mb-5">🔥 인기 자리</h2>
      {loading ? (
        <p className="text-white text-center">로딩 중...</p>
      ) : (
        <div className="grid grid-cols-1 mb:grid-cols-2 sm:grid-cols-3 gap-3 lg:gap-5 px-1  ">
          {popularMaps.map((spot, idx) => (
            <JariCard key={spot.mapName} spot={spot} rank={idx + 1} />
          ))}
        </div>
      )}
    </div>
  );
};
export default PopularJariGrid;
