import { Button } from "../../../shared/ui/button/Button";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import { useNavigate } from "react-router-dom";

export const HeaderTradeButton = () => {
  const navigate = useNavigate();

  return (
    <Button
      size="sm"
      variant="register"
      className="flex items-center gap-2 p-1 w-sm  rounded-md text-white font-semibold "
      title="자리 등록"
      onClick={() => navigate("/jari/register")}
    >
      자리 등록
    </Button>
  );
};
