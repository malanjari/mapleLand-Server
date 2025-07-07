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
    <section className="max-h-[600px]  overflow-y-auto pr-1">
      <div
        className={clsx(
          "text-white text-sm font-semibold px-4 py-6 mb-4 rounded-xl shadow-lg transition",
          "flex justify-between items-center",
          {
            "bg-gradient-to-r from-blue-600 to-blue-500": color === "blue",
            "bg-gradient-to-r from-red-600 to-red-500": color === "red",
          }
        )}
      >
        <span className="text-2xl font-bold tracking-tight">{title}</span>

        <div className="flex gap-2 text-xs">
          <Button
            variant="ghost"
            onClick={() => toggleSortOption("time")}
            className={clsx(
              "px-3 py-1 text-[11px] rounded-md border font-medium transition duration-150",
              sortOption === "time"
                ? "bg-white text-black shadow"
                : "text-white border-white hover:bg-white hover:text-black hover:shadow"
            )}
          >
            {timeLabel}
          </Button>

          <Button
            variant="ghost"
            onClick={() => toggleSortOption("price")}
            className={clsx(
              "px-3 py-1 text-[11px] rounded-md border font-medium transition duration-150",
              sortOption === "price"
                ? "bg-white text-black shadow"
                : "text-white border-white hover:bg-white hover:text-black hover:shadow"
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
