import { JariItem } from "@/entity/trade/model/type";
import TradeCard from "./TradeCard";

interface Props {
  items: JariItem[];
  refetch: () => void;
}

const TradeList = ({ items, refetch }: Props) => {
  return (
    <div className="space-y-3">
      {items.map((item) => (
        <TradeCard
          key={`${item.uniqueId}-${item.createTime}`}
          item={item}
          refetch={refetch}
        />
      ))}
    </div>
  );
};

export default TradeList;
