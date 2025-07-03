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
        <div className="grid grid-cols-2 sm:grid-cols-4 gap-4 text-center">
          {loading ? (
            <p className="text-white text-sm col-span-3">로딩 중...</p>
          ) : (
            popularMaps.map((spot) => (
              <div className="flex flex-col">
                <Link
                  to={`/jari/${spot.mapName}`}
                  key={spot.mapName}
                  className="flex flex-col rounded-xl items-center justify-center gap-1 cursor-pointer bg-gray-800 transition hover:bg-gray-700 p-3 max-w-[500px] h-[130px]"
                >
                  <img
                    src={spot.monsterImageUrl}
                    alt={spot.mapName}
                    className="w-20 h-20 object-contain"
                  />
                  <p className="text-xs font-semibold ㅈ text-white text-center">
                    {spot.mapName}
                  </p>
                </Link>
                <p className="mt-2 text-xs text-gray-400 text-center">
                  거래 횟수 :{" "}
                  <span className="font-semibold text-white">
                    {spot.registerCount.toLocaleString()}
                  </span>
                </p>
              </div>
            ))
          )}
        </div>
      </div>
    </div>
  );
};

export default HomePage;
