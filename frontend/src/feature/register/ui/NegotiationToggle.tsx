import { Input } from "@/shared/ui/input/Input";

interface NegotiationToggleProps {
  checked: boolean;
  onChange: (checked: boolean) => void;
}

export const NegotiationToggle = ({
  checked,
  onChange,
}: NegotiationToggleProps) => {
  return (
    <div className="flex items-center gap-2 border-b border-neutral-700 pb-4 mb-4">
      <Input
        type="checkbox"
        checked={checked}
        onChange={(e) => onChange(e.target.checked)}
        id="negotiation"
        className="w-3 cursor-pointer"
      />
      <label
        htmlFor="negotiation"
        className="text-sm cursor-pointer text-white"
      >
        흥정 가능
      </label>
    </div>
  );
};
