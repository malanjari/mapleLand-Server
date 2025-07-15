import { Link } from "react-router-dom";

export const NoticeBanner = () => {
  return (
    <Link
      to="/notice"
      className="block w-full bg-gradient-to-r from-neutral-700 to-neutral-800 border border-neutral-600 text-white text-sm p-4 rounded-lg shadow-md hover:brightness-110 transition"
    >
      <div className="flex items-center justify-between">
        <span className="truncate">
          📢{" "}
          <span className="font-semibold text-yellow-300">
            사이트 이용 안내
          </span>
          가 있습니다.
        </span>
        <span className="text-xs text-neutral-300 font-semibold">
          자세히 보기 →
        </span>
      </div>
    </Link>
  );
};
