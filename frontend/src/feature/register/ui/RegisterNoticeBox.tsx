export const RegisterNoticeBox = () => (
  <div className="space-y-3 text-sm sm:text-base text-left leading-relaxed bg-neutral-900 text-white p-6 rounded-md border border-neutral-700 w-full max-w-2xl">
    <p>
      ⚠️{" "}
      <span className="font-semibold text-yellow-400">
        같은 맵에는 “팝니다”든 “삽니다”든 하나만 등록
      </span>
      할 수 있습니다.
      <br />
      예: A맵에 “팝니다” 등록 중이라면 A맵에 “삽니다”는 등록 불가
    </p>
    <p>
      ⚠️{" "}
      <span className="font-semibold text-yellow-400">
        다른 맵에는 “팝니다”, “삽니다” 각각 하나씩 등록
      </span>
      이 가능합니다.
      <br />
      예: A맵에 “팝니다”, B맵에 “삽니다” → 가능 ✅
    </p>
    <p>
      ⚠️ <span className="text-red-400">현금 거래나 허위 매물</span>은 사전 통보
      없이 삭제 및 제재될 수 있습니다.
    </p>
    <p>
      ✅ <span className="text-green-400">정확하고 신뢰할 수 있는 정보</span>만
      등록해 주세요!
    </p>
  </div>
);
