// src/features/auth/ui/UserWelcomeBox.tsx
import { useUser } from "@/entity/user/hooks/useUser";
import { handleDiscordLogin } from "@/shared/utils/auth/discord";

export const UserWelcomeBox = () => {
  const user = useUser();

  return user ? (
    <div className="p-4 mb:p-8 rounded-lg bg-neutral-800 shadow text-sm text-white flex items-center gap-3">
      <img
        src={
          user.user.avatar
            ? `https://cdn.discordapp.com/avatars/${user.user.id}/${user.user.avatar}.png`
            : "https://cdn.discordapp.com/embed/avatars/0.png"
        }
        className="w-6 h-6 rounded-full"
        alt="user avatar"
      />
      <span>{user.user.globalName}님, 환영합니다 👋</span>
    </div>
  ) : (
    <div className="p-4 mb:p-8 rounded-lg bg-neutral-700 shadow text-sm text-white flex items-center gap-3">
      <img
        onClick={handleDiscordLogin}
        src="https://cdn.discordapp.com/embed/avatars/0.png"
        className="w-6 h-6 rounded-full cursor-pointer"
        alt="default avatar"
      />
      <span>디스코드 로그인을 통해 더 많은 기능을 이용해보세요!</span>
    </div>
  );
};
