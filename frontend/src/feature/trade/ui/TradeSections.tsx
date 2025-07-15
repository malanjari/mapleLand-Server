import { JariItem } from "@/entity/jari/model/type";
import TradeSection from "./TradeSection";

interface TradeSectionsProps {
  sellJari: JariItem[];
  buyJari: JariItem[];
  refetch: () => void;
}

export const TradeSections = ({
  sellJari,
  buyJari,
  refetch,
}: TradeSectionsProps) => (
  <div className="grid grid-cols-1 sm:grid-cols-2 col-span-6 gap-10 sm:gap-3 lg:mt-0">
    <TradeSection
      title="팝니다"
      color="red"
      jari={sellJari}
      refetch={refetch}
    />
    <TradeSection
      title="삽니다"
      color="blue"
      jari={buyJari}
      refetch={refetch}
    />
  </div>
);
