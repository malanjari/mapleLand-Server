import { JariItem } from "@/entity/jari/model/type";
import { useUser } from "@/entity/user/hooks/useUser";
import { EditJariPopover } from "../../jari/ui/EditJariPopover";
import { TradeBadges } from "./TradeBadges";
import { TradeCardHeader } from "./TradeCardHeader";
import { useTradeCard } from "../hooks/useTradeCard";
import { ReportButton } from "../../report/ui/ReportButton";
import clsx from "clsx";

interface Props {
  item: JariItem;
  refetch: () => void;
  showEditButton: boolean;
}

export type ServerColor = "Red" | "Yellow" | "Green";
const TradeCard = ({ item, refetch, showEditButton }: Props) => {
  const user = useUser();

  const isOwner = user?.user?.userId === item.userId;
  const isAdmin = user?.user?.role === "ROLE_ADMIN";

  const {
    editPrice,
    setEditPrice,
    editComment,
    setEditComment,
    editServerColor,
    setEditServerColor,
    editNegotiationOption,
    setEditNegotiationOption,
    handleUpdate,
    handleDelete,
    handleMarkAsCompleted,
    showEditBox,
    setShowEditBox,
    handleBump,
  } = useTradeCard(item, refetch);

  return (
    <div
      className={clsx(
        "bg-neutral-800 text-white rounded-md py-4 px-4 flex flex-col gap-3 items-start shadow transition duration-300",
        {
          "opacity-40 grayscale": item.isCompleted,
        }
      )}
    >
      <TradeCardHeader
        mapName={item.mapName}
        price={item.price}
        monsterImageUrl={item.monsterImageUrl}
        userId={item.userId}
        userImage={item.userImage}
        globalName={item.globalName}
        createTime={item.createTime}
        discordId={item.discordId}
        isAdmin={isAdmin}
        refetch={refetch}
        mapId={item.userMapId}
      />

      {/* 협의 옵션 및 코멘트 */}
      <div className="w-full flex border-b pb-1 border-neutral-700 justify-between">
        <div className="flex items-center gap-2 w-full">
          {isOwner && showEditButton && !item.isCompleted && (
            <EditJariPopover
              showEditBox={showEditBox}
              setShowEditBox={setShowEditBox}
              editServerColor={editServerColor}
              editPrice={editPrice}
              editNegotiationOption={editNegotiationOption}
              editComment={editComment}
              setEditServerColor={setEditServerColor}
              setEditPrice={setEditPrice}
              setEditNegotiationOption={setEditNegotiationOption}
              setEditComment={setEditComment}
              handleMarkAsCompleted={handleMarkAsCompleted}
              handleDelete={handleDelete}
              handleUpdate={handleUpdate}
              handleBump={handleBump}
            />
          )}
          <div className="flex-1 flex justify-between items-center">
            <TradeBadges
              serverColor={item.serverColor as "Red" | "Yellow" | "Green"}
              negotiationOption={item.negotiationOption}
              comment={item.comment}
            />{" "}
            {!isOwner && user?.user && (
              <ReportButton user={user.user} jariId={item.userMapId} />
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default TradeCard;
