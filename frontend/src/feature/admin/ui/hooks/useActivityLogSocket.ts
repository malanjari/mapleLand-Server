// feature/admin/hooks/useActivityLogSocket.ts
import { useEffect, useRef, useState } from "react";
import { Client } from "@stomp/stompjs";
import { API_BASE_URL } from "@/shared/constants/api";
import { ActivityLogItem } from "@/page/admin/Dashboard";

export const useActivityLogSocket = () => {
  const [activityLogs, setActivityLogs] = useState<ActivityLogItem[]>([]);
  const [socketConnected, setSocketConnected] = useState(false);
  const clientRef = useRef<Client | null>(null);

  useEffect(() => {
    const token = localStorage.getItem("accessToken");
    if (!token) return;

    const client = new Client({
      brokerURL: `wss://${new URL(API_BASE_URL).host}/ws`,
      connectHeaders: {
        Authorization: `Bearer ${token}`,
      },
      reconnectDelay: 5000,
      onConnect: () => {
        setSocketConnected(true);
        client.subscribe("/topic/jari", (message) => {
          try {
            const data: ActivityLogItem = JSON.parse(message.body);
            setActivityLogs((prev) => [data, ...prev.slice(0, 9)]);
          } catch (err) {
            console.error("메시지 파싱 오류:", err);
          }
        });
      },
      onDisconnect: () => setSocketConnected(false),
      onStompError: () => setSocketConnected(false),
    });

    client.activate();
    clientRef.current = client;

    return () => {
      client.deactivate();
    };
  }, []);

  return { activityLogs, socketConnected };
};
