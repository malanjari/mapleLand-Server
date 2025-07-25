// shared/hooks/useSearchSuggestions.ts
import { useEffect, useRef, useState } from "react";
import { MapItem } from "@/entity/map/api/getAllMaps";
import { useAllMaps } from "@/entity/map/hooks/useAllMaps";
import { getInitials } from "@/shared/lib/getInitials";
import { isSubsequence } from "@/shared/lib/isSubsequence";

export const useSearchSuggestions = () => {
  const [keyword, setKeyword] = useState("");
  const [suggestions, setSuggestions] = useState<MapItem[]>([]);
  const wrapperRef = useRef<HTMLDivElement>(null);

  const { data: allMaps = [] } = useAllMaps();

  useEffect(() => {
    if (!keyword.trim()) {
      setSuggestions([]);
      return;
    }

    const delay = setTimeout(() => {
      const input = keyword.trim();
      const inputInitials = getInitials(input);

      const filtered = allMaps.filter((map) => {
        const name = map.mapName;
        const nameInitials = getInitials(name);

        return (
          name.includes(input) || isSubsequence(inputInitials, nameInitials)
        );
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
