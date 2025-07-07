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
  const [errorMessage, setErrorMessage] = useState("");
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
        if (matched) {
          setMapMeta(matched);
        } else {
          setErrorMessage("존재하지 않는 맵입니다.");
        }
      } catch (error) {
        if (error instanceof Error) {
          setErrorMessage(error.message);
        } else {
          setErrorMessage("데이터를 불러오는 중 오류가 발생했습니다.");
        }
      } finally {
        setLoading(false);
      }
    };

    load();
  }, [name]);
  console.log("자리", jari);
  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");

  console.log("jari", jari);
  if (loading) {
    return <p className="text-white ">로딩 중...</p>;
  }
  if (errorMessage) return <p className="text-red-500">{errorMessage}</p>;
  return (
    <>
      {loading ? (
        <p className="text-white">로딩 중...</p>
      ) : (
        <div className="grid grid-cols-1 lg:grid-cols-5 gap-4">
          {/* 왼쪽: 자리 정보 */}
          <div className="col-span-4 lg:col-span-1 lg:sticky top-24 self-start">
            <div className="flex flex-col border border-neutral-700 bg-neutral-900 p-4 justify-between  rounded-md">
              {/* header */}
              <h2 className="text-sm font-bold flex flex-col items-center justify-center gap-2 text-white mb-4">
                {mapMeta?.miniMapImageLogoUrl && (
                  <img
                    src={mapMeta.miniMapImageLogoUrl}
                    alt="map logo"
                    className="w-10 h-10 object-contain rounded p-1"
                  />
                )}

                <p className="text-lg text-center">
                  {name?.split(":")[1] ?? name}{" "}
                </p>

                <img
                  src={mapMeta?.miniMapImageUrl}
                  className="max-h-[300px]"
                ></img>
              </h2>

              {/* 버튼 */}
              <Link to={`/jari/register/${name}`} className="w-full">
                <Button
                  variant="default"
                  className="mt-4 text-white px-4 py-2 rounded-md font-semibold transition w-full"
                >
                  + 자리 등록하기
                </Button>
              </Link>
            </div>
          </div>

          {/* 오른쪽: 드랍 아이템 + 거래 목록 */}
          <div className="col-span-4 flex flex-col gap-6">
            {/* 드랍 아이템 */}
            <div className="border border-neutral-700 p-4 bg-neutral-900 rounded-md">
              <h3 className="text-lg font-bold text-white mb-3">
                📦 드랍 아이템
              </h3>

              {dropItems.length > 0 ? (
                <div className="grid mb:grid-cols-2 xl:grid-cols-4 gap-4">
                  {dropItems.map((item, i) => (
                    <Card
                      key={i}
                      className="lg:aspect-[3/1] flex flex-col items-center text-center py-2 bg-neutral-800"
                    >
                      <img
                        src={item.itemImageUrl}
                        alt="item"
                        className="w-12 h-12 object-contain rounded bg-neutral-700"
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

            {/* 거래 목록 */}
            <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-16 lg:mt-0">
              <TradeSection title="팝니다" color="red" jari={sellJari} />
              <TradeSection title="삽니다" color="blue" jari={buyJari} />
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default JariDetailPage;
