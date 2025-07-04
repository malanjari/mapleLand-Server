import { jariList } from "@/feature/jari/api/jariList";
import TradeSection from "@/feature/jari/ui/TradeSection";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { JariItem } from "@/entity/trade/model/type";

const JariDetailPage = () => {
  const { name } = useParams();
  const [jari, setJari] = useState<JariItem[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (!name) return;

    const load = async () => {
      try {
        const data = await jariList(name);
        setJari(data);
      } catch (error) {
        console.error("자리 리스트 로딩 실패:", error);
      } finally {
        setLoading(false);
      }
    };

    load();
  }, [name]);

  const buyJari = jari.filter((item) => item.tradeType === "BUY");
  const sellJari = jari.filter((item) => item.tradeType === "SELL");
  console.log(buyJari);
  return (
    <>
      <h2 className="text-xl font-bold mb-5">{name} 거래 리스트</h2>

      {loading ? (
        <p className="text-white">로딩 중...</p>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <TradeSection title="📦 팝니다" color="red" jari={sellJari} />
          <TradeSection title="🔍 삽니다" color="blue" jari={buyJari} />
        </div>
      )}
    </>
  );
};

export default JariDetailPage;
