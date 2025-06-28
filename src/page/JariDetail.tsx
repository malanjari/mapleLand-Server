import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
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

const JariDetail = () => {
  const buyItems = items.filter((item) => item.type === "buy");
  const sellItems = items.filter((item) => item.type === "sell");
  const params = useParams();
  return (
    <>
      <h2 className="text-xl font-bold mb-5"> {params.name} 거래 리스트</h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {/* 왼쪽: 삽니다 */}
        <section className="max-h-[600px] overflow-y-auto pr-1">
          <h2 className="bg-blue-600 text-white text-sm font-semibold px-3 py-1 mb-3 rounded">
            🔍 삽니다
          </h2>
          <div className="space-y-3">
            {buyItems.map((item) => (
              <TradeCard key={item.id} item={item} />
            ))}
          </div>
        </section>

        {/* 오른쪽: 팝니다 */}
        <section className="max-h-[600px] overflow-y-auto pr-1">
          <h2 className="bg-red-500 text-white text-sm font-semibold px-3 py-1 mb-3 rounded">
            📦 팝니다
          </h2>
          <div className="space-y-3">
            {sellItems.map((item) => (
              <TradeCard key={item.id} item={item} />
            ))}
          </div>
        </section>
      </div>
    </>
  );
};

const TradeCard = ({ item }: { item: JariItem }) => {
  return (
    <div className="bg-zinc-900 text-white rounded-md p-4 flex flex-col gap-3 items-start shadow">
      <div className="flex gap-3 w-full">
        {/* 왼쪽정보 */}
        <div>
          {" "}
          <img
            src="/images/yellow-umbrella.png"
            alt={item.name}
            className="w-12 h-12 object-contain"
          />
        </div>

        {/* 중앙 정보 */}
        <div className="flex-1 space-y-1">
          {/* 옵션 태그 (더미) */}

          <p className="text-lg font-bold">{item.name}</p>

          <div className="text-sm text-gray-200 flex items-center gap-1">
            {item.price.toLocaleString()} <img src={mesoIcon}></img>
          </div>
        </div>

        {/* 판매자 */}
        <div className="flex flex-col items-end text-right text-sm gap-1">
          <div className="flex items-center gap-1">
            <span className="font-semibold">{item.seller}</span>
            <img
              src="/images/profile.png"
              alt={item.seller}
              className="w-6 h-6 rounded-full"
            />
          </div>
          <span className="text-xs text-gray-400">
            {item.postedMinutesAgo === 0
              ? "방금전"
              : `${item.postedMinutesAgo}분 전`}
          </span>
          <button className="text-xs border px-2 py-0.5 rounded flex items-center gap-1 mt-1 hover:bg-zinc-800">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="w-3 h-3"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
              />
            </svg>
            자세히보기
          </button>
        </div>
      </div>
      <p className="text-sm text-gray-400">
        판매자: <span className="text-white font-medium">{item.seller}</span>
      </p>
    </div>
  );
};

export default JariDetail;
