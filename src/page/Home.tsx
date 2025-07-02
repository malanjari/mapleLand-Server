import { Link } from "react-router-dom";
import { ludusNihal, leafre, victoria, elnath } from "@/shared/assets/world";
import { handleDiscordLogin } from "@/shared/utils/auth/discord";
import {
  jrNewtie,
  blackKentaurus,
  skelosaurus,
  redWyvern,
  shark,
} from "@/shared/assets/monster";
import { useUser } from "@/entity/user/hooks/useUser";

const worlds = [
  { name: "루더스니할", image: ludusNihal },
  { name: "리프레", image: leafre },
  { name: "빅토리아", image: victoria },
  { name: "엘나스", image: elnath },
];

const hotSpot = [
  { name: "난파선의 무덤", image: shark },
  { name: "검은 켄타우로스의 영역", image: blackKentaurus },
  { name: "불과 어둠의 전장", image: blackKentaurus },
  { name: "망가진 용의 둥지", image: jrNewtie },
  { name: "큰 둥지 봉우리", image: skelosaurus },
  { name: "레드 와이번의 둥지", image: redWyvern },
];

const HomePage = () => {
  const user = useUser();
  return (
    <div className="py-10 flex flex-col gap-10">
      <div className="self-start max-w-[300px] bg-[#5865F2] text-white px-4 py-2 rounded-md text-xs xs:text-sm font-medium shadow hover:bg-[#4752c4] transition cursor-pointer">
        메렌자리.kr을 사용하기 위한 디스코드 설정!
      </div>
      {user ? (
        <div className="bg-neutral-900 p-4 rounded-lg shadow text-sm text-white flex items-center gap-3">
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
        <div className="bg-neutral-900 p-4 rounded-lg shadow text-sm text-white flex items-center gap-3">
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

        <div className="grid grid-cols-3  gap-4 text-center">
          {hotSpot.map((spot) => (
            <Link
              to={`/jari/${spot.name}`}
              key={spot.name}
              className="flex flex-col rounded-xl items-center justify-center gap-1 cursor-pointer bg-gray-800 transition hover:bg-gray-700"
            >
              <img
                src={spot.image}
                alt={spot.name}
                className="w-14 sm:w-18 object-cover rounded-md transition duration-100 hover:scale-105"
              />
              <p className="text-xs">{spot.name}</p>
            </Link>
          ))}
        </div>
      </div>
    </div>
  );
};

export default HomePage;
