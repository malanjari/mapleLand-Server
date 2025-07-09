import { Button } from "../../button/Button";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDiscord } from "@fortawesome/free-brands-svg-icons";
import { useUser } from "@/entity/user/hooks/useUser";

export const HeaderProfileButton = ({ onClick }: { onClick: () => void }) => {
  const user = useUser();

  return (
    <Button
      onClick={onClick}
      size="sm"
      title="프로필"
      className="bg-[#5865F2] hover:bg-[#4752c4]"
    >
      {user ? (
        <>
          {user.user.avatar ? (
            <img
              src={`https://cdn.discordapp.com/avatars/${user.user.id}/${user.user.avatar}.png`}
              alt="avatar"
              className="w-5 h-5 rounded-full"
            />
          ) : (
            <FontAwesomeIcon icon={faDiscord} className="w-5 h-5" />
          )}
          <span className="text-xs hidden mb:block">
            {user.user.globalName}
          </span>
        </>
      ) : (
        <>
          <FontAwesomeIcon icon={faDiscord} className="w-5 h-5" />
          <span className="text-xs hidden mb:block">로그인</span>
        </>
      )}
    </Button>
  );
};
