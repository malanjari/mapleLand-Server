import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";

const OAuthSuccessPage = () => {
  const [searchParams] = useSearchParams();
  const token = searchParams.get("token");
  const navigate = useNavigate();

  useEffect(() => {
    if (token) {
      localStorage.setItem("accessToken", token); // or cookies
      navigate("/"); // 홈으로 이동
    }
  }, [token, navigate]);

  return <p>로그인 중입니다...</p>;
};

export default OAuthSuccessPage;
