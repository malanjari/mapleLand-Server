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
  const [showOnlyActive, setShowOnlyActive] = useState(false);

  const toggleSortOption = (option: SortOption) => {
    if (sortOption === option) {
      setSortOrder((prev) => (prev === "asc" ? "desc" : "asc"));
    } else {
      setSortOption(option);
      setSortOrder("desc");
    }
  };

  const filteredAndSortedItems = useMemo(() => {
    const filtered = showOnlyActive
      ? jari.filter((item) => !item.isCompleted)
      : jari;

    return [...filtered].sort((a, b) => {
      if (sortOption === "time") {
        const diff =
          new Date(a.createTime).getTime() - new Date(b.createTime).getTime();
        return sortOrder === "asc" ? diff : -diff;
      } else {
        const diff = a.price - b.price;
        return sortOrder === "asc" ? diff : -diff;
      }
    });
  }, [jari, showOnlyActive, sortOption, sortOrder]);

  const timeLabel =
    sortOrder === "desc" && sortOption === "time" ? "최신순 ↓" : "오래된순 ↑";
  const priceLabel =
    sortOrder === "desc" && sortOption === "price" ? "가격↑" : "가격↓";

  return (
    <section className="max-h-[600px] overflow-y-auto pr-1">
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
            onClick={() => setShowOnlyActive((prev) => !prev)}
            className={clsx(
              "px-3 py-1 text-[11px] rounded-md border font-medium transition duration-150",
              showOnlyActive
                ? "bg-white text-black shadow"
                : "text-white border-white hover:bg-white hover:text-black hover:shadow"
            )}
          >
            {showOnlyActive ? "전체 보기" : "판매중만 보기"}
          </Button>
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

      <TradeList items={filteredAndSortedItems} />
    </section>
  );
};

export default TradeSection;
