import logo from "@/shared/assets/logo/logo.png";
import { Link } from "react-router-dom";
import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDiscord } from "@fortawesome/free-brands-svg-icons";
import { Button } from "../button/Button";
import { useAuthActions, useUser } from "@/lib/hooks/useUser";
import { useState } from "react";
const Header = () => {
  const handleDiscordLogin = () => {
    window.location.href =
      "https://5f4f-175-119-53-38.ngrok-free.app/oauth2/authorization/discord";
  };
  const [menuOpen, setMenuOpen] = useState(false);
  const user = useUser();
  const { logout } = useAuthActions();

  return (
    <header className="sticky top-0 z-50 w-full bg-neutral-900 flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-6 lg:px-8 xl:px-12 border-neutral-800  ">
      <div>
        <Link className="flex gap-2 items-center" to="/">
          <img src={logo} alt="Logo" className="h-10 w-10" />
          <p className="font-bold hidden mb:block ">메렌자리.kr</p>
        </Link>
      </div>
      <div className="w-1/2 max-w-[500px] relative">
        <Input placeholder="자리를 검색해 보세요..." className="pr-8"></Input>

        <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
          <Search className="w-4 h-4 text-muted-foreground cursor-pointer" />
        </div>
      </div>
      <div className="relative">
        {" "}
        <Button
          onClick={() => {
            if (user) setMenuOpen((prev) => !prev);
            else handleDiscordLogin();
          }}
          size="sm"
          className="bg-[#5865F2] hover:bg-[#4752c4]"
        >
          <FontAwesomeIcon icon={faDiscord} className="w-5 h-5" />
          {user ? (
            <span className="text-xs hidden mb:block">{user.globalName}</span>
          ) : (
            <span className="text-xs hidden mb:block">로그인</span>
          )}
        </Button>
        {user && (
          <div
            className={`absolute -right-5 mt-2 w-24 z-50 transition-all duration-200 origin-top
      ${
        menuOpen
          ? "opacity-100 scale-100 translate-y-0 pointer-events-auto"
          : "opacity-0 scale-95 -translate-y-2 pointer-events-none"
      }
    `}
          >
            <Button className="w-full px-4 py-2 text-xs rounded-none justify-start">
              프로필
            </Button>
            <Button
              onClick={() => {
                // 로그아웃 핸들러 실행
                logout();
                setMenuOpen(false);
              }}
              className="w-full text-left px-4 py-2 text-xs rounded-none justify-start "
            >
              로그아웃
            </Button>
          </div>
        )}
      </div>
    </header>
  );
};

export default Header;
