import logo from "@/shared/assets/logo.png";
import { Link } from "react-router-dom";
import { Input } from "../input/input";
import { Search } from "lucide-react";
const Header = () => {
  return (
    <header className="w-full bg-neutral-900 flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-6 lg:px-8 xl:px-12 border-neutral-800  ">
      <Link to="/">
        <img src={logo} alt="MyApp Logo" className="h-10 w-10" />
      </Link>
      <div className="w-1/2 max-w-[300px] relative">
        <Input placeholder="자리를 검색해 보세요" className="px-8"></Input>

        <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
          <Search
            className="w-4 h-4 text-muted-foreground cursor-pointer"
            onClick={() => console.log("검색 클릭")}
          />
        </div>
      </div>
      <div>로그인</div>
    </header>
  );
};

export default Header;
