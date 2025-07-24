import { useState, useMemo } from "react";
import clsx from "clsx";
import TradeList from "./TradeList";
import { JariItem } from "@/entity/jari/model/type";
import { Button } from "@/shared/ui/button/Button";

interface Props {
  title: string;
  color: "blue" | "red";
  jari: JariItem[];
  refetch: () => void;
  showEditButton?: boolean;
}

type SortOption = "time" | "price";
type SortOrder = "asc" | "desc";

const TradeSection = ({
  title,
  color,
  jari,
  refetch,
  showEditButton = true,
}: Props) => {
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
    <section className=" ">
      <div
        className={clsx(
          "text-white text-sm font-semibold px-4 py-4 mb-4 rounded-sm shadow-lg transition",
          "flex flex-col gap-3",
          {
            "bg-gradient-to-r from-blue-600 to-blue-500": color === "blue",
            "bg-gradient-to-r from-red-600 to-red-500": color === "red",
          }
        )}
      >
        {/* 타이틀 */}
        <div className="flex justify-between items-center">
          <span className="text-lg font-bold tracking-tight">
            {title}({filteredAndSortedItems.length})
          </span>
        </div>

        {/* 버튼 그룹 */}
        <div className="flex flex-wrap gap-1 text-xs ">
          <Button
            variant="ghost"
            onClick={() => setShowOnlyActive((prev) => !prev)}
            className={clsx(
              "px-2 py-[2px] h-6 text-[11px] rounded border font-medium",
              showOnlyActive
                ? "bg-white text-black shadow"
                : "text-white border-white hover:bg-white hover:text-black hover:shadow"
            )}
          >
            {showOnlyActive ? "전체 보기" : "거래중만 보기"}
          </Button>

          <Button
            variant="ghost"
            onClick={() => toggleSortOption("time")}
            className={clsx(
              "px-2 py-[2px] h-6 text-[11px] rounded border font-medium",
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
              "px-2 py-[2px] h-6 text-[11px] rounded border font-medium",
              sortOption === "price"
                ? "bg-white text-black shadow"
                : "text-white border-white hover:bg-white hover:text-black hover:shadow"
            )}
          >
            {priceLabel}
          </Button>
        </div>
      </div>

      <TradeList
        items={filteredAndSortedItems}
        refetch={refetch}
        showEditButton={showEditButton}
      />
    </section>
  );
};

export default TradeSection;
