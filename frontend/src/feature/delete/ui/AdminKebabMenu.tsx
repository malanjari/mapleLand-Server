import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuTrigger,
} from "@/shared/ui/dropdownMenu/DrodownMenu";
import { MoreVertical } from "lucide-react";
import { jariDelete } from "@/entity/jari/api/jariDelete";
import { toast } from "@/shared/hooks/use-toast";

interface AdminKebabProps {
  isAdmin: boolean;
  mapId: number;
  onDeleted?: () => void;
}

const AdminKebabMenu = ({ isAdmin, mapId, onDeleted }: AdminKebabProps) => {
  const handleDelete = async () => {
    const confirmed = window.confirm("정말 삭제하시겠습니까?");
    if (!confirmed) return;

    try {
      await jariDelete(mapId);
      toast({
        title: "삭제 완료",
        variant: "success",
        description: "자리 정보가 삭제되었습니다.",
      });
      onDeleted?.();
    } catch (error) {
      toast({
        title: "삭제 실패",
        variant: "destructive",
        description:
          error instanceof Error ? error.message : "잠시 후 다시 시도해주세요.",
      });
    }
  };

  if (!isAdmin) return null;

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <button className="absolute -right-4  cursor-pointer">
          <MoreVertical className="w-5 h-5 text-gray-500 hover:text-black" />
        </button>
      </DropdownMenuTrigger>
      <DropdownMenuContent className="w-32 bg-gray-500">
        <DropdownMenuItem
          onClick={handleDelete}
          className="text-red-500 cursor-pointer"
        >
          삭제
        </DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
};

export default AdminKebabMenu;
