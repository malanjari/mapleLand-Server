import { getUserInfo } from "@/entity/user/api/user";
import { User } from "@/entity/user/model/type";
import { RegionMap } from "@/feature/worldJari/api/worldJari";
import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { format } from "date-fns";
import { useUser } from "@/entity/user/hooks/useUser";
import { Button } from "@/shared/ui/button/Button";
import TradeSection from "@/feature/jari/ui/TradeSection";

const ProfilePage = () => {
  const [userInfo, setUserInfo] = useState<User | null>(null);
  const [registrations, setRegistrations] = useState<RegionMap[]>([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const { userId } = useParams();
  const navigate = useNavigate();
  const me = useUser();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const user = await getUserInfo(userId!);
        setUserInfo(user.userInfo);
        setRegistrations(user.mapRegistrations);
      } catch (error) {
        if (error instanceof Error) {
          setError(error.message); // ✅ 서버에서 내려준 message 사용
        } else {
          setError("알 수 없는 오류가 발생했습니다.");
        }
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [userId]);
  if (loading) return <p className="text-white">로딩 중...</p>;
  if (error) return <p className="text-red-500">{error}</p>;
  if (!userInfo) return null;
  const avatarUrl = userInfo.image
    ? `https://cdn.discordapp.com/avatars/${userInfo.discordId}/${userInfo.image}.png`
    : "https://cdn.discordapp.com/embed/avatars/0.png"; // 기본 아바타
  const formattedDate = format(new Date(userInfo.createTime), "yyyy.MM.dd");
  const isMyProfile = userInfo.discordId === me?.user.id; // 디스코드 아이디가 같을시
  const sellList = registrations.filter((item) => item.tradeType === "SELL");
  const buyList = registrations.filter((item) => item.tradeType === "BUY");
  console.log(registrations);
  return (
    <div className="grid grid-cols-1 lg:grid-cols-5 gap-4 h-full">
      <div className="col-span-6 lg:col-span-1 lg:sticky top-24 self-start h-full">
        <div className="w-full flex flex-col  gap-4">
          <div className="flex flex-col bg-neutral-800 w-full items-center gap-4  rounded-lg shadow p-6">
            {" "}
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
          <div className="flex flex-col bg-neutral-800 w-full items-center  rounded-lg shadow p-6">
            {isMyProfile && (
              <Button
                variant="register"
                onClick={() => navigate("/jari/register")}
                className="mt-4 w-full text-white font-semibold"
              >
                + 자리 등록하기
              </Button>
            )}
          </div>
        </div>
      </div>
      {/* 오른쪽: 자리 거래 */}
      <div className="col-span-4 gap-6">
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3 mt-16 lg:mt-0">
          <TradeSection title="📦 팝니다" color="red" jari={sellList} />
          <TradeSection title="🔍 삽니다" color="blue" jari={buyList} />
        </div>
      </div>
    </div>
  );
};

export default ProfilePage;
