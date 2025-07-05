// src/widgets/worldSearch/WorldSearchGrid.tsx
import { Link } from "react-router-dom";
import { ludusNihal, leafre, victoria, elnath } from "@/shared/assets/world";

const worlds = [
  { name: "빅토리아", image: victoria },
  { name: "엘나스", image: elnath },
  { name: "루더스니할", image: ludusNihal },
  { name: "리프레", image: leafre },
];

export const WorldSearchGrid = () => {
  return (
    <div className="  p-4 mb:p-8 rounded-lg bg-neutral-900">
      <h2 className="text-xl font-bold mb-5">🗺️ 월드별 검색</h2>
      <div className="grid grid-cols-2 lg:grid-cols-4 gap-6">
        {worlds.map((world) => (
          <Link
            to={`/world/${world.name}`}
            key={world.name}
            className="group relative rounded-xl overflow-hidden shadow-lg hover:scale-105 transition-transform"
          >
            <img
              src={world.image}
              alt={world.name}
              className="object-cover w-full "
            />
            <div className="absolute inset-0 bg-black/40 flex items-center justify-center opacity-0 group-hover:opacity-100 transition-opacity">
              <p className="text-white font-bold text-lg">#{world.name}</p>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
};
