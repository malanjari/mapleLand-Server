import { WorldSearchGrid } from "@/feature/worldJari/ui/WorldSearchGrid";
import { UserWelcomeBox } from "@/feature/auth/ui/UserWelcomeBox";
import { DiscordBanner } from "@/feature/auth/ui/DiscordBanner";
import { PopularJariGrid } from "@/feature/popularJari/ui/PopularJariGrid";

const HomePage = () => {
  return (
    <div className="py-10   flex flex-col gap-10">
      <DiscordBanner />
      <UserWelcomeBox />
      <WorldSearchGrid />
      <PopularJariGrid />
    </div>
  );
};

export default HomePage;
