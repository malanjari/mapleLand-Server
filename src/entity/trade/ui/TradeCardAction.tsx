import * as Popover from "@radix-ui/react-popover";
import { TradeEditForm } from "@/feature/trade/api/ui/TradeEditForm";
import { JariItem } from "@/entity/trade/model/type";
import { useState } from "react";

interface Props {
  item: JariItem;
  refetch: () => void;
}

export const TradeCardActions = ({ item, refetch }: Props) => {
  const [showEditBox, setShowEditBox] = useState(false);

  return (
    <Popover.Root open={showEditBox} onOpenChange={setShowEditBox}>
      <Popover.Trigger asChild>
        <button className="text-xs text-gray-200 bg-zinc-700 px-2 py-0.5 rounded-sm hover:bg-zinc-600 hover:text-white border border-zinc-500 transition">
          수정
        </button>
      </Popover.Trigger>
      <Popover.Content
        side="bottom"
        align="start"
        sideOffset={4}
        className="w-[200px] z-50 bg-zinc-800 border border-zinc-700 rounded-md text-xs text-gray-300 p-3 flex flex-col gap-2 shadow-lg"
      >
        <TradeEditForm
          item={item}
          refetch={refetch}
          onClose={() => setShowEditBox(false)}
        />
      </Popover.Content>
    </Popover.Root>
  );
};
