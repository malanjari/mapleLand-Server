import { Link } from "react-router-dom";

interface Props {
  map: {
    mapId: number;
    mapName: string;
    monsterImageUrl: string;
  };
}

export const AlertMapCard = ({ map }: Props) => {
  return (
    <div
      key={map.mapId}
      className="flex items-center gap-4 bg-neutral-800 rounded-md px-4 py-4 shadow-md transition"
    >
      <Link
        to={`/jari/${map.mapName}`}
        title={`${map.mapName} 자리 페이지로 이동`}
      >
        <img
          src={map.monsterImageUrl}
          alt="monster"
          className="w-16 h-16 object-contain rounded-lg p-1"
        />
      </Link>
      <div className="flex flex-col justify-center flex-1 gap-1">
        <p className="text-base font-bold leading-tight text-yellow-300 truncate pb-1 border-b border-neutral-700">
          {map.mapName.split(":").pop()}
        </p>
        <p className="text-sm text-neutral-300 pb-1 border-b border-neutral-700">
          알림이 설정되어 있습니다
        </p>
        <p className="text-xs text-neutral-500">
          이미지 누를 시 해당 자리 페이지로 이동
        </p>
      </div>
    </div>
  );
};
