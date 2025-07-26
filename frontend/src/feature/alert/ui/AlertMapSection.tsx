import clsx from "clsx";
import { AlertMapCard } from "./AlertMapCard";
import { AlertMapEmptyState } from "./AlertMapEmptyState";

interface Props {
  isMyProfile: boolean;
  alertMaps: {
    mapId: number;
    mapName: string;
    monsterImageUrl: string;
  }[];
}

export const AlertMapSection = ({ isMyProfile, alertMaps }: Props) => {
  if (!isMyProfile) return null;

  return (
    <div className="lg:mb-6">
      {/* 타이틀 */}
      <div
        className={clsx(

          "text-white text-sm font-semibold px-4 py-4 mb-4 rounded-sm shadow-lg transition",

          "flex flex-col gap-3",
          "bg-gradient-to-r from-yellow-600 to-yellow-500"
        )}
      >
        <div className="flex justify-between items-center">
          <span className="text-lg font-bold tracking-tight">
            🔔 알림 설정한 맵 ({alertMaps.length})
          </span>
          <span className="text-xs font-normal text-white/90">
            최대 2개까지 설정 가능
          </span>
        </div>
      </div>

      {/* 내용 */}
      {alertMaps.length > 0 ? (
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          {alertMaps.map((map) => (
            <AlertMapCard key={map.mapId} map={map} />
          ))}
        </div>
      ) : (
        <AlertMapEmptyState />
      )}
    </div>
  );
};
