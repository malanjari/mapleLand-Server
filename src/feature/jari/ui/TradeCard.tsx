import { JariItem } from "@/entity/trade/model/type";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import { formatDistanceToNow } from "date-fns";
import { ko } from "date-fns/locale";
interface Props {
  item: JariItem;
}

const TradeCard = ({ item }: Props) => {
  console.log("아이템", item);
  return (
    <div className="bg-zinc-900 text-white rounded-md p-4 flex flex-col gap-3 items-start shadow">
      <div className="flex items-center justify-center gap-3 w-full">
        {/* 몬스터 이미지 */}
        <img
          src={item.monsterImageUrl}
          alt={item.mapName}
          className="w-12 h-12 object-contain"
        />

        {/* 맵 이름 + 가격 */}
        <div className="flex flex-col   flex-1 space-y-1">
          <p className="text-sm mb:text-lg font-bold">
            {item.mapName.includes(":")
              ? item.mapName.split(":")[1].trim()
              : item.mapName}
          </p>
          <div className="text-sm text-gray-200 flex items-center gap-1">
            {item.price.toLocaleString()}
            <img src={mesoIcon} alt="메소" />
          </div>
        </div>

        {/* 서버 + 지역 + 거래 버튼 */}
        <div className="flex flex-col items-end text-sm gap-1">
          <span
            className={`text-xs font-bold ${
              item.serverColor === "Red"
                ? "text-red-400"
                : item.serverColor === "Blue"
                ? "text-blue-400"
                : "text-green-400"
            }`}
          >
            {item.serverColor} 서버
          </span>
          {item.negotiationOption ? (
            <span className="text-white text-xs">흥정 가능</span>
          ) : (
            <span className="text-white text-xs">흥정 불가능</span>
          )}
        </div>
      </div>

      {/* 협의 옵션 및 코멘트 */}
      <div className="w-full flex justify-between">
        <span
          className="text-[12px] text-gray-300 italic border-l-4 border-zinc-600 pl-1 break-words "
          title={item.comment}
        >
          “{item.comment}”
        </span>
        <span className="text-[10px]  text-gray-400">
          {formatDistanceToNow(new Date(item.createTime), {
            addSuffix: true,
            locale: ko,
          })}
        </span>
      </div>
    </div>
  );
};

export default TradeCard;
