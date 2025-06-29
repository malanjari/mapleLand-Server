import { JariItem } from "@/entity/trade/model/";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";

interface Props {
  item: JariItem;
}

const TradeCard = ({ item }: Props) => {
  return (
    <div className="bg-zinc-900 text-white rounded-md p-4 flex flex-col gap-3 items-start shadow">
      <div className="flex gap-3 w-full">
        <img
          src="/images/yellow-umbrella.png"
          alt={item.name}
          className="w-12 h-12 object-contain"
        />

        <div className="flex-1 space-y-1">
          <p className="text-lg font-bold">{item.name}</p>
          <div className="text-sm text-gray-200 flex items-center gap-1">
            {item.price.toLocaleString()}
            <img src={mesoIcon} alt="메소" />
          </div>
        </div>

        <div className="flex flex-col items-end text-sm gap-1">
          <div className="flex items-center gap-1">
            <span className="font-semibold">{item.seller}</span>
            <img src="/images/profile.png" className="w-6 h-6 rounded-full" />
          </div>
          <span className="text-xs text-gray-400">
            {item.postedMinutesAgo === 0
              ? "방금전"
              : `${item.postedMinutesAgo}분 전`}
          </span>
          <button className="text-xs border px-2 py-0.5 rounded flex items-center gap-1 mt-1 hover:bg-zinc-800">
            <svg
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

export default TradeCard;
