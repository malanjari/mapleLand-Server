import { Link } from "react-router-dom";
import 루더스니할 from "@/shared/assets/루더스니할.jpg";
import 리프레 from "@/shared/assets/리프레.jpg";
import 빅토리아 from "@/shared/assets/빅토리아.jpg";
import 엘나스 from "@/shared/assets/엘나스.jpg";

import {
  coolieZombie,
  starPixie,
  jrNewtie,
  blackKentaurus,
  skelosaurus,
  redWyvern,
} from "@/shared/assets/monster";

const worlds = [
  { name: "루더스니할", image: 루더스니할 },
  { name: "리프레", image: 리프레 },
  { name: "빅토리아", image: 빅토리아 },
  { name: "엘나스", image: 엘나스 },
];

const hotSpot = [
  { name: "구름공원1", image: starPixie },
  { name: "죽은나무숲2", image: coolieZombie },
  { name: "불과 어둠의 전장", image: blackKentaurus },
  { name: "망가진 용의 둥지", image: jrNewtie },
  { name: "큰 둥지 봉우리", image: skelosaurus },
  { name: "레드 와이번의 둥지", image: redWyvern },
];

const Home = () => {
  return (
    <div className="py-10 flex flex-col gap-10">
      <div className="self-start max-w-[300px] bg-[#5865F2] text-white px-4 py-2 rounded-md text-xs xs:text-sm font-medium shadow hover:bg-[#4752c4] transition cursor-pointer">
        메렌자리.kr을 사용하기 위한 디스코드 설정!
      </div>

      <div>
        <h2 className="text-xl font-bold mb-5">🗺️ 월드별 검색</h2>

        <div className="grid grid-cols-2 sm:grid-cols-4 gap-6">
          {worlds.map((world) => (
            <Link
              to={`/world/${world.name}`}
              key={world.name}
              className="group relative rounded-xl overflow-hidden shadow-lg hover:scale-105 transition-transform"
            >
              <img
                src={world.image}
                alt={world.name}
                className="object-cover w-full h-32 sm:h-40"
              />
              <div className="absolute inset-0 bg-black/40 flex items-center justify-center opacity-0 group-hover:opacity-100 transition-opacity">
                <p className="text-white font-bold text-lg">#{world.name}</p>
              </div>
            </Link>
          ))}
        </div>
      </div>
      <div>
        <h2 className="text-lg font-semibold mb-4">🔥 인기 사냥터</h2>

        <div className="grid grid-cols-3  gap-4 text-center">
          {hotSpot.map((spot) => (
            <div
              key={spot.name}
              className="flex flex-col items-center justify-center gap-1 cursor-pointer bg-gray-800 transition hover:bg-gray-700"
            >
              <img
                src={spot.image}
                alt={spot.name}
                className="w-14 h-18 sm:w-13 sm:h-20 object-cover rounded-md transition duration-100 hover:scale-105"
              />
              <p className="text-sm">{spot.name}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Home;
