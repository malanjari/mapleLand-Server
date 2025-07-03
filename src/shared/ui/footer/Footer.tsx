const Footer = () => {
  return (
    <footer className="w-full bg-neutral-950  text-neutral-500 text-sm border-t border-neutral-800 p-6 text-center">
      <p className="mb-1 font-semibold text-white">malanjari.kr</p>
      <p>© {new Date().getFullYear()} All rights reserved.</p>
    </footer>
  );
};

export default Footer;
