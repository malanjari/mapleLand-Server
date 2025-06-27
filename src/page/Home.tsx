import { Link } from "react-router-dom";
import 루더스니할 from "@/shared/assets/루더스니할.jpg";
import 리프레 from "@/shared/assets/리프레.jpg";
import 빅토리아 from "@/shared/assets/빅토리아.jpg";
import 엘나스 from "@/shared/assets/엘나스.jpg";

const worlds = [
  { name: "루더스니할", image: 루더스니할 },
  { name: "리프레", image: 리프레 },
  { name: "빅토리아", image: 빅토리아 },
  { name: "엘나스", image: 엘나스 },
];

const Home = () => {
  return (
    <div className="py-10 flex flex-col gap-10">
      <div className="self-start max-w-[300px] bg-[#5865F2] text-white px-4 py-2 rounded-md text-xs xs:text-sm font-medium shadow hover:bg-[#4752c4] transition cursor-pointer">
        메렌자리.kr을 사용하기 위한 디스코드 설정!
      </div>

      <div>
        <h2 className="text-xl font-bold mb-5">월드별 검색</h2>

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
    </div>
  );
};

export default Home;
