import { Button } from "../../../shared/ui/button/Button";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import { useNavigate } from "react-router-dom";

export const HeaderTradeButton = () => {
  const navigate = useNavigate();

  return (
    <Button
      size="sm"
      variant="secondary"
      title="자리 등록"
      className="flex items-center"
      onClick={() => navigate("/jari/register")}
    >
      <img src={mesoIcon} className="w-5 h-5" />
    </Button>
  );
};
