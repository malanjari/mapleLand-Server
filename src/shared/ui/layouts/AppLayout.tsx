import { Outlet } from "react-router-dom";
import Footer from "../footer/Footer";
import Header from "../header/Header";
import { useEffect } from "react";
import { useAuthStore } from "@/lib/store/useAuthStore";
const AppLayout = () => {
  const initialize = useAuthStore((state) => state.initialize);

  useEffect(() => {
    initialize(); // ✅ 앱 시작 시 토큰 불러와 로그인 상태 복구
  }, [initialize]);
  return (
    <div className="flex flex-col flex-grow px-4 sm:px-6 md:px-10 lg:px-20 xl:px-28 w-full h-dvh mx-auto  ">
      <Header />
      <main className="max-w-[1440px] flex-col items-center w-full mx-auto flex-grow  py-6 px-4 sm:px-6 md:px-8 lg:px-10 xl:px-16 ">
        <Outlet />
      </main>
      <Footer />
    </div>
  );
};

export default AppLayout;
