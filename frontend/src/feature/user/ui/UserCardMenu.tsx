import {
  DropdownMenu,
  DropdownMenuTrigger,
  DropdownMenuContent,
  DropdownMenuItem,
} from "@/shared/ui/dropdownMenu/DrodownMenu";

interface Props {
  onBlock: () => void;
}

export const UserCardMenu = ({ onBlock }: Props) => {
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
          onClick={onBlock}
          className="text-red-400 hover:!bg-neutral-600  cursor-pointer text-sm  py-2"
        >
          🚫 사용자 차단
        </DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
};
