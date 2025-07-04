import { useState, useMemo } from "react";
import clsx from "clsx";
import TradeList from "./TradeList";
import { JariItem } from "@/entity/trade/model/type";
import { Button } from "@/shared/ui/button/Button";

interface Props {
  title: string;
  color: "blue" | "red";
  jari: JariItem[];
}

type SortOption = "time" | "price";
type SortOrder = "asc" | "desc";

const TradeSection = ({ title, color, jari }: Props) => {
  const [sortOption, setSortOption] = useState<SortOption>("time");
  const [sortOrder, setSortOrder] = useState<SortOrder>("desc");

  const toggleSortOption = (option: SortOption) => {
    if (sortOption === option) {
      setSortOrder((prev) => (prev === "asc" ? "desc" : "asc"));
    } else {
      setSortOption(option);
      setSortOrder("desc"); // default order when switching category
    }
  };

  const sortedItems = useMemo(() => {
    return [...jari].sort((a, b) => {
      if (sortOption === "time") {
        const diff =
          new Date(a.createTime).getTime() - new Date(b.createTime).getTime();
        return sortOrder === "asc" ? diff : -diff;
      } else {
        const diff = a.price - b.price;
        return sortOrder === "asc" ? diff : -diff;
      }
    });
  }, [jari, sortOption, sortOrder]);

  const timeLabel =
    sortOrder === "desc" && sortOption === "time" ? "최신순 ↓" : "오래된순 ↑";
  const priceLabel =
    sortOrder === "desc" && sortOption === "price" ? "가격↑" : "가격↓";

  return (
    <section className="max-h-[600px] mb:col-span-1 overflow-y-auto pr-1">
      <div
        className={clsx(
          "text-white text-sm font-semibold px-3 py-5 mb-3 rounded flex justify-between items-center",
          {
            "bg-blue-600": color === "blue",
            "bg-red-600": color === "red",
          }
        )}
      >
        <span>{title}</span>
        <div className="flex gap-2 text-xs">
          <Button
            variant="ghost"
            onClick={() => toggleSortOption("time")}
            className={clsx(
              "px-2 py-1 text-[10px] rounded border",
              sortOption === "time"
                ? "bg-white text-black"
                : "text-white border-white hover:bg-white hover:text-black transition"
            )}
          >
            {timeLabel}
          </Button>
          <Button
            variant="ghost"
            onClick={() => toggleSortOption("price")}
            className={clsx(
              "px-2 py-1 text-[10px] rounded border",
              sortOption === "price"
                ? "bg-white text-black"
                : "text-white border-white hover:bg-white hover:text-black transition"
            )}
          >
            {priceLabel}
          </Button>
        </div>
      </div>

      <TradeList items={sortedItems} />
    </section>
  );
};

export default TradeSection;
