import { JariCard } from "@/feature/popularJari/ui/PopularJariCard";
import { usePopularJari } from "@/entity/jari/hooks/usePopularJari";

const PopularJariGrid = () => {
  const { data: popularMaps = [], isLoading } = usePopularJari();

  return (
    <div className=" p-4 mb:p-8 rounded-lg bg-neutral-700">
      <h2 className="text-xl font-bold mb-5">🔥 인기 자리</h2>
      {isLoading ? (
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
