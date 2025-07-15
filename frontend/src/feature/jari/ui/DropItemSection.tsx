// src/feature/jari/ui/DropItemSection.tsx

import { DropItem } from "@/entity/jari/api/monsterInfo";
import { Card, CardContent } from "@/shared/ui/card/card";

interface Props {
  dropItems: DropItem[];
}

const DropItemSection = ({ dropItems }: Props) => {
  return (
    <div className="border border-neutral-700 p-4 bg-neutral-800 rounded-md">
      <h3 className="text-lg font-bold text-white mb-3">드랍 아이템</h3>

      {dropItems.length > 0 ? (
        <div className="grid mb:grid-cols-2 xl:grid-cols-4 gap-4">
          {dropItems.map((item, i) => {
            const match = item.itemImageUrl.match(/item\/(\d+)\//);
            const itemId = match ? match[1] : null;
            const mapledbUrl = itemId
              ? `https://mapledb.kr/search.php?q=${itemId}&t=item`
              : null;

            return (
              <a
                key={i}
                href={mapledbUrl || undefined}
                target="_blank"
                rel="noopener noreferrer"
                className="block lg:aspect-[3/1] bg-neutral-800 rounded-md transition-transform duration-300 ease-out hover:scale-[1.02] hover:shadow-lg hover:ring-2 hover:ring-blue-400"
              >
                <Card className="flex flex-col items-center rounded-md text-center py-2 bg-transparent transition-colors duration-300 hover:bg-neutral-700/50">
                  <img
                    src={item.itemImageUrl}
                    alt="item"
                    className="w-12 h-12 object-contain bg-neutral-700 rounded transition-transform duration-300 hover:scale-105"
                  />
                  <CardContent className="flex flex-col justify-center p-0 mt-2 text-sm text-neutral-300">
                    <p className="font-aggro text-base group-hover:text-white transition">
                      {item.itemName}
                    </p>
                    <p className="text-xs text-neutral-300">
                      드랍률: {item.dropRate}%
                    </p>
                  </CardContent>
                </Card>
              </a>
            );
          })}
        </div>
      ) : (
        <p className="text-sm text-neutral-500 italic">드랍 정보가 없습니다.</p>
      )}

      <p className="text-xs text-gray-400 mt-4 italic">
        * 아이템 카드를 클릭하면{" "}
        <a
          href="https://mapledb.kr/"
          target="_blank"
          rel="noopener noreferrer"
          className="text-blue-400 font-semibold underline hover:text-blue-300"
        >
          메랜DB
        </a>
        에서 더 정확한 드랍 정보와 확률을 확인할 수 있습니다.
      </p>
    </div>
  );
};

export default DropItemSection;
