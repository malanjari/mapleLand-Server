import { AdminUsersInfo } from "@/entity/user/model/type";
import { useNavigate } from "react-router-dom";
import { Button } from "@/shared/ui/button/Button";
import { convertToKoreaTime } from "@/shared/utils/date";

interface UserCardProps {
  user: AdminUsersInfo;
}

export const UserCard = ({ user }: UserCardProps) => {
  const navigate = useNavigate();
  const koreaTime = convertToKoreaTime(user.createTime);

  return (
    <li className="bg-neutral-800 text-white rounded-lg p-4 shadow hover:ring-2 hover:ring-blue-400 transition">
      <p className="text-lg font-semibold mb-1">{user.globalName}</p>
      <p className="text-sm text-neutral-400">{user.userName}</p>
      <p className="text-sm text-neutral-400">ID: {user.userId}</p>
      <p className="text-sm text-neutral-400">Discord: {user.discordId}</p>
      <p className="text-sm text-neutral-400">
        역할: {user.role?.replace("ROLE_", "")}
      </p>
      <p className="text-sm text-neutral-400">
        신고당한 횟수: {user.reportedCount}
      </p>
      <p className="text-sm text-neutral-500 mt-1">
        가입일: {koreaTime.toLocaleString("ko-KR")}
      </p>
      <div className="flex justify-end">
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
