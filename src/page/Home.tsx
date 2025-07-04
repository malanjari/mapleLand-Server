import { WorldSearchGrid } from "@/widgets/worldSearch/WorldSearchGrid";
import { UserWelcomeBox } from "@/feature/auth/ui/UserWelcomeBox";
import { DiscordBanner } from "@/feature/auth/ui/DiscordBanner";
import { PopularJariGrid } from "@/widgets/popularJari/PopularJariGrid";

const HomePage = () => {
  return (
    <div className="py-10 flex flex-col gap-10">
      <DiscordBanner />
      <UserWelcomeBox />
      <WorldSearchGrid />
      <PopularJariGrid />
    </div>
  );
};

export default HomePage;
