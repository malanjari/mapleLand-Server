// shared/ui/SearchInputWithSuggestions.tsx
import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";
import { useRef, useEffect, useState } from "react";

import { fetchAutocomplete } from "@/feature/jari/api/autocomplete";

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
  const [keyword, setKeyword] = useState("");
  const [suggestions, setSuggestions] = useState<string[]>([]);

  useEffect(() => {
    const controller = new AbortController();

    const fetchSuggestions = async () => {
      try {
        const data = await fetchAutocomplete(keyword, controller.signal);
        setSuggestions(data);
      } catch (err: unknown) {
        if (err instanceof Error && err.name !== "AbortError") {
          console.error("자동완성 에러:", err);
          setSuggestions([]);
        }
      }
    };

    const delay = setTimeout(fetchSuggestions, 100);
    return () => {
      clearTimeout(delay);
      controller.abort();
    };
  }, [keyword]);

  const handleSelect = (val: string) => {
    setKeyword(val); // 선택된 항목을 인풋에 반영
    onSelect?.(val); // 페이지 이동
  };
  const wrapperRef = useRef<HTMLDivElement>(null);

  useEffect(() => {
    const handleClickOutside = (e: MouseEvent) => {
      if (
        wrapperRef.current &&
        !wrapperRef.current.contains(e.target as Node)
      ) {
        setKeyword(""); // 외부 클릭 시 입력값 초기화
        setSuggestions([]);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, [setKeyword, setSuggestions]);

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
