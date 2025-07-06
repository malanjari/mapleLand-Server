// src/entities/jari/ui/JariCard.tsx
import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/shared/ui/card/card";
import { Link } from "react-router-dom";

interface JariCardProps {
  spot: {
    mapName: string;
    monsterImageUrl: string;
    registerCount: number;
  };
  rank: number;
}

export const JariCard = ({ spot, rank }: JariCardProps) => {
  const shortMapName = spot.mapName.includes(":")
    ? spot.mapName.split(":")[1].trim()
    : spot.mapName;

  const rankColor =
    rank === 1
      ? "text-yellow-400"
      : rank === 2
      ? "text-gray-300"
      : rank === 3
      ? "text-orange-400"
      : "";

  return (
    <Link to={`/jari/${spot.mapName}`} className="block">
      <Card className="bg-neutral-800 text-white hover:bg-neutral-700  transition shadow-md cursor-pointer  flex flex-col aspect-[10/5]">
        <CardHeader className="flex flex-col items-center  gap-2 pt-4 pb-0 px-2">
          <div className="relative flex items-center justify-center w-8 h-8 rounded-full bg-indigo-600 font-bold text-sm">
            {rank}
            {rank <= 3 && (
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className={`absolute -top-3 w-5 h-5 drop-shadow ${rankColor}`}
                fill="currentColor"
                viewBox="0 0 24 24"
              >
                <path d="M2 9l2 9h16l2-9-5 4-4-6-4 6-5-4z" />
              </svg>
            )}
          </div>
          <img
            src={spot.monsterImageUrl}
            alt={spot.mapName}
            className="w-24 h-24 object-contain rounded-md "
          />
        </CardHeader>

        <CardContent className="text-center px-3 pb-4 pt-2">
          <CardTitle className="text-lg font-semibold truncate">
            {shortMapName}
          </CardTitle>
          <p className="text-sm text-gray-400 mt-1">
            거래 횟수:{" "}
            <span className="text-white font-medium">
              {spot.registerCount.toLocaleString()}
            </span>
          </p>
        </CardContent>
      </Card>
    </Link>
  );
};
