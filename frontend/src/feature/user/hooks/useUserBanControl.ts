// useUserBanControl.ts
import { useState } from "react";
import { toast } from "@/shared/hooks/use-toast";
import { banUser } from "@/feature/ban/api/banUser";
import { unBanUser } from "@/feature/ban/api/unBanUser";

export const useUserBanControl = (userId: number, refetch: () => void) => {
  const [banDialogOpen, setBanDialogOpen] = useState(false);

  const handleUnban = async () => {
    try {
      await unBanUser(userId);
      toast({
        title: "✅ 차단 해제 완료",
        description: "해당 사용자의 차단이 해제되었습니다.",
        variant: "success",
      });
      refetch();
    } catch (error) {
      toast({
        title: "❌ 차단 해제 실패",
        description:
          error instanceof Error
            ? error.message
            : "알 수 없는 오류가 발생했습니다.",
        variant: "destructive",
      });
    }
  };

  const handleBan = async (reason: string, duration: number) => {
    try {
      await banUser(userId, reason, duration);
      toast({
        title: "✅ 차단 성공",
        description: `${
          duration === 999 ? "영구적으로" : `${duration}시간`
        } 차단되었습니다.`,
        variant: "success",
      });
      refetch();
    } catch (error) {
      toast({
        title: "❌ 차단 실패",
        description:
          error instanceof Error
            ? error.message
            : "알 수 없는 오류가 발생했습니다.",
        variant: "destructive",
      });
    } finally {
      setBanDialogOpen(false);
    }
  };

  return {
    banDialogOpen,
    setBanDialogOpen,
    handleBan,
    handleUnban,
  };
};
