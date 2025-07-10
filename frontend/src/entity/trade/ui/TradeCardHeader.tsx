import { JariItem } from "@/entity/trade/model/type";
import { Link } from "react-router-dom";

const TradeCardHeader = ({ item }: { item: JariItem }) => (
  <div className="flex items-center justify-center gap-3 w-full">
    <img
      src={item.monsterImageUrl}
      alt={item.mapName}
      className="w-16 h-16 object-contain"
    />
    <div className="flex flex-col w-full">
      <div className="flex justify-between items-center pb-1 border-b border-neutral-700">
        <p className="text-xs lg:text-base font-bold">
          {item.mapName.includes(":")
            ? item.mapName.split(":")[1].trim()
            : item.mapName}
        </p>
        <Link
          to={`/profile/${item.userId}`}
          className="flex gap-1 items-center cursor-pointer"
        >
          <img
            src={
              item.userImage
                ? `https://cdn.discordapp.com/avatars/${item.uniqueId}/${item.userImage}.png`
                : "https://cdn.discordapp.com/embed/avatars/0.png"
            }
            alt="user avatar"
            className="w-4 h-4 lg:w-6 lg:h-6 rounded-full"
          />
          <span className="text-[10px] lg:text-xs">{item.globalName}</span>
        </Link>
      </div>
    </div>
  </div>
);
export default TradeCardHeader;
