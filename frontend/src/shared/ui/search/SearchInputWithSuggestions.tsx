import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";
import { useSearchSuggestions } from "./hooks/useSearchSuggestions";
import { useState, useEffect } from "react";

interface Props {
  placeholder?: string;
  className?: string;
  onSelect?: (val: string) => void;
}

export const SearchInputWithSuggestions = ({
  placeholder = "자리를 검색하세요",
  onSelect,
  className = "",
}: Props) => {
  const { keyword, setKeyword, suggestions, setSuggestions, wrapperRef } =
    useSearchSuggestions();

  const [focusedIndex, setFocusedIndex] = useState(-1);

  const handleSelect = (val: string) => {
    setKeyword(val);
    onSelect?.(val);
    setSuggestions([]);
    setKeyword("");
    setFocusedIndex(-1);
  };

  const handleKeyDown = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (suggestions.length === 0) return;

    if (e.key === "ArrowDown") {
      e.preventDefault();
      setFocusedIndex((prev) => (prev + 1) % suggestions.length);
    } else if (e.key === "ArrowUp") {
      e.preventDefault();
      setFocusedIndex((prev) =>
        prev <= 0 ? suggestions.length - 1 : prev - 1
      );
    } else if (e.key === "Enter" && focusedIndex >= 0) {
      e.preventDefault();
      handleSelect(suggestions[focusedIndex].mapName);
    }
  };

  // 키워드가 바뀌면 index 초기화
  useEffect(() => {
    setFocusedIndex(-1);
  }, [keyword]);

  return (
    <div ref={wrapperRef} className={`relative w-full ${className}`}>
      <Input
        value={keyword}
        onChange={(e) => setKeyword(e.target.value)}
        onKeyDown={handleKeyDown}
        placeholder={placeholder}
        className="h-12 pr-10"
      />
      <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
        <Search className="w-5 h-5 text-muted-foreground cursor-pointer" />
      </div>

      {suggestions.length > 0 && (
        <ul className="absolute mt-1 left-0 w-full bg-neutral-800 border text-white rounded-md shadow z-20 max-h-[300px] overflow-y-auto">
          {suggestions.map((map, idx) => (
            <li
              key={map.mapId ?? idx}
              className={`px-4 py-2 text-sm text-left flex items-center gap-2 cursor-pointer rounded-md ${
                idx === focusedIndex ? "bg-neutral-700" : "hover:bg-neutral-700"
              }`}
              onClick={() => handleSelect(map.mapName)}
            >
              <img
                src={map.miniMapImageLogoUrl}
                alt="미니맵"
                className="w-5 h-5 object-cover rounded-sm"
              />
              <span>{map.mapName}</span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};
