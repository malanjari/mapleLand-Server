import { ActivityLogItem } from "@/page/admin/Dashboard";
import { format, parseISO } from "date-fns";
import { useNavigate } from "react-router-dom";
interface ActivityLogProps {
  logs?: ActivityLogItem[];
  isConnected?: boolean;
}

export const ActivityLog = ({
  logs = [],
  isConnected = false,
}: ActivityLogProps) => {
  const navigate = useNavigate();
  return (
    <div>
      <h2 className="text-lg font-semibold text-white mb-4">
        🕓 최근 활동 로그 {!isConnected && "(연결 끊김)"}
      </h2>
      <div className="bg-neutral-800 rounded-xl p-4 text-sm text-neutral-200">
        {logs.length === 0 ? (
          <p className="text-neutral-400">활동 로그가 없습니다.</p>
        ) : (
          <ul className="space-y-2">
            {logs.map((log, i) => (
              <li key={i} className="border-b border-neutral-700 pb-2">
                <span
                  onClick={() => navigate(`/profile/${log.userId}`)}
                  className="font-medium text-white cursor-pointer underline decoration-blue-400 transition"
                >
                  {log.globalName}
                </span>
                님이 <span className="text-yellow-300">{log.mapName}</span>{" "}
                자리를 등록함 (
                {format(parseISO(log.crateTime), "yyyy-MM-dd HH:mm")})
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
};
