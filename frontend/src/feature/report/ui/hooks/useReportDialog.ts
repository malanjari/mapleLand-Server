import { toast } from "@/shared/hooks/use-toast";
import { useRef, useState } from "react";

export const predefinedReasons = [
  "잘못된 정보",
  "연락받지않음",
  "시세조작",
  "기타",
];

export const useReportDialog = (
  onSubmit: (reason: string, image: File | null) => void
) => {
  const [open, setOpen] = useState(false);
  const [selected, setSelected] = useState("");
  const [customReason, setCustomReason] = useState("");
  const [imageFile, setImageFile] = useState<File | null>(null);
  const [imagePreview, setImagePreview] = useState<string | null>(null);
  const fileInputRef = useRef<HTMLInputElement>(null);

  const reasonToSend = selected === "기타" ? customReason : selected;
  const handleSubmit = () => {
    const reasonToSend = selected === "기타" ? customReason : selected;
    onSubmit(reasonToSend, imageFile);

    toast({
      title: "🚨 신고 완료",
      description: "신고가 정상적으로 접수되었습니다.",
      variant: "success",
    });

    setSelected("");
    setCustomReason("");
    setImageFile(null);
    setImagePreview(null);
    setOpen(false);
  };

  const handleImageChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0];
    if (file) {
      setImageFile(file);
      setImagePreview(URL.createObjectURL(file));
    }
  };

  const handleRemoveImage = () => {
    setImageFile(null);
    setImagePreview(null);
    if (fileInputRef.current?.value) {
      fileInputRef.current.value = "";
    }
  };

  return {
    open,
    setOpen,
    selected,
    setSelected,
    customReason,
    setCustomReason,
    imageFile,
    imagePreview,
    fileInputRef,
    reasonToSend,
    handleSubmit,
    handleImageChange,
    handleRemoveImage,
  };
};
