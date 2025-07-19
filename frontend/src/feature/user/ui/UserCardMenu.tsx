import {
  DropdownMenu,
  DropdownMenuTrigger,
  DropdownMenuContent,
  DropdownMenuItem,
} from "@/shared/ui/dropdownMenu/DrodownMenu";

interface Props {
  isActive: boolean;
  refetch: () => void;
  onBlock: () => void;
  onUnban: () => void;
}

export const UserCardMenu = ({
  isActive,
  onBlock,
  onUnban,
  refetch,
}: Props) => {
  const handleClick = () => {
    if (isActive) {
      onBlock();
    } else {
      onUnban();
    }
  };

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <button
          className="absolute top-3 right-3 p-1 text-gray-400 transition"
          aria-label="옵션 메뉴"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 24 24"
            className="w-5 h-5"
          >
            <circle cx="12" cy="5" r="1.5" />
            <circle cx="12" cy="12" r="1.5" />
            <circle cx="12" cy="19" r="1.5" />
          </svg>
        </button>
      </DropdownMenuTrigger>

      <DropdownMenuContent className="bg-neutral-700 border-neutral-700 text-white shadow-lg rounded-md min-w-[160px]">
        <DropdownMenuItem
          onClick={() => {
            handleClick();
            refetch();
          }}
          className={`cursor-pointer text-sm py-2 hover:!bg-neutral-600 ${
            isActive ? "text-red-400" : "text-green-400"
          }`}
        >
          {isActive ? "🚫 사용자 차단" : "✅ 차단 해제"}
        </DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
};
