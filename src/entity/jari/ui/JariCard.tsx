// src/entities/jari/ui/JariCard.tsx
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
  return (
    <Link
      to={`/jari/${spot.mapName}`}
      className="flex items-center gap-4 bg-gray-800 hover:bg-gray-700 rounded-xl py-4 px-2 sm:px-4 cursor-pointer transition"
    >
      <div className="relative flex items-center justify-center w-8 h-8 rounded-full bg-indigo-600 text-white font-bold text-lg select-none">
        {rank}
        {[0, 1, 2].includes(rank - 1) && (
          <svg
            xmlns="http://www.w3.org/2000/svg"
            className={`absolute -top-3 w-6 h-6 drop-shadow-lg ${
              rank === 1
                ? "text-yellow-400"
                : rank === 2
                ? "text-gray-300"
                : "text-orange-400"
            }`}
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
        className="w-14 h-14 object-contain rounded-md"
      />

      <div className="flex flex-col flex-grow">
        <p className="text-white font-semibold text-xs lg:text-sm truncate">
          {spot.mapName.includes(":")
            ? spot.mapName.split(":")[1].trim()
            : spot.mapName}
        </p>
        <p className="text-gray-400 text-sm mt-1">
          거래 횟수:{" "}
          <span className="text-white font-semibold">
            {spot.registerCount.toLocaleString()}
          </span>
        </p>
      </div>
    </Link>
  );
};
