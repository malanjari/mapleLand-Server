const dummyLogs = [
  { user: "user123", map: "루디브리엄성:시계탑7층", time: "2025-07-16 22:01" },
  { user: "maplefan", map: "엘나스:빙하동굴", time: "2025-07-16 21:44" },
  { user: "메이플광", map: "빅토리아:슬리피우드", time: "2025-07-16 21:40" },
  // ... 더미 10개
];

export const ActivityLog = () => {
  return (
    <div>
      <h2 className="text-lg font-semibold text-white mb-4">
        🕓 최근 활동 로그
      </h2>
      <div className="bg-neutral-800 rounded-xl p-4 text-sm text-neutral-200">
        <ul className="space-y-2">
          {dummyLogs.map((log, i) => (
            <li key={i} className="border-b border-neutral-700 pb-2">
              <span className="font-medium text-white">{log.user}</span> 님이{" "}
              <span className="text-yellow-300">{log.map}</span> 자리를 등록함 (
              {log.time})
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};
