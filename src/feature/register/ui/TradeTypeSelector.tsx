// features/register/ui/TradeTypeSelector.tsx
import { Button } from "@/shared/ui/button/Button";

interface Props {
  tradeType: "SELL" | "BUY" | null;
  onSelect: (type: "SELL" | "BUY") => void;
}

export const TradeTypeSelector = ({ tradeType, onSelect }: Props) => {
  return (
    <div className="w-full max-w-2xl space-y-2">
      <p className="text-white text-sm font-medium text-center">
        거래 타입을 선택해주세요
      </p>
      <div className="flex gap-4">
        <Button
          variant="none"
          onClick={() => onSelect("SELL")}
          className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
            tradeType === "SELL"
              ? "bg-red-600 text-white border-red-600"
              : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
          }`}
        >
          팝니다
        </Button>
        <Button
          variant="none"
          onClick={() => onSelect("BUY")}
          className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
            tradeType === "BUY"
              ? "bg-blue-600 text-white border-blue-600"
              : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
          }`}
        >
          삽니다
        </Button>
      </div>
    </div>
  );
};
