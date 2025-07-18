import { WorldSearchGrid } from "@/feature/worldJari/ui/WorldSearchGrid";
import { UserWelcomeBox } from "@/feature/user/ui/UserWelcomeBox";

import { lazy, Suspense } from "react";

import { NoticeBanner } from "@/feature/notice/ui/NoticeBanner";
import { useUser } from "@/entity/user/hooks/useUser";

const PopularJariGrid = lazy(
  () => import("@/feature/popularJari/ui/PopularJariGrid")
);

const HomePage = () => {
  const user = useUser();
  console.log(user?.user);
  return (
    <div className="py-10   flex flex-col gap-10">
      <UserWelcomeBox />
      <NoticeBanner />
      <WorldSearchGrid />
      <Suspense
        fallback={
          <div className="text-center text-white">
            🔥 인기 자리 불러오는 중...
          </div>
        }
      >
        <PopularJariGrid />
      </Suspense>
    </div>
  );
};

export default HomePage;
