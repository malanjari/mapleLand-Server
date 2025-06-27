import logo from "@/shared/assets/logo.png";
import { Link } from "react-router-dom";
import { Input } from "../input/input";
import { Search } from "lucide-react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faDiscord } from "@fortawesome/free-brands-svg-icons";
import { Button } from "../button/Button";
const Header = () => {
  return (
    <header className="sticky top-0 z-50 w-full bg-neutral-900 flex items-center justify-between border-b py-6 px-4 sm:px-4 md:px-6 lg:px-8 xl:px-12 border-neutral-800  ">
      <div>
        <Link className="flex gap-2 items-center" to="/">
          <img src={logo} alt="Logo" className="h-10 w-10" />
          <p className="font-bold">메렌자리.kr</p>
        </Link>
      </div>
      <div className="w-1/2 max-w-[500px] relative">
        <Input placeholder="자리를 검색해 보세요..." className="pr-8"></Input>

        <div className="absolute right-0 top-0 h-full w-10 flex items-center justify-center z-10">
          <Search className="w-4 h-4 text-muted-foreground cursor-pointer" />
        </div>
      </div>
      <Button size="sm" className="bg-[#5865F2] hover:bg-[#4752c4]">
        <FontAwesomeIcon icon={faDiscord} className="w-5 h-5" />
        <span className="text-xs">로그인</span>
      </Button>
    </header>
  );
};

export default Header;
