// src/shared/ui/spinner/Spinner.tsx
import { Loader2 } from "lucide-react";
import { cn } from "@/shared/utils/cn";

export const Spinner = ({ className }: { className?: string }) => {
  return (
    <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
      <Loader2
        className={cn("w-10 h-10 animate-spin text-gray-300", className)}
      />
    </div>
  );
};
