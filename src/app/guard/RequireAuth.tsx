import { useEffect, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useUser, useAuthInitialized } from "@/entity/user/hooks/useUser";
import { toast } from "@/shared/hooks/use-toast";

export const RequireAuth = ({ children }: { children: React.ReactNode }) => {
  const user = useUser();
  const initialized = useAuthInitialized();
  const navigate = useNavigate();
  const hasRedirected = useRef(false);

  useEffect(() => {
    if (initialized && !user && !hasRedirected.current) {
      hasRedirected.current = true;

      toast({
        title: "로그인이 필요합니다.",
        description: "이 페이지에 접근하려면 로그인이 필요해요.",
        variant: "destructive",
        duration: 4000,
      });

      navigate("/", { replace: true });
    }
  }, [user, initialized, navigate]);

  if (!initialized) return null; // 초기화 안됐으면 아무것도 렌더링 안함
  if (!user) return null; // 초기화는 됐지만 유저가 없으면 리디렉션 (useEffect 내에서 처리)

  return <>{children}</>;
};
