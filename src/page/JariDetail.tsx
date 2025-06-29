import TradeSection from "@/feature/jari/ui/TradeSection";

import { useParams } from "react-router-dom";
type TradeType = "sell" | "buy";

interface JariItem {
  id: string;
  name: string;
  seller: string;
  price: number;
  postedMinutesAgo: number;
  type: TradeType;
}

const items: JariItem[] = [
  {
    id: "1",
    name: "구름공원",
    seller: "태우",
    price: 900000,
    postedMinutesAgo: 0,
    type: "sell",
  },
  {
    id: "2",
    name: "구름공원",
    seller: "몰루용오",
    price: 1000000,
    postedMinutesAgo: 40,
    type: "buy",
  },
  {
    id: "3",
    name: "구름공원",
    seller: "태우",
    price: 900000,
    postedMinutesAgo: 0,
    type: "sell",
  },
  {
    id: "4",
    name: "구름공원",
    seller: "몰루용오",
    price: 1000000,
    postedMinutesAgo: 40,
    type: "buy",
  },
  {
    id: "5",
    name: "구름공원",
    seller: "태우",
    price: 900000,
    postedMinutesAgo: 0,
    type: "sell",
  },
  {
    id: "6",
    name: "구름공원",
    seller: "몰루용오",
    price: 1000000,
    postedMinutesAgo: 40,
    type: "buy",
  },
  {
    id: "7",
    name: "구름공원",
    seller: "태우",
    price: 900000,
    postedMinutesAgo: 0,
    type: "sell",
  },
  {
    id: "8",
    name: "구름공원",
    seller: "몰루용오",
    price: 1000000,
    postedMinutesAgo: 40,
    type: "buy",
  },
  {
    id: "9",
    name: "구름공원",
    seller: "태우",
    price: 900000,
    postedMinutesAgo: 0,
    type: "sell",
  },
  {
    id: "10",
    name: "구름공원",
    seller: "몰루용오",
    price: 1000000,
    postedMinutesAgo: 40,
    type: "buy",
  },
];

const JariDetailPage = () => {
  const buyItems = items.filter((item) => item.type === "buy");
  const sellItems = items.filter((item) => item.type === "sell");
  const params = useParams();
  return (
    <>
      <h2 className="text-xl font-bold mb-5">{params.name} 거래 리스트</h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <TradeSection title="🔍 삽니다" color="blue" items={buyItems} />
        <TradeSection title="📦 팝니다" color="red" items={sellItems} />
      </div>
    </>
  );
};

export default JariDetailPage;
