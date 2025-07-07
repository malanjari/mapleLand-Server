import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import { getRegionMaps, RegionMap } from "@/feature/worldJari/api/worldJari";
import { Button } from "@/shared/ui/button/Button";
import TradeSection from "@/feature/jari/ui/TradeSection";

import {
  victoria,
  minarForest,
  elnath,
  ludusLake,
  aquaRoad,
} from "@/shared/assets/world";
const WorldDetailPage = () => {
  const { world } = useParams();
  const [jari, setJari] = useState<RegionMap[]>([]);

  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const worlds = [
    {
      name: "빅토리아",
      keyword: "Victoria",
      image: victoria,
    },
    {
      name: "엘나스",
      keyword: "Elnath",
      image: elnath,
    },
    {
      name: "루더스 호수",
      keyword: "LudusLake",
      image: ludusLake,
    },
    {
      name: "미나르 숲",
      keyword: "MinarForest",
      image: minarForest,
    },
    {
      name: "아쿠아 로드",
      keyword: "AquaRoad",
      image: aquaRoad,
    },
  ];
  const matchedWorld = worlds.find((w) => w.keyword === world);

  useEffect(() => {
    if (!world) return;

    const load = async () => {
      try {
        setLoading(true);
        const data = await getRegionMaps(world);
        console.log(data);
        setJari(data);
      } catch (err) {
        setError("데이터 로딩 실패");
        console.error(err);
      } finally {
        setLoading(false);
      }
    };

    load();
  }, [world]);

  if (loading) return <p className="text-white">로딩 중...</p>;
  if (error) return <p className="text-red-500">{error}</p>;
  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");
  return (
    <>
      <div className="grid grid-cols-1 lg:grid-cols-5 gap-4">
        {/* 왼쪽: 자리 정보 */}
        <div className="col-span-4 lg:col-span-1  lg:sticky top-24 self-start">
          <div className="flex flex-col border border-neutral-700 bg-neutral-900 p-4 justify-between rounded-md">
            <h2 className="text-lg font-bold flex flex-col items-center justify-center gap-2 text-white mb-4">
              {matchedWorld?.name}
            </h2>
            {matchedWorld?.image && (
              <img
                className="object-contain"
                src={matchedWorld.image}
                alt={matchedWorld.name}
              />
            )}{" "}
            {/* 버튼 */}
            <Link to={`/jari/register/`} className="w-full">
              <Button
                variant="default"
                className="mt-4 text-white px-4 py-2 rounded-md font-semibold transition w-full"
              >
                + 자리 등록하기
              </Button>
            </Link>
          </div>
        </div>

        {/* 오른쪽: 거래 목록 */}
        <div className="col-span-4 flex flex-col gap-6">
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-16 lg:mt-0">
            <TradeSection title="📦 팝니다" color="red" jari={sellJari} />
            <TradeSection title="🔍 삽니다" color="blue" jari={buyJari} />
          </div>
        </div>
      </div>
    </>
  );
};

export default WorldDetailPage;
