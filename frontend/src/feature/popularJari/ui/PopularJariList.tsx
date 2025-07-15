import { Link } from "react-router-dom";

interface PopularJariItem {
  mapName: string;
  count: number;
}

interface PopularJariListProps {
  items: PopularJariItem[];
  title?: string;
  maxItems?: number;
}

export const PopularJariList = ({
  items,
  title = "🔥 인기 자리",
  maxItems = 5,
}: PopularJariListProps) => {
  const topItems = items.slice(0, maxItems);

  if (topItems.length === 0) return null;

  return (
    <div className="bg-neutral-800 py-5 px-2 rounded-xl mt-6 text-sm text-white shadow-md border border-neutral-700">
      <h3 className="font-bold text-lg mb-4 flex items-center gap-2 text-white">
        <span className="text-yellow-400 text-xl"></span>
        {title}
      </h3>
      <ul className="space-y-2">
        {topItems.map((item, idx) => (
          <li
            key={item.mapName}
            className="hover:bg-neutral-700 transition-colors rounded-md"
          >
            <Link
              to={`/jari/${encodeURIComponent(item.mapName)}`}
              className="flex justify-between items-center px-2 py-2 rounded-md w-full"
            >
              <div className="flex items-center gap-2">
                <span className="text-yellow-300 font-semibold text-xs">
                  {idx + 1}.
                </span>
                <span className="text-xs">
                  {item.mapName.split(":")[1] ?? item.mapName}
                </span>
              </div>
              <span className="bg-blue-500 text-white text-[11px] font-semibold px-1 py-[1px] rounded inline-block lg:hidden">
                {item.count}건
              </span>
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};
