import { useUser } from "@/entity/user/hooks/useUser";
import {
  HeaderDropdownMenu,
  HeaderLogo,
  HeaderProfileButton,
  HeaderSearchBar,
  HeaderTradeButton,
  useProfileMenu,
} from "./index";

const Header = () => {
  const user = useUser();
  const { menuOpen, toggleMenu, closeMenu, dropdownRef, handleDiscordLogin } =
    useProfileMenu();

  return (
    <header className="sticky top-0 z-50 w-full bg-neutral-900 flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-6 lg:px-8 xl:px-12 border-neutral-800">
      <HeaderLogo />
      <HeaderSearchBar />
      <div className="flex gap-3">
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
