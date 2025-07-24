import { JariItem } from "@/entity/jari/model/type";
import TradeCard from "./TradeCard";

interface Props {
  items: JariItem[];
  refetch: () => void;
  showEditButton?: boolean;
}

const TradeList = ({ items, refetch, showEditButton = true }: Props) => {
  if (items.length === 0) {
    return (
      <div className="flex-1 flex flex-col h-[139px] items-center justify-center text-sm text-gray-400 bg-neutral-800 rounded-md py-10 gap-3">
        <p>등록된 자리가 없습니다.</p>
      </div>
    );
  }

  return (
    <div className="max-h-[600px] rounded-sm flex flex-col gap-3 overflow-y-auto snap-y snap-mandatory">
      {items.map((item) => (
        <TradeCard
          key={`${item.discordId}-${item.createTime}`}
          item={item}
          refetch={refetch}
          showEditButton={showEditButton}
        />
      ))}
    </div>
  );
};

export default TradeList;
