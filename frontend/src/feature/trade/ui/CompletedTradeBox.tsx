import { motion, AnimatePresence } from "framer-motion";

import { useLatestCompletedTrade } from "../hooks/useCompletedTrades";

export const CompletedTradeBox = () => {
  const trade = useLatestCompletedTrade();
  console.log(trade);
  return (
    <div className="">
      <AnimatePresence mode="wait">
        {trade && (
          <motion.div
            key={trade.mapName}
            initial={{ opacity: 0, y: -10 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0, y: 10 }}
            transition={{ duration: 0.3 }}
          >
            <div className="self-start bg-gradient-to-r from-neutral-700 to-neutral-800 border border-green-500 text-green-300 px-4 py-3 rounded-lg text-sm font-medium shadow-sm flex items-center gap-2 w-full">
              <span className="text-lg">✅</span>
              <span className="leading-snug">
                [{trade.mapName}] — {trade.price.toLocaleString()} 메소{" "}
                <span className="text-green-400 text-sm ml-1">
                  {trade.tradeType === "SELL" ? "판매 완료" : "구매 완료"}
                </span>
              </span>
            </div>
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
};
