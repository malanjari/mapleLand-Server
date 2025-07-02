import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "@/entity/user/hooks/useUser";

export const RequireAuth = ({ children }: { children: React.ReactNode }) => {
  const user = useUser();
  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
      alert("로그인이 필요합니다.");
      navigate("/", { replace: true });
    }
  }, [user, navigate]);

  // user가 없으면 아직 redirect 중이라 아무것도 안 보여줌
  if (!user) return null;

  return <>{children}</>;
};
