// src/page/OAuthBannedPage.tsx
import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { toast } from "@/shared/hooks/use-toast";

const OAuthBannedPage = () => {
  const navigate = useNavigate();
  const [params] = useSearchParams();

  const reason = params.get("reason");
  const message = params.get("message");

  useEffect(() => {
    const decodedMessage = decodeURIComponent(
      message || "사유가 등록되지 않았습니다."
    );

    toast({
      title: `⛔ 접근 제한: ${reason ?? "unknown"}`, // ✅ reason도 함께 표시
      description: decodedMessage,
      variant: "destructive",
    });

    navigate("/", { replace: true }); // 히스토리에 남기지 않고 홈으로
  }, [message, reason, navigate]);

  return null;
};

export default OAuthBannedPage;
