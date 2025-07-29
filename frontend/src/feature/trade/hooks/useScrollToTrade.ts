import { useEffect } from "react";

export const useScrollToTrade = (focusId: string | null) => {
  useEffect(() => {
    if (!focusId) return;

    const targetId = `trade-${focusId}`;

    const tryScroll = () => {
      const el = document.getElementById(targetId);
      if (el) {
        el.scrollIntoView({ behavior: "smooth", block: "center" });
        el.classList.add(
          "bg-pink-500/20",
          "transition-all",
          "duration-500",
          "rounded-sm",
          "opacity-100",
          "grayscale-0",
          "border-2",
          "border-pink-500"
        );

        // 2.5초 후에 테두리를 투명하게 만들어 부드럽게 사라지게 함
        setTimeout(() => {
          el.classList.remove("border-2", "border-pink-500");
          el.classList.add("border-transparent");
        }, 2500);

        // 3초 후에 모든 클래스 제거
        setTimeout(() => {
          el.classList.remove(
            "bg-pink-500/20",
            "rounded-sm",
            "opacity-100",
            "grayscale-0",
            "border-transparent"
          );
          el.style.opacity = ""; // 인라인 스타일 제거
        }, 3000);
        return true;
      }
      return false;
    };

    if (tryScroll()) return;

    const observer = new MutationObserver(() => {
      if (tryScroll()) observer.disconnect();
    });

    observer.observe(document.body, { childList: true, subtree: true });

    return () => observer.disconnect();
  }, [focusId]);
};
