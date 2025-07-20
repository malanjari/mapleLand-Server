import { ReportDialog } from "@/feature/report/ui/ReportDialog";
import { submitReport } from "@/feature/report/ui/api/submitReport";
import { toast } from "@/shared/hooks/use-toast";
import { Me } from "@/entity/user/model/type";

interface ReportButtonProps {
  user: Me;
  jariId: number;
}

export const ReportButton = ({ user, jariId }: ReportButtonProps) => {
  const handleSubmitReport = async (reason: string, imageFile: File | null) => {
    try {
      await submitReport({
        reason,
        userId: user.userId,
        jariId,
        reportImage: imageFile,
      });

      toast({
        title: "🚨 신고 완료",
        description: "신고가 정상적으로 접수되었습니다.",
        variant: "success",
      });
    } catch (err) {
      toast({
        title: "❌ 신고 실패",
        description:
          err instanceof Error
            ? err.message
            : "알 수 없는 오류가 발생했습니다.",
        variant: "destructive",
      });
    }
  };

  return (
    <ReportDialog
      trigger={
        <button className="text-xs text-red-400 hover:text-red-300 px-2 py-0.5 rounded-sm border border-red-500 hover:border-red-400 transition">
          신고
        </button>
      }
      onSubmit={handleSubmitReport}
    />
  );
};
