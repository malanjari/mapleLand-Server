import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { useAuthStore } from "@/lib/store/useAuthStore";
const OAuthSuccessPage = () => {
  const [searchParams] = useSearchParams();
  const token = searchParams.get("token");
  const navigate = useNavigate();
  const setToken = useAuthStore((state) => state.setToken);

  useEffect(() => {
    if (token) {
      setToken(token); // or cookies
      navigate("/"); // 홈으로 이동
      console.log("hi");
    }
  }, [token, navigate, setToken]);

  return <p>로그인 중입니다...</p>;
};

export default OAuthSuccessPage;
