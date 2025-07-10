import { JariItem } from "@/entity/trade/model/type";
import TradeCardHeader from "./TradeCardHeader";
import TradeCardPrice from "./TradeCardPrice";
import { TradeCardActions } from "./TradeCardAction";
import clsx from "clsx";

interface Props {
  item: JariItem;
  refetch: () => void;
}

const TradeCard = ({ item, refetch }: Props) => {
  return (
    <div
      className={clsx(
        "bg-neutral-800 text-white rounded-md py-4 px-2 lg:px-4 flex flex-col gap-3 items-start shadow transition duration-300",
        {
          "opacity-40 grayscale": item.isCompleted,
        }
      )}
    >
      <TradeCardHeader item={item} />
      <TradeCardPrice item={item} />
      <TradeCardActions item={item} refetch={refetch} />
    </div>
  );
};

export default TradeCard;
