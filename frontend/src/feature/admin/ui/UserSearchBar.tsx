import { Button } from "@/shared/ui/button/Button";

interface UserSearchBarProps {
  search: string;
  onChange: (value: string) => void;
  onSearch: () => void;
  onClear: () => void;
}

export const UserSearchBar = ({
  search,
  onChange,
  onSearch,
  onClear,
}: UserSearchBarProps) => {
  return (
    <div className="flex items-center gap-2 mb-4">
      <input
        type="text"
        placeholder="GlobalName으로 검색"
        value={search}
        onChange={(e) => onChange(e.target.value)}
        onKeyDown={(e) => e.key === "Enter" && onSearch()}
        className="px-2 py-1 border rounded text-black"
      />
      <Button
        onClick={onSearch}
        className="bg-blue-500 hover:bg-blue-600 text-white px-2 py-1 text-xs"
      >
        검색
      </Button>
      {search && (
        <Button
          onClick={onClear}
          className="bg-gray-400 hover:bg-gray-500 text-white px-2 py-1 text-xs"
        >
          초기화
        </Button>
      )}
    </div>
  );
};
