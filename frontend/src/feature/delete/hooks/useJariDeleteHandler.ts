// feature/delete/hooks/useJariDeleteHandler.ts
import { deleteJari } from "@/feature/delete/api/deleteJari";
import { toast } from "@/shared/hooks/use-toast";
import { useNavigate } from "react-router-dom";

interface UseJariDeleteHandlerOptions {
  onSuccessNavigateTo?: string; // 성공 시 이동할 경로 (옵션)
}

export const useJariDeleteHandler = ({
  onSuccessNavigateTo,
}: UseJariDeleteHandlerOptions = {}) => {
  const navigate = useNavigate();

  const handleDelete = async (userMapId: number) => {
    const confirmDelete = window.confirm("정말 이 글을 삭제하시겠습니까?");
    if (!confirmDelete) return;

    try {
      await deleteJari(userMapId);
      toast({
        title: "✅ 삭제 완료",
        description: "게시글이 성공적으로 삭제되었습니다.",
        variant: "success",
      });

      if (onSuccessNavigateTo) {
        navigate(onSuccessNavigateTo);
      }
    } catch (error) {
      const errorMessage =
        error instanceof Error
          ? error.message
          : "알 수 없는 오류가 발생했습니다";
      toast({
        title: "❌ 삭제 실패",
        description: errorMessage,
        variant: "destructive",
      });
    }
  };

  return { handleDelete };
};
