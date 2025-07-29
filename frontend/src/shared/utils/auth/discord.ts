import { API_BASE_URL } from "@/shared/constants/api";

export const handleDiscordLogin = () => {
  window.location.href = `${API_BASE_URL}/oauth2/authorization/discord`;
};
