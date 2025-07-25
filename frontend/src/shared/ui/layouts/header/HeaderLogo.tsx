import { Link } from "react-router-dom";
import logo from "@/shared/assets/logo/logo.webp";

export const HeaderLogo = () => (
  <Link className="flex gap-2 items-center" to="/">
    <img src={logo} alt="Logo" className="h-10 w-10" />
    <p className="font-bold hidden sm:block">메랜샵</p>
  </Link>
);
