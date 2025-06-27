import { Outlet } from "react-router-dom";
import Footer from "../footer/Footer";
import Header from "../header/Header";
const AppLayout = () => {
  return (
    <div className="flex flex-col flex-grow px-4 sm:px-6 md:px-10 lg:px-20 xl:px-28 w-full h-dvh mx-auto  ">
      <Header />

      <main className="max-w-[1440px] flex-col items-center w-full mx-auto flex-grow  py-6 px-4 sm:px-6 md:px-8 lg:px-10 xl:px-16 ">
        <Outlet />
      </main>
      <footer className="w-full bg-neutral-900 text-neutral-500 text-sm border-t border-neutral-800 py-6 text-center">
        <Footer />
      </footer>
    </div>
  );
};

export default AppLayout;
