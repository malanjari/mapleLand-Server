import { Input } from "@/shared/ui/input/Input";

import { Search } from "lucide-react";
const JariRegisterPage = () => {
  return (
    <section className=" flex flex-col items-center h-full p-20 px-4">
      <div className="text-center space-y-6">
        <h1 className="text-xl  mb:text-3xl font-bold">
          메랜자리 자리 등록 페이지입니다.
        </h1>
        <p className="text-muted-foreground text-sm sm:text-base">
          원하는 사냥터를 검색해주세요.
        </p>
        <div className="max-w-sm w-full mx-auto relative">
          <Input
            placeholder="예: 구름공원, 죽은나무숲2, 망가진 용의 둥지..."
            className="h-12 pr-10"
          />
          <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
            <Search className="w-5 h-5 text-muted-foreground cursor-pointer" />
          </div>
        </div>
      </div>
    </section>
  );
};

export default JariRegisterPage;
