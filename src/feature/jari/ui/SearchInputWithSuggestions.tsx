import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";
import { useSearchSuggestions } from "../hooks/useSearchSuggestions";

interface Props {
  placeholder?: string;
  className?: string;
  onSelect?: (val: string) => void;
}

export const SearchInputWithSuggestions = ({
  placeholder = "검색어를 입력하세요...",
  onSelect,
  className = "",
}: Props) => {
  const { keyword, setKeyword, suggestions, setSuggestions, wrapperRef } =
    useSearchSuggestions();

  const handleSelect = (val: string) => {
    setKeyword(val);
    onSelect?.(val);
    setKeyword(""); // 2. 그 후 초기화
    setSuggestions([]);
  };

  return (
    <div ref={wrapperRef} className={`relative w-full ${className}`}>
      <Input
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        placeholder={placeholder}
        className="h-12 pr-10"
      />
      <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
        <Search className="w-5 h-5 text-muted-foreground cursor-pointer" />
      </div>

      {suggestions.length > 0 && (
        <ul className="absolute mt-1 left-0 w-full bg-neutral-800 border text-white rounded-md shadow z-20">
          {suggestions.map((item, idx) => (
            <li
              key={idx}
              className="px-4 py-2 text-sm hover:bg-neutral-700 cursor-pointer rounded-md text-left"
              onClick={() => handleSelect(item)}
            >
              {item}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};
