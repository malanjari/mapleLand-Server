// shared/hooks/useSearchSuggestions.ts
import { useEffect, useRef, useState } from "react";
import { MapItem } from "@/entity/map/api/getAllMaps";
import { useAllMaps } from "@/entity/map/hooks/useAllMaps";

export const useSearchSuggestions = () => {
  const [keyword, setKeyword] = useState("");
  const [suggestions, setSuggestions] = useState<MapItem[]>([]);
  const wrapperRef = useRef<HTMLDivElement>(null);

  const { data: allMaps = [] } = useAllMaps();

  useEffect(() => {
    if (!keyword.trim()) {
      if (suggestions.length > 0) {
        setSuggestions([]);
      }
      return;
    }

    const delay = setTimeout(() => {
      const input = keyword.trim().toLowerCase();
      const inputChars = Array.from(input);

      const filtered = allMaps.filter((map) => {
        const name = map.mapName.toLowerCase();
        return inputChars.every((char) => name.includes(char));
      });

      setSuggestions(filtered);
    }, 100);

    return () => clearTimeout(delay);
  }, [keyword, allMaps]);

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
