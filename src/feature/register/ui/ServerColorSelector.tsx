import { Input } from "@/shared/ui/input/Input";

interface ServerColorSelectorProps {
  serverColor: "Red" | "Yellow" | "Green" | null;
  onChange: (color: "Red" | "Yellow" | "Green") => void;
}

export const ServerColorSelector = ({
  serverColor,
  onChange,
}: ServerColorSelectorProps) => {
  return (
    <div className="border-b border-neutral-700 pb-4 mb-4">
      <p className="font-medium mb-2 text-white">맵 상태를 선택해주세요</p>
      <div className="flex gap-4">
        <label className="flex items-center gap-2 cursor-pointer">
          <Input
            type="radio"
            name="mapColor"
            value="Red"
            checked={serverColor === "Red"}
            onChange={() => onChange("Red")}
            className="accent-red-500 w-5 cursor-pointer"
          />
          <span className="text-white">빨채</span>
        </label>
        <label className="flex items-center gap-2 cursor-pointer">
          <Input
            type="radio"
            name="mapColor"
            value="Yellow"
            checked={serverColor === "Yellow"}
            onChange={() => onChange("Yellow")}
            className="accent-yellow-400 w-5 cursor-pointer"
          />
          <span className="text-white">노채</span>
        </label>
        <label className="flex items-center gap-2 cursor-pointer">
          <Input
            type="radio"
            name="mapColor"
            value="Green"
            checked={serverColor === "Green"}
            onChange={() => onChange("Green")}
            className="accent-green-500 w-5 cursor-pointer"
          />
          <span className="text-white">초채</span>
        </label>
      </div>
    </div>
  );
};
