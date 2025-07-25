import { Link } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import { WORLDS } from "@/shared/config/worlds";

interface Props {
  worldKey?: string;
}

export const WorldInfoPanel = ({ worldKey }: Props) => {
  const matched = WORLDS.find((w) => w.keyword === worldKey);
  if (!matched) return null;

  return (
    <div className="flex flex-col border border-neutral-700 bg-neutral-800 p-4 justify-between rounded-md">
      <h2 className="text-lg font-bold flex flex-col items-center justify-center gap-2 text-white mb-4">
        {matched.name}
      </h2>
      <img
        className="object-contain"
        src={matched.image}
        alt={matched.name}
        fetchPriority="high"
      />
      <Link to="/jari/register" className="w-full">
        <Button
          variant="register"
          className="mt-4 text-white px-4 py-2 rounded-md font-semibold transition w-full"
        >
          + 자리 등록하기
        </Button>
      </Link>
    </div>
  );
};
