import { Input } from "@/shared/ui/input/Input";
import { Search } from "lucide-react";

export const HeaderSearchBar = () => (
  <div className="w-1/2 max-w-[500px] relative">
    <Input placeholder="자리를 검색해 보세요..." className="pr-8" />
    <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
      <Search className="w-4 h-4 text-muted-foreground cursor-pointer" />
    </div>
  </div>
);
