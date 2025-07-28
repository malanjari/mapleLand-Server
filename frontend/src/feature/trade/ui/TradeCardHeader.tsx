// src/feature/jari/ui/TradeCardHeader.tsx
import { Link } from "react-router-dom";
import { formatDistanceToNow } from "date-fns";
import { ko } from "date-fns/locale";
import mesoIcon from "@/shared/assets/icon/mesoIcon.webp";
import AdminKebabMenu from "@/feature/delete/ui/DeleteKebabMenu";

interface Props {
  mapName: string;
  price: number;
  monsterImageUrl: string;
  userId: string | number;
  userImage: string | null;
  globalName: string;
  createTime: string;
  discordId: string;
  isAdmin: boolean;
  refetch?: () => void;
  mapId: number;
  isCompleted: boolean;
  updateTime: string;
}

export const TradeCardHeader = ({
  mapName,
  price,
  monsterImageUrl,
  userId,
  userImage,
  globalName,
  createTime,
  discordId,
  isAdmin,
  refetch,
  mapId,
  isCompleted,
  updateTime,
}: Props) => {
  const koreaTime = new Date(
    new Date(createTime).getTime() + (8 * 60 * 60 + 59 * 60 + 50) * 1000
  );
  const updateKoreaTime = new Date(
    new Date(updateTime).getTime() + (8 * 60 * 60 + 59 * 60 + 50) * 1000
  );
  return (
    <div className="flex items-center justify-center gap-3 w-full">
      {/* 몬스터 이미지 */}
      <Link to={`/jari/${mapName}`} title={`${mapName} 자리 페이지로 이동`}>
        <img
          src={monsterImageUrl}
          alt={mapName}
          loading="lazy"
          className="w-16 h-16 object-contain "
        />
      </Link>
      {/* 맵 이름 + 가격 */}
      <div className="flex flex-col w-full relative">
        <div className="flex justify-between items-center pb-1 border-b border-neutral-700">
          <p className="text-xs lg:text-base font-bold">
            {mapName.includes(":") ? mapName.split(":")[1].trim() : mapName}
          </p>
          <Link
            to={`/profile/${userId}`}
            className="flex gap-1 items-center cursor-pointer"
          >
            <img
              src={
                userImage
                  ? `https://cdn.discordapp.com/avatars/${discordId}/${userImage}.png`
                  : "https://cdn.discordapp.com/embed/avatars/0.png"
              }
              alt="user avatar"
              className="w-4 h-4 lg:w-6 lg:h-6 rounded-full"
            />
            <span className="text-[10px] lg:text-xs">{globalName}</span>
          </Link>
          {isAdmin && (
            <AdminKebabMenu
              isAdmin={isAdmin}
              mapId={mapId}
              onDeleted={refetch}
            />
          )}
        </div>

        <div className="text-sm text-gray-200 flex items-center justify-between gap-1 border-b py-1 border-neutral-700">
          <div className="relative flex items-center gap-1 md:text-sm">
            {price.toLocaleString()}
            <img
              className="w-4 relative top-[1.3px]"
              src={mesoIcon}
              alt="메소"
            />
          </div>
          <span className="text-xs">
            {isCompleted
              ? formatDistanceToNow(updateKoreaTime, {
                  addSuffix: true,
                  locale: ko,
                })
              : formatDistanceToNow(koreaTime, {
                  addSuffix: true,
                  locale: ko,
                })}
          </span>
        </div>
      </div>
    </div>
  );
};
