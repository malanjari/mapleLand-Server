// src/feature/jari/ui/PriceStatInfo.tsx

export const PriceStatInfo = () => {
  return (
    <div className="mt-0 px-4 py-3 rounded-lg bg-gradient-to-r from-[#1f2937] to-[#111827] border border-blue-500 text-sm text-blue-200 leading-relaxed shadow-md">
      💡 <span className="font-semibold text-white">가격 그래프 안내</span>
      <br />
      이 그래프는 최근 자리 등록 가격 중 <br />
      <span className="text-blue-300 font-medium">상위 20%</span>와{" "}
      <span className="text-blue-300 font-medium">하위 20%</span>를 제외한{" "}
      <span className="text-white font-bold">중간 60% 평균값</span>을 기준으로
      계산됩니다.
    </div>
  );
};
