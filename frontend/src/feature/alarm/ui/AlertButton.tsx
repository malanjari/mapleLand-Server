import { Button } from "@/shared/ui/button/Button";

interface AlarmButtonProps {
  isAlarmOn: boolean;
  onToggle: () => void;
  className?: string;
}

export const AlertButton = ({
  isAlarmOn,
  onToggle,
  className = "w-full",
}: AlarmButtonProps) => {
  return (
    <Button
      onClick={onToggle}
      variant={isAlarmOn ? "favoriteActive" : "favorite"}
      className={className}
    >
      {isAlarmOn ? "🔕 알림 끄기" : "🔔 알림 받기"}
    </Button>
  );
};
