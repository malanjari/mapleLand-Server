import { Link } from "react-router-dom";

export const UserWelcomeBox = () => {
  return (
    <Link
      to="/notification-guide"
      className="self-start bg-[#5865F2] hover:bg-[#4752c4] text-white px-4 py-3 rounded-lg text-sm font-medium shadow transition cursor-pointer flex items-center gap-3"
    >
      <div className="flex-1 leading-snug">
        <span className="text-white/90 text-xs sm:text-sm ">
          자리 알림을 빠르게 받고 싶다면?{" "}
          <span className="text-yellow-300 font-semibold ">
            🔔 디스코드 알림 설정!
          </span>
        </span>
      </div>
    </Link>
  );
};
