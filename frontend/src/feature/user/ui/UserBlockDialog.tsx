// src/feature/user/ui/UserBlockDialog.tsx
import {
  Dialog,
  DialogContent,
  DialogTitle,
  DialogHeader,
  DialogFooter,
} from "@/shared/ui/dialog/dialog";
import { Button } from "@/shared/ui/button/Button";
import { Textarea } from "@/shared/ui/textarea/Textarea";
import { useState, useEffect } from "react";
import clsx from "clsx";

const blockDurations = [
  { label: "3시간", value: 3 },
  { label: "12시간", value: 12 },
  { label: "24시간", value: 24 },
  { label: "영구 차단", value: 999 },
];

interface Props {
  open: boolean;
  onClose: () => void;
  onConfirm: (reason: string, duration: number) => void;
}

export const UserBlockDialog = ({ open, onClose, onConfirm }: Props) => {
  const [selectedDuration, setSelectedDuration] = useState<number | null>(null);
  const [reason, setReason] = useState("");

  useEffect(() => {
    if (!open) {
      setSelectedDuration(null);
      setReason("");
    }
  }, [open]);

  const handleConfirm = () => {
    if (selectedDuration === null || reason.trim() === "") return;
    onConfirm(reason, selectedDuration);
  };

  return (
    <Dialog open={open} onOpenChange={onClose}>
      <DialogContent className="bg-neutral-800 text-white rounded-xl shadow-lg p-6 w-[400px]">
        <DialogHeader>
          <DialogTitle className="text-xl font-bold mb-2">
            🚫 사용자 차단
          </DialogTitle>
          <p className="text-sm text-gray-400">
            차단 시간을 선택하고 사유를 작성해주세요.
          </p>
        </DialogHeader>

        <div className="mt-4 space-y-3">
          <div className="space-y-2">
            {blockDurations.map(({ label, value }) => (
              <label
                key={value}
                className={clsx(
                  "flex items-start gap-3 p-3 border rounded-lg cursor-pointer transition hover:bg-neutral-700",
                  selectedDuration === value && "border-red-500 bg-neutral-700"
                )}
              >
                <input
                  type="radio"
                  value={value}
                  checked={selectedDuration === value}
                  onChange={() => setSelectedDuration(value)}
                  className="mt-1 accent-red-500"
                />
                <span className="text-sm">{label}</span>
              </label>
            ))}
          </div>

          <Textarea
            placeholder="차단 사유를 입력하세요..."
            value={reason}
            onChange={(e) => setReason(e.target.value)}
            className="mt-2"
          />
        </div>

        <DialogFooter className="mt-6">
          <Button
            variant="destructive"
            onClick={handleConfirm}
            disabled={selectedDuration === null || reason.trim() === ""}
            className="w-full"
          >
            차단하기
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
};
