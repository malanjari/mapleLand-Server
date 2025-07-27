import { Link } from "react-router-dom";

export const NoticeBanner = () => {
  return (
    <Link
      to="/event"
      className="flex justify-between items-center bg-neutral-800 border border-yellow-600 text-yellow-300 text-sm rounded-lg px-4 py-3 shadow-sm"
    >
      <div className="flex items-center gap-2">
        <span className="text-lg">🎉</span>
        <span>
          [이벤트] 거래하고{" "}
          <span className="font-semibold text-yellow-200">
            맘스터치 싸이버거
          </span>{" "}
          받아가세요!
        </span>
      </div>

      <a
        href="/event/1"
        className="text-yellow-400 hover:underline hover:text-yellow-300 ml-4 whitespace-nowrap"
      >
        자세히 보기 →
      </a>
    </Link>
  );
};
