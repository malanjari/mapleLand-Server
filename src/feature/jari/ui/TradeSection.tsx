import { useState, useMemo } from "react";
import clsx from "clsx";
import TradeList from "./TradeList";
import { JariItem } from "@/entity/trade/model/type";

interface Props {
  title: string;
  color: "blue" | "red";
  jari: JariItem[];
}

type SortOption = "recent" | "price";

const TradeSection = ({ title, color, jari }: Props) => {
  const [sortOption, setSortOption] = useState<SortOption>("recent");

  const sortedItems = useMemo(() => {
    return [...jari].sort((a, b) => {
      if (sortOption === "recent") {
        return (
          new Date(b.createTime).getTime() - new Date(a.createTime).getTime()
        );
      }
      return b.price - a.price;
    });
  }, [jari, sortOption]);

  return (
    <section className="max-h-[600px] overflow-y-auto pr-1">
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
          <button
            onClick={() => setSortOption("recent")}
            className={clsx(
              "px-2 py-1 rounded border",
              sortOption === "recent"
                ? "bg-white text-black"
                : "text-white border-white hover:bg-white hover:text-black transition"
            )}
          >
            최신순
          </button>
          <button
            onClick={() => setSortOption("price")}
            className={clsx(
              "px-2 py-1 rounded border",
              sortOption === "price"
                ? "bg-white text-black"
                : "text-white border-white hover:bg-white hover:text-black transition"
            )}
          >
            가격순
          </button>
        </div>
      </div>
      <TradeList items={sortedItems} />
    </section>
  );
};

export default TradeSection;
