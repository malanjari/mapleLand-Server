import { useUser } from "@/entity/user/hooks/useUser";
import {
  HeaderDropdownMenu,
  HeaderLogo,
  HeaderProfileButton,
  HeaderTradeButton,
} from "./ui/index";
import { useProfileMenu } from "../hook/useProfileMenu";
import { useLocation } from "react-router-dom";
import { SearchInputWithSuggestions } from "@/feature/jari/ui/SearchInputWithSuggestions";
import { useNavigate } from "react-router-dom";
const Header = () => {
  const user = useUser();
  const { menuOpen, toggleMenu, closeMenu, dropdownRef, handleDiscordLogin } =
    useProfileMenu();
  const location = useLocation();
  const pathname = location.pathname;
  const hideSearchBar = /^\/jari\/register(\/.*)?$/.test(pathname);
  const navigate = useNavigate();

  return (
    <header className="sticky top-0 z-50 w-full bg-neutral-900 flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-6 lg:px-8 xl:px-12 border-neutral-800">
      <HeaderLogo />
      {!hideSearchBar && (
        <SearchInputWithSuggestions
          onSelect={(val) => {
            navigate(`/jari/${encodeURIComponent(val)}`); // ← 여기서 페이지 이동
          }}
          placeholder="자리를 검색해 보세요..."
          className=" flex-1 xmb:max-w-[500px] mx-2"
        />
      )}
      <div className="flex gap-1">
        {user && <HeaderTradeButton />}
        <div ref={dropdownRef} className="relative">
          <HeaderProfileButton
            onClick={user ? toggleMenu : handleDiscordLogin}
          />
          {user && (
            <HeaderDropdownMenu menuOpen={menuOpen} closeMenu={closeMenu} />
          )}
        </div>
      </div>
    </header>
  );
};

export default Header;
