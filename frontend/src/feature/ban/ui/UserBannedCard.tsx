import { BannedUserInfo } from "@/entity/user/model/type";
import { Button } from "@/shared/ui/button/Button";
import { useNavigate } from "react-router-dom";
import { format } from "date-fns";
import { ko } from "date-fns/locale";

interface Props {
  user: BannedUserInfo;
}

const BannedUserCard = ({ user }: Props) => {
  const navigate = useNavigate();

  return (
    <li className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-red-500 transition">
      <p className="text-lg font-semibold mb-1">{user.globalName}</p>
      <p className="text-sm text-neutral-400">{user.userName}</p>
      <p className="text-sm text-neutral-400">ID: {user.userId}</p>
      <p className="text-sm text-neutral-400">Discord: {user.discordId}</p>
      <p className="text-sm text-neutral-400">
        역할: {user.role.replace("ROLE_", "")}
      </p>
      <p className="text-sm text-neutral-400">
        신고당한 횟수: {user.reportedCount}
      </p>

      {/* 🔴 밴 정보 */}
      <hr className="my-2 border-neutral-600" />
      <p className="text-sm text-red-400 font-semibold">
        밴 사유: {user.banedReason}
      </p>
      <p className="text-sm text-red-300">
        밴 만료일:{" "}
        {format(
          new Date(
            new Date(user.bannedHours).getTime() +
              (8 * 60 * 60 + 59 * 60 + 50) * 1000
          ),
          "yyyy.MM.dd a h:mm",
          { locale: ko }
        )}
      </p>

      {/* ✅ 가입일 맨 아래 */}
      <p className="text-sm text-neutral-500 mt-3">
        가입일:{" "}
        {format(
          new Date(
            new Date(user.createTime).getTime() +
              (8 * 60 * 60 + 59 * 60 + 50) * 1000
          ),
          "yyyy.MM.dd a h:mm",
          { locale: ko }
        )}
      </p>

      <div className="flex justify-end mt-2">
        <Button
          onClick={() => navigate(`/profile/${user.userId}`)}
          className="px-2 py-1 h-6 text-xs bg-blue-500 hover:bg-blue-600 rounded text-white"
        >
          프로필 보기
        </Button>
      </div>
    </li>
  );
};

export default BannedUserCard;
