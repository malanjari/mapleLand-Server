// src/entities/jari/ui/JariCard.tsx
import { Card, CardTitle } from "@/shared/ui/card/card";
import { Link } from "react-router-dom";

interface JariCardProps {
  spot: {
    mapName: string;
    monsterImageUrl: string;
    registerCount: number;
  };
  rank: number;
}

const getRankStyle = (rank: number) => {
  switch (rank) {
    case 1:
      return "bg-yellow-400 text-black ring-2 ring-yellow-300";
    case 2:
      return "bg-gray-300 text-black ring-2 ring-gray-200";
    case 3:
      return "bg-orange-400 text-white ring-2 ring-orange-300";
    default:
      return "bg-indigo-600 text-white";
  }
};

export const JariCard = ({ spot, rank }: JariCardProps) => {
  const [areaName, shortMapName] = spot.mapName.includes(":")
    ? spot.mapName.split(":").map((s) => s.trim())
    : [null, spot.mapName.trim()];

  return (
    <Link
      to={`/jari/${encodeURIComponent(spot.mapName)}`}
      onMouseEnter={() => import("@/page/jari/WorldDetail")}
      className="block"
    >
      <Card className="relative bg-neutral-600 hover:bg-neutral-500 text-white transition duration-300 rounded-xl overflow-hidden shadow-md hover:shadow-lg group">
        {/* 랭킹 배지 */}
        <div
          className={`absolute top-2 left-2 px-2 py-1 text-xs font-bold rounded-full ${getRankStyle(
            rank
          )}`}
        >
          #{rank}
        </div>

        {/* 몬스터 이미지 */}
        <div className="w-full h-32 bg-neutral-700  flex items-center justify-center border-b border-neutral-600">
          <img
            src={spot.monsterImageUrl}
            alt={spot.mapName}
            className="w-16 h-16 object-contain drop-shadow-lg group-hover:scale-125 transition"
            loading="lazy"
          />
        </div>

        {/* 하단 정보 */}
        <div className="p-4 flex flex-col items-center gap-1">
          <CardTitle className="text-base font-semibold text-center leading-snug">
            {areaName && <p className="text-sm text-gray-300">{areaName}</p>}
            <p className="text-lg text-white">{shortMapName}</p>
          </CardTitle>
          <p className="text-sm text-gray-200">
            매물 수:{" "}
            <span className="text-white font-medium">
              {spot.registerCount.toLocaleString()}
            </span>
          </p>
        </div>
      </Card>
    </Link>
  );
};
