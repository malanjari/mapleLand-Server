export const AlertBanner = () => {
  return (
    <div className="flex justify-between items-center bg-red-900 border border-red-600 text-red-300 text-sm rounded-lg px-4 py-3 shadow-sm">
      <div className="flex items-center gap-2">
        <span className="text-lg">⚠️</span>
        <span>
          현재{" "}
          <span className="font-semibold text-red-200">디스코드 인증 오류</span>
          로 인해{" "}
          <span className="font-semibold text-red-200">
            회원가입이 일시적으로 중단
          </span>
          된 상태입니다. 문제를 신속히 확인 중이며, 최대한 빠르게
          복구하겠습니다. 불편을 드려 죄송합니다.
        </span>
      </div>
    </div>
  );
};
