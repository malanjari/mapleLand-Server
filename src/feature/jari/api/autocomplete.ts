// src/shared/api/map/autocomplete.ts
import { API_BASE_URL } from "@/shared/config/api";

export const fetchAutocomplete = async (
  keyword: string,
  signal?: AbortSignal
): Promise<string[]> => {
  const trimmed = keyword.trim();
  if (!trimmed) return [];

  const res = await fetch(
    `${API_BASE_URL}/api/map/autocomplete?keyword=${encodeURIComponent(
      trimmed
    )}`,
    {
      method: "GET",
      headers: {
        "ngrok-skip-browser-warning": "true",
      },
      signal,
    }
  );

  if (!res.ok) throw new Error("자동완성 요청 실패");

  return res.json();
};
