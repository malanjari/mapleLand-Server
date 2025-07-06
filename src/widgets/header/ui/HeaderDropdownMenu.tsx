import { Link } from "react-router-dom";
import { Button } from "../../../shared/ui/button/Button";
import { useAuthActions, useUser } from "@/entity/user/hooks/useUser";

export const HeaderDropdownMenu = ({
  menuOpen,
  closeMenu,
}: {
  menuOpen: boolean;
  closeMenu: () => void;
}) => {
  const { logout } = useAuthActions();
  const user = useUser();
  const userId = user?.user.userId;
  return (
    <div
      className={`absolute -right-5 mt-2 w-24 z-50 transition-all duration-200 origin-top
        ${
          menuOpen
            ? "opacity-100 scale-100 translate-y-0 pointer-events-auto"
            : "opacity-0 scale-95 -translate-y-2 pointer-events-none"
        }`}
    >
      <Link to={`/profile/${userId}`}>
        <Button className="w-full px-4 py-2 text-xs rounded-none justify-start">
          프로필
        </Button>
      </Link>
      <Button
        onClick={() => {
          logout();
          closeMenu();
        }}
        className="w-full text-left px-4 py-2 text-xs rounded-none justify-start"
      >
        로그아웃
      </Button>
    </div>
  );
};
