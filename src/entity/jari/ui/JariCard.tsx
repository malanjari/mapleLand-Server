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

const getCardBg = (rank: number) => {
  switch (rank) {
    case 1:
      return "bg-yellow-100 hover:bg-yellow-200 text-black";
    case 2:
      return "bg-gray-200 hover:bg-gray-300 text-black";
    case 3:
      return "bg-orange-100 hover:bg-orange-200 text-black";
    default:
      return "bg-zinc-600 hover:bg-zinc-500 text-white";
  }
};

export const JariCard = ({ spot, rank }: JariCardProps) => {
  const shortMapName = spot.mapName.includes(":")
    ? spot.mapName.split(":")[1].trim()
    : spot.mapName;

  return (
    <Link to={`/jari/${spot.mapName}`} className="block">
      <Card
        className={`${getCardBg(
          rank
        )} flex flex-col items-center transition shadow-md hover:shadow-lg hover:scale-[1.02] duration-200 cursor-pointer aspect-[10/5] p-4`}
      >
        {/* 랭킹 뱃지 */}
        <div
          className={`relative flex items-center justify-center w-10 h-10 rounded-full font-bold text-sm ${getRankStyle(
            rank
          )}`}
        >
          {rank}
          {rank <= 3 && (
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="absolute -top-3 w-5 h-5 drop-shadow"
              fill="currentColor"
              viewBox="0 0 24 24"
            >
              <path d="M2 9l2 9h16l2-9-5 4-4-6-4 6-5-4z" />
            </svg>
          )}
        </div>

        {/* 몬스터 이미지 */}
        <img
          src={spot.monsterImageUrl}
          alt={spot.mapName}
          className="w-24 h-24 object-contain rounded-md mt-2 "
        />

        {/* 텍스트 정보 */}
        <div className="text-center mt-3">
          <CardTitle className="text-lg font-semibold truncate">
            {shortMapName}
          </CardTitle>
          <p className="text-sm text-gray-500 mt-1">
            거래 횟수:{" "}
            <span className="font-medium">
              {spot.registerCount.toLocaleString()}
            </span>
          </p>
        </div>
      </Card>
    </Link>
  );
};
