import { useParams } from "react-router-dom";

import { useUser } from "@/entity/user/hooks/useUser";

import { useUserInfo } from "@/entity/user/hooks/useUserInfo";
import { Spinner } from "@/shared/ui/spinner/Spinner";
import { lazy, Suspense } from "react";
import { UserProfileCard } from "@/feature/user/ui/UserProfileCard";
import { useAllMaps } from "@/entity/map/hooks/useAllMaps";

import { AlertMapSection } from "@/feature/alert/ui/AlertMapSection";
const TradeSection = lazy(() => import("@/feature/trade/ui/TradeSection"));
const ProfilePage = () => {
  const { userId } = useParams();

  const me = useUser();

  const { data: allMaps } = useAllMaps();
  const alertMaps =
    allMaps?.filter((map) =>
      me?.alertDtoList?.some((alert) => alert.mapId === map.mapId)
    ) ?? [];

  const { data: user, isLoading, error, refetch } = useUserInfo(userId);

  if (isLoading) return <Spinner />;
  if (error || !user)
    return <p className="text-red-500">유저 정보를 불러오지 못했습니다.</p>;

  const { userInfo, mapRegistrations } = user;

  const isMyProfile = userInfo.discordId === me?.user.id;

  // 거래 상태에 따라 리스트 분리
  const sellList = mapRegistrations.filter(
    (item) => item.tradeType === "SELL" && !item.isCompleted
  );
  const buyList = mapRegistrations.filter(
    (item) => item.tradeType === "BUY" && !item.isCompleted
  );
  const completedSellList = mapRegistrations.filter(
    (item) => item.tradeType === "SELL" && item.isCompleted
  );
  const completedBuyList = mapRegistrations.filter(
    (item) => item.tradeType === "BUY" && item.isCompleted
  );

  return (
    <div className="grid grid-cols-1 lg:grid-cols-8 gap-4 h-full">
      {/* 왼쪽: 프로필 정보 */}
      <div className="col-span-8 lg:col-span-2 lg:sticky top-24 self-start">
        <UserProfileCard
          userInfo={userInfo}
          isMyProfile={isMyProfile}
          refetch={refetch}
        />
      </div>
      <div className="col-span-8 lg:col-span-6">
        {isMyProfile && (
          <AlertMapSection isMyProfile={isMyProfile} alertMaps={alertMaps} />
        )}{" "}
        {/* 오른쪽: 자리 거래 */}
        <Suspense>
          <div className="grid grid-cols-1 md:grid-cols-2 gap-10 sm:gap-3 mt-16 lg:mt-0 lg:mb-5">
            <TradeSection
              title="팝니다"
              color="red"
              jari={sellList}
              refetch={refetch}
              showEditButton={true}
            />
            <TradeSection
              title="삽니다"
              color="blue"
              jari={buyList}
              refetch={refetch}
              showEditButton={true}
            />
          </div>

          {(completedSellList.length > 0 || completedBuyList.length > 0) && (
            <div className="grid grid-cols-1 md:grid-cols-2 gap-10 sm:gap-3 mt-16 lg:mt-0 lg:mb-5">
              <TradeSection
                title="팝니다 (종료)"
                color="red"
                jari={completedSellList}
                showEditButton={false}
                refetch={refetch}
              />
              <TradeSection
                title="삽니다 (종료)"
                color="blue"
                jari={completedBuyList}
                showEditButton={false}
                refetch={refetch}
              />
            </div>
          )}
        </Suspense>
      </div>
    </div>
  );
};

export default ProfilePage;
