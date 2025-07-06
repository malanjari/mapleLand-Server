import { jariList } from "@/feature/jari/api/jariList";
import { fetchAutocomplete, MapItem } from "@/feature/jari/api/autocomplete";
import TradeSection from "@/feature/jari/ui/TradeSection";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { JariItem } from "@/entity/trade/model/type";
import { Button } from "@/shared/ui/button/Button";
import { Link } from "react-router-dom";
import { DropItem, getMonsterInfo } from "@/feature/jari/api/monsterInfo";
import { Card, CardContent } from "@/shared/ui/card/card";

const JariDetailPage = () => {
  const { name } = useParams();
  const [jari, setJari] = useState<JariItem[]>([]);
  const [mapMeta, setMapMeta] = useState<MapItem | null>(null);
  const [loading, setLoading] = useState(true);
  const [dropItems, setDropItems] = useState<DropItem[]>([]);

  useEffect(() => {
    if (!name) return;

    const load = async () => {
      try {
        const [jariData, metaDataList, monsterInfo] = await Promise.all([
          jariList(name),
          fetchAutocomplete(name),
          getMonsterInfo(name),
        ]);

        setJari(jariData);
        setDropItems(monsterInfo ?? []);

        const matched = metaDataList.find(
          (m) => m.mapName === decodeURIComponent(name)
        );
        if (matched) setMapMeta(matched);
      } catch (error) {
        console.error("데이터 로딩 실패:", error);
      } finally {
        setLoading(false);
      }
    };

    load();
  }, [name]);

  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");

  console.log("jari", jari);
  return (
    <>
      {loading ? (
        <p className="text-white">로딩 중...</p>
      ) : (
        <>
          <div className=" border lg:w-4/5 ml-auto mb-5 overflow-y-auto border-neutral-700 p-4 bg-neutral-900 rounded-md">
            <h3 className="text-sm font-bold text-white mb-3">
              📦 드랍 아이템
            </h3>

            {dropItems.length > 0 ? (
              <div className=" grid grid-cols-1 :grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-4">
                {dropItems.map((item, i) => (
                  <Card
                    key={i}
                    className="aspect-[3/1] flex flex-col items-center text-center p-2 bg-neutral-800"
                  >
                    <img
                      src={item.itemImageUrl}
                      alt="item"
                      className="w-12 h-12 object-contain rounded bg-neutral-700 "
                    />
                    <CardContent className="p-0 text-sm text-neutral-300">
                      <p className="font-medium">{item.itemName}</p>
                      <p className="text-xs text-neutral-400 mt-1">
                        드랍률: {item.dropRate}%
                      </p>
                    </CardContent>
                  </Card>
                ))}
              </div>
            ) : (
              <p className="text-sm text-neutral-500 italic">
                드랍 정보가 없습니다.
              </p>
            )}

            <p className="text-[10px] text-gray-400 mt-4 italic">
              * 드랍 정보와 확률은 패치에 따라 달라질 수 있습니다.
            </p>
          </div>
          <div className="grid grid-cols-1 lg:grid-cols-5 gap-3 items-start">
            <div className="w-full flex flex-col col-span-1  mb-5  rounded-md  ">
              <div className=" flex flex-col border h-full border-neutral-800 p-4 justify-between bg-neutral-800  rounded-md">
                <h2 className="text-sm font-bold flex  flex-col items-center justify-center gap-2 text-white mb-4">
                  {mapMeta?.miniMapImageLogoUrl && (
                    <img
                      src={mapMeta.miniMapImageLogoUrl}
                      alt="map logo"
                      className="w-10 h-10 object-contain rounded  p-1"
                    />
                  )}
                  <span className="text-lg">{name}</span>
                </h2>

                <img
                  src={mapMeta?.miniMapImageUrl}
                  className="w-40  object-contain rounded-md shadow mx-auto"
                  alt="Mini map"
                />
                <Link to={`/jari/register/${name}`} className="w-full ">
                  <Button className="mt-4 text-white px-4 py-2 rounded-md bg-neutral-700 font-semibold transition w-full">
                    + 자리 등록하기
                  </Button>
                </Link>
                <Link to={`/jari/register/${name}`} className="w-full ">
                  <Button className="mt-4 text-white px-4 py-2 rounded-md bg-neutral-700 font-semibold transition w-full">
                    + 자리 등록하기
                  </Button>
                </Link>
                <Link to={`/jari/register/${name}`} className="w-full ">
                  <Button className="mt-4 text-white px-4 py-2 rounded-md bg-neutral-700 font-semibold transition w-full">
                    + 자리 등록하기
                  </Button>
                </Link>
                <Link to={`/jari/register/${name}`} className="w-full ">
                  <Button className="mt-4 text-white px-4 py-2 rounded-md bg-neutral-700 font-semibold transition w-full">
                    + 자리 등록하기
                  </Button>
                </Link>
              </div>
            </div>{" "}
            {/* 판매 목록 */}
            <TradeSection title="📦 팝니다" color="red" jari={sellJari} />
            {/* 구매 목록 */}
            <TradeSection title="🔍 삽니다" color="blue" jari={buyJari} />
          </div>
        </>
      )}
    </>
  );
};

export default JariDetailPage;
