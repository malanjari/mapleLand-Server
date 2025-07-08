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
    <div className="flex flex-col flex-grow   w-full min-h-dvh mx-auto  ">
      <Header />
      <ScrollToTop />
      <Toaster />
      <main className="max-w-[1440px]  flex-col items-center w-full mx-auto flex-grow  pb-20 px-6 py-6 lg:px-28   ">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default AppLayout;
