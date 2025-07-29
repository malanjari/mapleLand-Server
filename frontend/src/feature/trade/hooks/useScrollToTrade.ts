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
          "ring",
          "ring-4",
          "ring-pink-500",
          "ring-offset-2",
          "ring-offset-neutral-800",
          "bg-pink-500/20",
          "scale-105",
          "transition",
          "duration-500",
          "rounded-sm",
          "opacity-100",
          "grayscale-0"
        );
        setTimeout(() => {
          el.classList.remove(
            "ring",
            "ring-4",
            "ring-pink-500",
            "ring-offset-2",
            "ring-offset-neutral-800",
            "bg-pink-500/20",
            "scale-105",
            "rounded-sm",
            "opacity-100",
            "grayscale-0"
          );
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
