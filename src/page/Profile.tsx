import { useParams, useNavigate } from "react-router-dom";
import { format } from "date-fns";
import { useUser } from "@/entity/user/hooks/useUser";
import { Button } from "@/shared/ui/button/Button";
import TradeSection from "@/feature/jari/ui/TradeSection";
import { useUserInfo } from "@/entity/user/hooks/useUserInfo";
import { RegionMap } from "@/feature/worldJari/api/worldJari";

const ProfilePage = () => {
  const { userId } = useParams();
  const navigate = useNavigate();
  const me = useUser();

  const { data: user, isLoading, error, refetch } = useUserInfo(userId);

  if (isLoading) return <p className="text-white">로딩 중...</p>;
  if (error || !user)
    return <p className="text-red-500">유저 정보를 불러오지 못했습니다.</p>;

  const {
    userInfo,
    mapRegistrations,
  }: { userInfo: any; mapRegistrations: RegionMap[] } = user;

  const avatarUrl = userInfo.image
    ? `https://cdn.discordapp.com/avatars/${userInfo.discordId}/${userInfo.image}.png`
    : "https://cdn.discordapp.com/embed/avatars/0.png";

  const formattedDate = format(new Date(userInfo.createTime), "yyyy.MM.dd");
  const isMyProfile = userInfo.discordId === me?.user.id;

  const sellList = mapRegistrations.filter((item) => item.tradeType === "SELL");
  const buyList = mapRegistrations.filter((item) => item.tradeType === "BUY");
  const completedSellList = mapRegistrations.filter(
    (j) => j.tradeType === "SELL" && j.isCompleted
  );
  const completedBuyList = mapRegistrations.filter(
    (j) => j.tradeType === "BUY" && j.isCompleted
  );

  return (
    <div className="grid grid-cols-1 lg:grid-cols-5 gap-4 h-full">
      {/* 왼쪽: 프로필 정보 */}
      <div className="col-span-6 lg:col-span-1 lg:sticky top-24 self-start h-full">
        <div className="w-full flex flex-col gap-4">
          <div className="flex flex-col bg-neutral-800 w-full items-center gap-4 rounded-lg shadow p-6 px-4">
            <img
              src={avatarUrl}
              alt="프로필 이미지"
              className="w-32 h-32 rounded-full border-4 border-white shadow-md"
            />
            <div className="text-center space-y-1">
              <p className="text-xl font-semibold text-white">
                {userInfo.globalName}
              </p>
              <p className="text-sm text-gray-400">@{userInfo.userName}</p>
              <p className="text-xs text-gray-500">{formattedDate} 가입</p>
            </div>
          </div>

          <div className="flex flex-col bg-neutral-800 w-full items-center gap-2 rounded-lg shadow  p-6 px-4">
            {isMyProfile && (
              <Button
                variant="register"
                onClick={() => navigate("/jari/register")}
                className="mt-4 w-full text-white font-semibold"
              >
                + 자리 등록하기
              </Button>
            )}
            <Button
              variant="blue"
              onClick={() =>
                window.open(
                  `https://discord.com/users/${userInfo.discordId}`,
                  "_blank"
                )
              }
              className="w-full font-semibold"
            >
              디스코드 프로필 (Web)
            </Button>
            <Button
              variant="blue"
              onClick={() => {
                window.location.href = `discord://discord.com/users/${userInfo.discordId}`;
              }}
              className="w-full text-white font-semibold text-center"
            >
              디스코드 프로필 (PC)
            </Button>
          </div>
        </div>
      </div>

      {/* 오른쪽: 자리 거래 */}
      <div className="col-span-5 lg:col-span-4 gap-6">
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-16 lg:mt-0">
          <TradeSection
            title=" 팝니다"
            color="red"
            jari={sellList}
            refetch={refetch}
          />
          <TradeSection
            title="삽니다"
            color="blue"
            jari={buyList}
            refetch={refetch}
          />
        </div>
        {(completedSellList.length > 0 || completedBuyList.length > 0) && (
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-12">
            <TradeSection
              title="팝니다 (종료)"
              color="red"
              jari={completedSellList}
              refetch={refetch}
            />
            <TradeSection
              title="삽니다 (종료)"
              color="blue"
              jari={completedBuyList}
              refetch={refetch}
            />
          </div>
        )}
      </div>
    </div>
  );
};

export default ProfilePage;
