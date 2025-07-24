import { Button } from "../../button/Button";
import mesoIcon from "@/shared/assets/icon/mesoIcon.webp";
import { Link } from "react-router-dom";

export const HeaderTradeButton = () => {
  return (
    <Button
      asChild
      size="sm"
      variant="register"
      className="flex items-center gap-2 p-3 w-sm rounded-md text-white font-semibold"
      title="자리 등록"
    >
      <Link to="/jari/register">
        {/* mb 미만: 아이콘만 */}
        <img
          src={mesoIcon}
          alt="자리 등록"
          className="w-5 h-5 block mb:hidden"
        />

        {/* mb 이상: 텍스트만 */}
        <span className="hidden mb:inline">자리 등록</span>
      </Link>
    </Button>
  );
};
