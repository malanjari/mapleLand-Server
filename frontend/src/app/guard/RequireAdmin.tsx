import { useUser, useAuthInitialized } from "@/entity/user/hooks/useUser";
import { Navigate, useLocation } from "react-router-dom";

export const RequireAdmin = ({ children }: { children: React.ReactNode }) => {
  const user = useUser(); // user or null
  const initialized = useAuthInitialized(); // ✅ 로그인 정보 초기화 완료 여부
  const location = useLocation();

  // 아직 초기화 중이면 아무것도 보여주지 않음 (또는 Spinner)
  if (!initialized) return null;

  if (!user) {
    return <Navigate to="/" state={{ from: location }} replace />;
  }

  if (user.user.role !== "ROLE_ADMIN") {
    return <Navigate to="/" replace />;
  }

  return <>{children}</>;
};
