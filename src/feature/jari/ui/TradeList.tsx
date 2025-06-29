import { JariItem } from "@/entity/trade/model";
import TradeCard from "./TradeCard";

interface Props {
  items: JariItem[];
}

const TradeList = ({ items }: Props) => {
  return (
    <div className="space-y-3">
      {items.map((item) => (
        <TradeCard key={item.id} item={item} />
      ))}
    </div>
  );
};

export default TradeList;
