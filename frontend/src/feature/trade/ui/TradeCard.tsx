import { JariItem } from "@/entity/jari/model/type";
import { useUser } from "@/entity/user/hooks/useUser";
import { ReportDialog } from "@/feature/report/ui/ReportDialog";
import clsx from "clsx";

interface Props {
  item: JariItem;
  refetch: () => void;
  showEditButton: boolean;
}

export type ServerColor = "Red" | "Yellow" | "Green";

import { EditJariPopover } from "../../jari/ui/EditJariPopover";
import { TradeBadges } from "./TradeBadges";
import { TradeCardHeader } from "./TradeCardHeader";
import { useTradeCard } from "../hooks/useTradeCard";
import { submitReport } from "@/feature/report/ui/api/submitReport";
import { toast } from "@/shared/hooks/use-toast";
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
          {isOwner && showEditButton && (
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
            />
          )}
          <div className="flex-1 flex justify-between items-center">
            <TradeBadges
              serverColor={item.serverColor as "Red" | "Yellow" | "Green"}
              negotiationOption={item.negotiationOption}
              comment={item.comment}
            />{" "}
            {!isOwner && user?.user && (
              <ReportDialog
                trigger={
                  <button className="text-xs text-red-400 hover:text-red-300 px-2 py-0.5 rounded-sm border border-red-500 hover:border-red-400 transition">
                    신고
                  </button>
                }
                onSubmit={async (reason, imageFile) => {
                  try {
                    if (!user?.user) return;

                    await submitReport({
                      reason,
                      userId: user.user.userId,
                      jariId: item.userMapId,
                      reportImage: imageFile,
                    });
                    toast({
                      title: "🚨 신고 완료",
                      description: "신고가 정상적으로 접수되었습니다.",
                      variant: "success",
                    });
                  } catch (err) {
                    toast({
                      title: "❌ 신고 실패",
                      description:
                        err instanceof Error
                          ? err.message
                          : "알 수 없는 오류가 발생했습니다.",
                      variant: "destructive",
                    });
                  }
                }}
              />
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default TradeCard;
