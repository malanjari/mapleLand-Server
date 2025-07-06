import { useState } from "react";
import { Button } from "@/shared/ui/button/Button";

interface MapPreviewProps {
  mapName: string;
  miniMapImageUrl: string;
  miniMapImageLogoUrl: string;
}

export const MapPreview = ({
  mapName,
  miniMapImageUrl,
  miniMapImageLogoUrl,
}: MapPreviewProps) => {
  const [isPreviewOpen, setIsPreviewOpen] = useState(false);

  return (
    <div className="w-full flex flex-col items-center gap-3 mt-10 mb-10 text-white relative">
      <div className="flex items-center gap-4 p-6 rounded-lg bg-slate-700 shadow-md hover:shadow-lg transition duration-200">
        <img
          src={miniMapImageLogoUrl}
          alt="minimap"
          className="w-10 h-10 rounded-md object-contain bg-slate-600 p-1"
        />
        <p className="text-lg sm:text-xl font-semibold text-white">{mapName}</p>
      </div>

      <div className="relative">
        <img
          src={miniMapImageUrl}
          alt="맵로고"
          className=" inset-0 w-full object-contain rounded-md cursor-pointer transition max-w-[400px] max-h-[400px]"
          onClick={() => setIsPreviewOpen(true)}
        />

        {isPreviewOpen && (
          <div
            className="fixed inset-0 bg-black/80 z-[9999] flex items-center justify-center"
            onClick={() => setIsPreviewOpen(false)}
          >
            <div
              className="relative max-w-[90%] max-h-[90%] animate-fade-in"
              onClick={(e) => e.stopPropagation()}
            >
              <img
                src={miniMapImageUrl}
                alt="전체 보기"
                className="max-w-screen max-h-screen object-contain rounded-lg shadow-2xl border border-neutral-600"
              />
              <Button
                variant="none"
                onClick={() => setIsPreviewOpen(false)}
                className="absolute top-2 right-2 text-white text-xl bg-black/60 rounded-full px-3 py-1 hover:bg-black/80"
              >
                ✕
              </Button>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};
