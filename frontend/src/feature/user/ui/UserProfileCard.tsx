import { format } from "date-fns";
import { Button } from "@/shared/ui/button/Button";
import { User } from "@/entity/user/model/type";
import { useNavigate } from "react-router-dom";
import { useUser } from "@/entity/user/hooks/useUser";
import { UserCardMenu } from "./UserCardMenu";
import { useState } from "react";
import { UserBlockDialog } from "./UserBlockDialog";

interface Props {
  userInfo: User;
  isMyProfile: boolean;
}

export const UserProfileCard = ({ userInfo, isMyProfile }: Props) => {
  const [blockDialogOpen, setBlockDialogOpen] = useState(false);
  const navigate = useNavigate();
  const avatarUrl = userInfo.image
    ? `https://cdn.discordapp.com/avatars/${userInfo.discordId}/${userInfo.image}.png`
    : "https://cdn.discordapp.com/embed/avatars/0.png";

  const formattedDate = format(new Date(userInfo.createTime), "yyyy.MM.dd");
  const auth = useUser();
  const user = auth?.user;

  return (
    <div className="w-full flex flex-col gap-4">
      {/* 프로필 카드 */}
      <div className="relative flex flex-col bg-neutral-800 w-full items-center gap-4 rounded-lg shadow p-6 px-4">
        {user?.role === "ROLE_ADMIN" && (
          <UserCardMenu onBlock={() => setBlockDialogOpen(true)} />
        )}
        <UserBlockDialog
          open={blockDialogOpen}
          onClose={() => setBlockDialogOpen(false)}
          onConfirm={() => {
            console.log("✅ 실제 차단 처리 로직 실행");
            setBlockDialogOpen(false);
          }}
        />

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

      {/* 버튼 영역 */}
      <div className="flex flex-col bg-neutral-800 w-full items-center gap-2 rounded-lg shadow p-6 px-4">
        {isMyProfile && (
          <Button
            variant="register"
            onClick={() => navigate("/jari/register")}
            className="mt-4 w-full text-white font-semibold text-xs"
          >
            + 자리 등록하기
          </Button>
        )}
        <Button
          variant="discord"
          onClick={() =>
            window.open(
              `https://discord.com/users/${userInfo.discordId}`,
              "_blank"
            )
          }
          className="w-full font-semibold text-xs"
        >
          디스코드 프로필 (Web)
        </Button>
        <Button
          variant="discord"
          onClick={() => {
            window.location.href = `discord://discord.com/users/${userInfo.discordId}`;
          }}
          className="w-full text-white font-semibold text-center text-xs"
        >
          디스코드 프로필 (PC)
        </Button>
      </div>
    </div>
  );
};
