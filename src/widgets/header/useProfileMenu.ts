import { useEffect, useRef, useState } from "react";
import { API_BASE_URL } from "@/shared/config/api";

export function useProfileMenu() {
  const [menuOpen, setMenuOpen] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);

  const closeMenu = () => setMenuOpen(false);
  const toggleMenu = () => setMenuOpen((prev) => !prev);

  const handleDiscordLogin = () => {
    window.location.href = `${API_BASE_URL}/oauth2/authorization/discord`;
  };

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (
        dropdownRef.current &&
        !dropdownRef.current.contains(event.target as Node)
      ) {
        closeMenu();
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return {
    menuOpen,
    toggleMenu,
    closeMenu,
    dropdownRef,
    handleDiscordLogin,
  };
}
