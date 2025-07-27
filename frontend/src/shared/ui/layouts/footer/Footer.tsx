import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="w-full text-neutral-500 text-sm border-t border-neutral-800 p-6 text-center">
      <Link to="/" className="mb-1 font-semibold text-white">
        mashop.kr
      </Link>

      <p className="mb-1">
        {" "}
        <a
          href="/notice"
          className="text-neutral-400 hover:underline hover:text-white transition"
        >
          공지사항
        </a>
      </p>

      <p>© {new Date().getFullYear()} All rights reserved.</p>
    </footer>
  );
};

export default Footer;
