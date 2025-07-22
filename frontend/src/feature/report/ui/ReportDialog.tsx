import {
  Dialog,
  DialogTrigger,
  DialogContent,
  DialogTitle,
  DialogHeader,
  DialogFooter,
} from "@/shared/ui/dialog/dialog";
import { Button } from "@/shared/ui/button/Button";
import { Textarea } from "@/shared/ui/textarea/Textarea";
import { predefinedReasons } from "../hooks/useReportDialog";
import clsx from "clsx";
import { useReportDialog } from "../hooks/useReportDialog";

interface Props {
  trigger: React.ReactNode;
  onSubmit: (reason: string, imageFile: File | null) => void;
}

export const ReportDialog = ({ trigger, onSubmit }: Props) => {
  const {
    open,
    setOpen,
    selected,
    setSelected,
    customReason,
    setCustomReason,

    imagePreview,
    fileInputRef,

    handleSubmit,
    handleImageChange,
    handleRemoveImage,
  } = useReportDialog(onSubmit);

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>{trigger}</DialogTrigger>
      <DialogContent className="bg-neutral-800 max-h-[90vh] overflow-y-auto text-white rounded-xl shadow-lg p-6 w-[400px]">
        <DialogHeader>
          <DialogTitle className="text-xl font-bold mb-2">
            🚨 신고하기
          </DialogTitle>
          <p className="text-sm text-gray-400">
            해당 자리를 신고하시겠습니까? 사유를 선택하거나 작성하고 필요시
            스크린샷을 첨부해주세요.
          </p>
        </DialogHeader>

        <div className="mt-4 space-y-3">
          {predefinedReasons.map((reason) => (
            <label
              key={reason}
              className={clsx(
                "flex items-start gap-3 p-3 border rounded-lg cursor-pointer transition hover:bg-neutral-700",
                selected === reason && "border-red-500 bg-neutral-700"
              )}
            >
              <input
                type="radio"
                value={reason}
                checked={selected === reason}
                onChange={() => setSelected(reason)}
                className="mt-1 accent-red-500"
              />
              <span className="text-sm">{reason}</span>
            </label>
          ))}

          {selected === "기타" && (
            <Textarea
              placeholder="신고 사유를 입력하세요..."
              value={customReason}
              onChange={(e) => setCustomReason(e.target.value)}
              className="mt-2"
            />
          )}

          {/* 이미지 업로드 */}
          <div className="flex flex-col gap-2 mt-4">
            <label className="text-sm font-medium">스크린샷 첨부 (선택)</label>
            {imagePreview ? (
              <div className="relative w-full">
                <img
                  src={imagePreview}
                  alt="첨부 이미지"
                  className="w-full rounded-lg border border-neutral-600"
                />
                <button
                  onClick={handleRemoveImage}
                  className="absolute top-1 right-1 bg-black/60 text-xs text-white px-2 py-1 rounded hover:bg-black/80"
                >
                  제거
                </button>
              </div>
            ) : (
              <input
                type="file"
                accept="image/*"
                onChange={handleImageChange}
                ref={fileInputRef}
                className="text-sm text-neutral-300 file:mr-4 file:px-2 file:py-1 file:rounded file:border-0 file:text-sm file:font-medium file:bg-neutral-600 hover:file:bg-neutral-500"
              />
            )}
          </div>
        </div>

        <DialogFooter className="mt-6">
          <Button
            variant="destructive"
            onClick={handleSubmit}
            disabled={!selected || (selected === "기타" && !customReason)}
            className="w-full"
          >
            신고하기
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
};
