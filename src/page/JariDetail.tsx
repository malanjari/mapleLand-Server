import { jariList } from "@/feature/jari/api/jariList";
import { fetchAutocomplete, MapItem } from "@/feature/jari/api/autocomplete";
import TradeSection from "@/feature/jari/ui/TradeSection";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { JariItem } from "@/entity/trade/model/type";
import { Button } from "@/shared/ui/button/Button";
import { Link } from "react-router-dom";

const JariDetailPage = () => {
  const { name } = useParams();
  const [jari, setJari] = useState<JariItem[]>([]);
  const [mapMeta, setMapMeta] = useState<MapItem | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (!name) return;

    const load = async () => {
      try {
        const [jariData, metaDataList] = await Promise.all([
          jariList(name),
          fetchAutocomplete(name),
        ]);

        setJari(jariData);
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

  return (
    <>
      {loading ? (
        <p className="text-white">로딩 중...</p>
      ) : (
        <>
          {" "}
          <div className="w-full grid grid-cols-5 gap-4  mb-5   rounded-md  ">
            <div className="col-span-2 sm:col-span-2 border border-neutral-700 p-4 bg-neutral-900 rounded-md">
              <h2 className="text-sm font-bold flex items-center justify-center gap-2 text-white mb-4">
                {mapMeta?.miniMapImageLogoUrl && (
                  <img
                    src={mapMeta.miniMapImageLogoUrl}
                    alt="map logo"
                    className="w-10 h-10 object-contain rounded bg-neutral-700 p-1"
                  />
                )}
                <span>{name} </span>
              </h2>

              <img
                src={mapMeta?.monsterImageUrl}
                className="max-w-[240px] w-full aspect-video object-contain rounded-md shadow mx-auto"
                alt="Mini map"
              />

              <Link to={`/jari/register/${name}`} className="w-full">
                <Button
                  variant="register"
                  className="mt-4 px-4 py-2 rounded-md font-semibold transition w-full"
                >
                  + 자리 등록하기
                </Button>
              </Link>
            </div>
            <div className="col-span-3 sm:col-span-3 border border-neutral-700 p-4 bg-neutral-900 rounded-md">
              <h3 className="text-sm font-bold text-white mb-3">
                📦 드랍 아이템
              </h3>

              <ul className="text-xs text-neutral-300 space-y-1 leading-relaxed">
                <li>💰 메소 (일정 확률)</li>
                <li>🧪 장인의 큐브</li>
                <li>⚔️ 미나르숲 표식</li>
                <li>📜 주문서 조각</li>
                <li>🔮 에픽 잠재 주문서</li>
              </ul>

              <p className="text-[10px] text-gray-400 mt-4 italic">
                * 드랍 정보는 확률 및 서버에 따라 달라질 수 있습니다.
              </p>
            </div>
          </div>
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 items-start">
            {/* 🗺️ 미니맵 이미지 */}

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
