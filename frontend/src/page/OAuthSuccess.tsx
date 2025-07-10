import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { useAuthStore } from "@/entity/user/store/useAuthStore";

const OAuthSuccessPage = () => {
  const [searchParams] = useSearchParams();
  const accessToken = searchParams.get("accessToken");

  const navigate = useNavigate();
  const setToken = useAuthStore((state) => state.setToken);

  useEffect(() => {
    if (accessToken) {
      setToken(accessToken);

      navigate("/");
    }
  }, [accessToken, navigate, setToken]);

  return <p>로그인 중입니다...</p>;
};

export default OAuthSuccessPage;
