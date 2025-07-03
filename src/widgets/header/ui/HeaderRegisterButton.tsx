import { Button } from "../../../shared/ui/button/Button";
import mesoIcon from "@/shared/assets/icon/mesoIcon.png";
import { useNavigate } from "react-router-dom";

export const HeaderTradeButton = () => {
  const navigate = useNavigate();

  return (
    <Button
      size="sm"
      variant="secondary"
      className="flex items-center gap-2 px-2 py-2 rounded-md bg-gradient-to-r from-green-600 to-emerald-700 text-white font-semibold hover:brightness-110 transition"
      title="자리 등록"
      onClick={() => navigate("/jari/register")}
    >
      자리 등록
    </Button>
  );
};
