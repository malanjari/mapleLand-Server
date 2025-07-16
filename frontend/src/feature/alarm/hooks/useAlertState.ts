// src/feature/alarm/hooks/useAlarmStatus.ts
import { useAuthActions, useUser } from "@/entity/user/hooks/useUser";
import { updateAlertInterest } from "@/feature/alarm/api/updateAlertInterest";
import { toast } from "@/shared/hooks/use-toast";
import { useCallback } from "react";

export const useAlertStatus = (mapId?: number, mapName?: string) => {
  const auth = useUser();
  const userId = auth?.user?.userId;
  const alertDtoList = auth?.alertDtoList ?? [];
  const { initialize } = useAuthActions();

  const isAlarmOn = !!alertDtoList.some(
    (item) => item.mapId === mapId && item.alertStatus === "ALERT_ON"
  );

  const toggleAlarm = useCallback(async () => {
    if (!userId || !mapId) return;

    const nextStatus = isAlarmOn ? "ALERT_OFF" : "ALERT_ON";

    try {
      await updateAlertInterest({ userId, mapId, alertStatus: nextStatus });
      await initialize(); // 최신화
      toast({
        title: isAlarmOn
          ? `${mapName ?? "이 자리"} 알림 해제 완료`
          : `${mapName ?? "이 자리"} 알림 등록 완료`,
        variant: "success",
        description: isAlarmOn
          ? `${mapName ?? "이 자리"}에 대한 알림이 꺼졌습니다.`
          : `${mapName ?? "이 자리"}에 대한 알림이 등록되었습니다.`,
      });
    } catch (err) {
      toast({
        title: "알림 설정 실패",
        variant: "destructive",
        description:
          err instanceof Error
            ? err.message
            : "알 수 없는 오류가 발생했습니다.",
      });
    }
  }, [userId, mapId, isAlarmOn, initialize, mapName]);

  return { isAlarmOn, toggleAlarm };
};
