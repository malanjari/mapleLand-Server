// src/feature/jari/ui/JariMiniMapCard.tsx

import { Link } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import { MapItem } from "@/entity/map/api/getAllMaps";

interface Props {
  mapMeta: MapItem | null;
  name?: string;
  isAlarmOn: boolean;
  onToggle: () => void;
}

export const JariMiniMapCard = ({ mapMeta, name }: Props) => {
  if (!mapMeta) return null;

  return (
    <div className="flex flex-col border border-neutral-700 bg-neutral-800 p-4 justify-between rounded-md gap-4">
      {/* 헤더 */}
      <div className="text-sm font-bold flex flex-col items-center justify-center gap-2 text-white">
        {mapMeta.miniMapImageLogoUrl && (
          <img
            src={mapMeta.miniMapImageLogoUrl}
            alt="map logo"
            fetchPriority="high"
            className="w-10 h-10 object-contain rounded p-1"
          />
        )}
        <p className="text-lg text-center">{name?.split(":")[1] ?? name}</p>
        {mapMeta.miniMapImageUrl && (
          <img
            src={mapMeta.miniMapImageUrl}
            className="max-h-[300px]"
            alt="mini map"
            fetchPriority="high"
          />
        )}
      </div>

      {/* 버튼들 */}
      <div className="flex flex-col gap-2">
        <Button
          asChild
          variant="register"
          className="text-white px-4 py-2 rounded-md font-semibold transition w-full"
        >
          <Link to={`/jari/register/${name}`} className="w-full">
            + 자리 등록하기
          </Link>
        </Button>
      </div>
    </div>
  );
};
