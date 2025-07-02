// shared/hooks/useSearchSuggestions.ts
import { useEffect, useRef, useState } from "react";
import { fetchAutocomplete } from "@/feature/jari/api/autocomplete";

export const useSearchSuggestions = () => {
  const [keyword, setKeyword] = useState("");
  const [suggestions, setSuggestions] = useState<string[]>([]);
  const wrapperRef = useRef<HTMLDivElement>(null);

  // 자동완성 데이터 불러오기
  useEffect(() => {
    const controller = new AbortController();

    const fetchSuggestions = async () => {
      try {
        const data = await fetchAutocomplete(keyword, controller.signal);
        data.sort();
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

  // 외부 클릭 감지
  useEffect(() => {
    const handleClickOutside = (e: MouseEvent) => {
      if (
        wrapperRef.current &&
        !wrapperRef.current.contains(e.target as Node)
      ) {
        setKeyword("");
        setSuggestions([]);
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return {
    keyword,
    setKeyword,
    suggestions,
    setSuggestions,
    wrapperRef,
  };
};
