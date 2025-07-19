import { useUser } from "@/entity/user/hooks/useUser";
import {
  HeaderDropdownMenu,
  HeaderLogo,
  HeaderProfileButton,
  HeaderTradeButton,
} from "./index";
import { useProfileMenu } from "@/feature/user/hooks/useProfileMenu";
import { useLocation } from "react-router-dom";
import { SearchInputWithSuggestions } from "@/shared/ui/search/SearchInputWithSuggestions";
import { useNavigate } from "react-router-dom";
import { useEffect, useMemo, useState } from "react";
import { Button } from "../../button/Button";
const Header = () => {
  const user = useUser();
  const { menuOpen, toggleMenu, closeMenu, dropdownRef, handleDiscordLogin } =
    useProfileMenu();
  const location = useLocation();
  const pathname = location.pathname;
  const hideSearchBar = useMemo(
    () => /^\/jari\/register(\/.*)?$/.test(pathname),
    [pathname]
  );
  const navigate = useNavigate();
  const [isSticky, setIsSticky] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      requestAnimationFrame(() => {
        setIsSticky(window.scrollY > 0);
      });
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <header
      className={`sticky top-0 z-50 w-full flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-12 lg:px-16  border-neutral-800 transition-all duration-300 ${
        isSticky
          ? " bg-opacity-60 backdrop-saturate-150 backdrop-blur-sm"
          : " bg-opacity-100"
      }`}
    >
      <HeaderLogo />
      {!hideSearchBar && (
        <SearchInputWithSuggestions
          onSelect={(val) => {
            navigate(`/jari/${encodeURIComponent(val)}`); // 페이지 이동
          }}
          placeholder="자리를 검색해 보세요..."
          className=" flex-1 xmb:max-w-[500px] mx-2"
        />
      )}
      <div className="flex gap-1">
        {user ? (
          <>
            {user.user.role === "ROLE_ADMIN" && (
              <Button onClick={() => navigate("/admin")} size="sm">
                어드민
              </Button>
            )}
            <HeaderTradeButton />
            <div ref={dropdownRef} className="relative">
              <HeaderProfileButton onClick={toggleMenu} />
              <HeaderDropdownMenu menuOpen={menuOpen} closeMenu={closeMenu} />
            </div>
          </>
        ) : (
          <div className="relative">
            <HeaderProfileButton onClick={handleDiscordLogin} />
          </div>
        )}
      </div>
    </header>
  );
};

export default Header;
