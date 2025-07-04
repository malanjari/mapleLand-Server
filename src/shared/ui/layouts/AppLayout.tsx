import { Outlet } from "react-router-dom";
import Footer from "../footer/Footer";
import Header from "../../../widgets/header/Header";
import { useEffect } from "react";

import { useAuthActions } from "@/entity/user/hooks/useUser";
import ScrollToTop from "@/app/ScrollToTop";
import { Toaster } from "../toast/toaster";
const AppLayout = () => {
  const { initialize } = useAuthActions();

  useEffect(() => {
    initialize();
  }, [initialize]);
  return (
    <div className="flex flex-col flex-grow px-4 sm:px-6 md:px-10 lg:px-16 xl:px-24 w-full h-dvh mx-auto  ">
      <Header />
      <ScrollToTop />
      <Toaster />
      <main className="max-w-[1440px]   flex-col items-center w-full mx-auto flex-grow  py-6 px-4 sm:px-6 md:px-8 lg:px-10 xl:px-16 ">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default AppLayout;
