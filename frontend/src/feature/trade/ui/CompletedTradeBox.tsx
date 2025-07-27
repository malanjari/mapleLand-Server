import { useRecentCompletedTrades } from "@/entity/trade/hooks/useRecentCompletedTrades";
import { motion, AnimatePresence } from "framer-motion";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

export const CompletedTradeBox = () => {
  const { data: trades = [] } = useRecentCompletedTrades();
  const [index, setIndex] = useState(0);

  useEffect(() => {
    if (trades.length === 0) return;

    const timer = setInterval(() => {
      setIndex((prev) => (prev + 1) % trades.length);
    }, 5000);

    return () => clearInterval(timer);
  }, [trades]);

  const trade = trades[index];
  if (!trade) return null;

  const mapLabel = trade.mapName.split(":")[1] || trade.mapName;

  return (
    <div className="relative h-[60px] overflow-hidden">
      <AnimatePresence mode="wait">
        <motion.div
          key={trade.userMapId}
          initial={{ opacity: 0, y: -10 }}
          animate={{ opacity: 1, y: 0 }}
          exit={{ opacity: 0, y: 10 }}
          transition={{ duration: 0.4 }}
          className="absolute w-full"
        >
          <Link
            to={`/jari/${encodeURIComponent(trade.mapName)}`}
            className="flex justify-between items-center bg-gradient-to-r from-neutral-700 to-neutral-800 border border-green-500 text-green-300 px-4 py-3 rounded-lg text-sm font-medium shadow-sm gap-2 w-full cursor-pointer hover:from-neutral-600 hover:to-neutral-700 transition-colors"
          >
            <div className="flex items-center gap-2 overflow-hidden flex-1 min-w-0">
              <span className="text-lg">✅</span>
              <span className="truncate">
                {mapLabel} — {trade.price.toLocaleString()} 메소{" "}
                <span className="text-green-400 text-sm ml-1">거래완료</span>
              </span>
            </div>
          </Link>
        </motion.div>
      </AnimatePresence>
    </div>
  );
};
