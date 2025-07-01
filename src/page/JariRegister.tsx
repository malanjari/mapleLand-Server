import { SearchInputWithSuggestions } from "@/shared/ui/SearchInputWithSuggestions/SearchInputWithSuggestions";
import { useNavigate } from "react-router-dom";
const JariRegisterPage = () => {
  const navigate = useNavigate();
  return (
    <section className="flex flex-col items-center h-full p-20 px-4">
      <div className="w-full text-center space-y-6">
        <h1 className="text-xl mb:text-3xl font-bold">
          자리 등록 페이지입니다.
        </h1>
        <p className="text-muted-foreground text-sm sm:text-base">
          원하는 사냥터를 검색해주세요.
        </p>

        <SearchInputWithSuggestions
          placeholder="예: 구름공원, 죽은나무숲2..."
          className="max-w-lg mx-auto"
          onSelect={(val) => {
            navigate(`/jari/register/${encodeURIComponent(val)}`);
          }}
        />
      </div>
    </section>
  );
};

export default JariRegisterPage;
