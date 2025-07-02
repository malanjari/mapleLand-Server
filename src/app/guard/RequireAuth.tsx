import { useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useUser } from "@/entity/user/hooks/useUser";
import { toast } from "@/shared/hooks/use-toast";

export const RequireAuth = ({ children }: { children: React.ReactNode }) => {
  const user = useUser();
  const navigate = useNavigate();
  const hasRedirected = useRef(false);

  useEffect(() => {
    if (!user) {
      hasRedirected.current = true;

      toast({
        title: "로그인이 필요합니다.",
        description: "이 페이지에 접근하려면 로그인이 필요해요.",
        variant: "destructive",
        duration: 4000,
      });
      navigate("/", { replace: true });
    }
  }, [user, navigate]);

  if (!user) return null;

  return <>{children}</>;
};
