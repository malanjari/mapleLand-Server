import { useState, useEffect } from "react";
import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";
import { API_BASE_URL } from "@/shared/config/api";
import { useRef } from "react";

const JariRegisterPage = () => {
  const [keyword, setKeyword] = useState("");
  const [suggestions, setSuggestions] = useState<string[]>([]);
  const wrapperRef = useRef<HTMLDivElement>(null);
  useEffect(() => {
    const controller = new AbortController();
    const token = localStorage.getItem("accessToken");

    const fetchSuggestions = async () => {
      const trimmed = keyword.trim();
      if (!trimmed) {
        setSuggestions([]);
        return;
      }

      try {
        const res = await fetch(
          `${API_BASE_URL}/api/map/autocomplete?keyword=${encodeURIComponent(
            trimmed
          )}`,
          {
            method: "GET",
            headers: {
              Authorization: `Bearer ${token}`,
              "ngrok-skip-browser-warning": "true",
            },
            signal: controller.signal,
          }
        );

        if (!res.ok) throw new Error("자동완성 요청 실패");

        const data = await res.json();
        setSuggestions(data);
      } catch (err: unknown) {
        if (err instanceof Error && err.name !== "AbortError") {
          console.error("자동완성 에러:", err);
          setSuggestions([]);
        }
      }
    };

    const delay = setTimeout(() => {
      fetchSuggestions();
    }, 100); // 100ms 디바운싱

    return () => {
      clearTimeout(delay);
      controller.abort(); // 이전 요청 취소
    };
  }, [keyword]);

  // 바깥 클릭 시 초기화
  useEffect(() => {
    const handleClickOutside = (e: MouseEvent) => {
      if (
        wrapperRef.current &&
        !wrapperRef.current.contains(e.target as Node)
      ) {
        setKeyword(""); // ✅ 입력 초기화
        setSuggestions([]); // ✅ 추천 초기화
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <section className="flex flex-col items-center h-full p-20 px-4">
      <div className="w-full text-center space-y-6">
        <h1 className="text-xl mb:text-3xl font-bold">
          자리 등록 페이지입니다.
        </h1>
        <p className="text-muted-foreground text-sm sm:text-base">
          원하는 사냥터를 검색해주세요.
        </p>

        <div ref={wrapperRef} className="max-w-lg w-full mx-auto relative">
          <Input
            value={keyword}
            onChange={(e) => setKeyword(e.target.value)}
            placeholder="예: 구름공원, 죽은나무숲2, 망가진 용의 둥지..."
            className="h-12 pr-10"
          />
          <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
            <Search className="w-5 h-5 text-muted-foreground cursor-pointer" />
          </div>

          {suggestions.length > 0 && (
            <ul className="absolute mt-1 left-0 w-full bg-neutral-800 border text-white  rounded-md shadow z-20">
              {suggestions.map((item, idx) => (
                <li
                  key={idx}
                  className="px-4 py-2 text-sm hover:bg-neutral-700 cursor-pointer rounded-md text-left"
                  onClick={() => setKeyword(item)}
                >
                  {item}
                </li>
              ))}
            </ul>
          )}
        </div>
      </div>
    </section>
  );
};

export default JariRegisterPage;
