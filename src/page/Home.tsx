import { Link } from "react-router-dom";
import { ludusNihal, leafre, victoria, elnath } from "@/shared/assets/world";
import { handleDiscordLogin } from "@/shared/utils/auth/discord";

import { useUser } from "@/entity/user/hooks/useUser";
import { useEffect, useState } from "react";
import { fetchPopularMaps, PopularMap } from "@/feature/jari/api/popularJari";

const worlds = [
  { name: "루더스니할", image: ludusNihal },
  { name: "리프레", image: leafre },
  { name: "빅토리아", image: victoria },
  { name: "엘나스", image: elnath },
];

const HomePage = () => {
  const user = useUser();
  const [popularMaps, setPopularMaps] = useState<PopularMap[]>([]);
  const [loading, setLoading] = useState(true);
  useEffect(() => {
    const load = async () => {
      try {
        const data = await fetchPopularMaps();
        console.log(data);
        setPopularMaps(data);
      } catch (err) {
        console.error("인기 맵 로딩 실패:", err);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, []);
  const half = Math.ceil(popularMaps.length / 2);
  const leftColumn = popularMaps.slice(0, half);
  const rightColumn = popularMaps.slice(half);
  return (
    <div className="py-10 flex flex-col gap-10">
      <div className="self-start max-w-[300px] bg-[#5865F2] text-white px-4 py-2 rounded-md text-xs xs:text-sm font-medium shadow hover:bg-[#4752c4] transition cursor-pointer">
        메렌자리.kr을 사용하기 위한 디스코드 설정!
      </div>
      {user ? (
        <div className="bg-neutral-950   p-4 rounded-lg shadow text-sm text-white flex items-center gap-3">
          <img
            src={
              user.user.avatar
                ? `https://cdn.discordapp.com/avatars/${user.user.id}/${user.user.avatar}.png`
                : "https://cdn.discordapp.com/embed/avatars/0.png"
            }
            className="w-6 h-6 rounded-full"
            alt="user avatar"
          />
          <span>{user.user.globalName}님, 환영합니다 👋</span>
        </div>
      ) : (
        <div className="bg-neutral-950  p-4 rounded-lg shadow text-sm text-white flex items-center gap-3">
          <img
            onClick={handleDiscordLogin}
            src="https://cdn.discordapp.com/embed/avatars/0.png"
            className="w-6 h-6 rounded-full cursor-pointer"
            alt="default avatar"
          />
          <span>디스코드 로그인을 통해 더 많은 기능을 이용해보세요!</span>
        </div>
      )}

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
        <h2 className="text-xl font-bold mb-5">🔥 인기 자리</h2>

        <div className="flex flex-col sm:flex-row gap-3 px-1">
          {/* 왼쪽 컬럼 */}
          <div className="flex flex-col w-full sm:w-1/2 gap-3">
            {loading ? (
              <p className="text-white text-center col-span-full">로딩 중...</p>
            ) : (
              leftColumn.map((spot, idx) => (
                <Link
                  key={spot.mapName}
                  to={`/jari/${spot.mapName}`}
                  className="flex items-center gap-4 bg-gray-800 hover:bg-gray-700 rounded-xl py-4 px-2 sm:px-4 cursor-pointer transition"
                >
                  {/* 순위 번호 */}
                  <div className="relative flex items-center justify-center w-8 h-8 rounded-full bg-indigo-600 text-white font-bold text-lg select-none">
                    {idx + 1}
                    {[0, 1, 2].includes(idx) && (
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        className={`absolute -top-3 w-6 h-6 drop-shadow-lg ${
                          idx === 0
                            ? "text-yellow-400"
                            : idx === 1
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
              ))
            )}
          </div>

          {/* 오른쪽 컬럼 */}
          <div className="flex flex-col w-full sm:w-1/2 gap-3">
            {!loading &&
              rightColumn.map((spot, idx) => (
                <Link
                  key={spot.mapName}
                  to={`/jari/${spot.mapName}`}
                  className="flex items-center gap-4 bg-gray-800 hover:bg-gray-700 rounded-xl py-4 px-2 sm:px-4 cursor-pointer transition"
                >
                  <div className="relative flex items-center justify-center w-8 h-8 rounded-full bg-indigo-600 text-white font-bold text-lg select-none">
                    {idx + 1 + half}
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
              ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
