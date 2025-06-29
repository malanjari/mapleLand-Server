import clsx from "clsx";
import TradeList from "./TradeList";
import { JariItem } from "@/entity/trade/model";
interface Props {
  title: string;
  color: "blue" | "red"; // or just `string` if 자유롭게
  items: JariItem[];
}
const TradeSection = ({ title, color, items }: Props) => {
  return (
    <section className="max-h-[600px] overflow-y-auto pr-1">
      <h2
        className={clsx(
          "text-white text-sm font-semibold px-3 py-1 mb-3 rounded",
          {
            "bg-blue-600": color === "blue",
            "bg-red-600": color === "red",
          }
        )}
      >
        {title}
      </h2>
      <TradeList items={items} />
    </section>
  );
};

export default TradeSection;
