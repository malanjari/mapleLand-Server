const EventPage = () => {
  return (
    <div className="max-w-2xl mx-auto px-4 py-10 text-white space-y-8">
      {/* 거래 완료 이벤트 */}
      <section className="space-y-2">
        <h1 className="text-2xl font-bold">🎉 거래 완료 이벤트</h1>
        <p className="text-sm text-neutral-400">
          이벤트 기간:{" "}
          <span className="text-yellow-300">2025.07.26 ~ 2025.08.02</span>
        </p>
        <p>
          이벤트 기간 동안 mashop.kr에서{" "}
          <span className="font-semibold text-green-300">자리 거래를 완료</span>
          하면 자동으로 이벤트에 참여됩니다. 추첨을 통해{" "}
          <span className="text-yellow-400 font-semibold">
            맘스터치 싸이버거 세트
          </span>
          를 드립니다!
        </p>
      </section>

      <section className="bg-neutral-800 border border-neutral-700 rounded-lg p-5 space-y-3">
        <h2 className="text-lg font-semibold text-yellow-300">🎁 경품 안내</h2>
        <p className="text-sm text-neutral-300">
          ✅ <span className="text-white">맘스터치 싸이버거 세트 (총 3명)</span>
          <br />
          📢 당첨자 발표: 8월 3일 / 공지사항 및 디스코드 채널
        </p>
      </section>

      <section className="bg-neutral-800 border border-neutral-700 rounded-lg p-5 space-y-3">
        <h2 className="text-lg font-semibold text-yellow-300">⚠️ 유의사항</h2>
        <ul className="list-disc list-inside text-sm text-neutral-400 space-y-1">
          <li>정상적으로 등록된 거래만 이벤트에 포함됩니다.</li>
          <li>허위 또는 부정한 방식의 거래는 제외됩니다.</li>
          <li>이벤트는 예고 없이 조기 종료될 수 있습니다.</li>
        </ul>
      </section>

      {/* 회원가입 축하 이벤트 */}
      <section className="space-y-2">
        <h1 className="text-2xl font-bold">🆕 회원가입 축하 이벤트</h1>
        <p className="text-sm text-neutral-400">
          이벤트 기간:{" "}
          <span className="text-yellow-300">700명 ~ 1000명 도달 시까지</span>
        </p>
        <p>
          mashop.kr에 <span className="font-semibold text-white">700번째</span>{" "}
          또는 <span className="font-semibold text-white">1000번째</span>로
          회원가입하고,{" "}
          <span className="font-semibold text-green-300">자리 거래를 완료</span>
          하면{" "}
          <span className="text-yellow-400 font-semibold">
            맘스터치 싸이버거 세트
          </span>
          를 드립니다!
        </p>
      </section>

      <section className="bg-neutral-800  rounded-lg p-5 space-y-3">
        <h2 className="text-lg font-semibold text-yellow-300">🎁 경품 안내</h2>
        <p className="text-sm text-neutral-300">
          ✅{" "}
          <span className="text-white">
            맘스터치 싸이버거 세트 (총 2명 – 700번째 & 1000번째 가입자)
          </span>
          <br />
          📢 지급 방식: 조건 충족 시 자동 지급 / 개별 연락 또는 공지사항
        </p>
      </section>

      <section className="bg-neutral-800   rounded-lg p-5 space-y-3">
        <h2 className="text-lg font-semibold text-yellow-300">⚠️ 유의사항</h2>
        <ul className="list-disc list-inside text-sm text-neutral-400 space-y-1">
          <li>회원가입 후 거래를 완료해야 경품 지급 대상이 됩니다.</li>
          <li>중복 가입 등 부정한 방식은 무효 처리됩니다.</li>
          <li>이벤트는 조기 마감되거나 변경될 수 있습니다.</li>
        </ul>
      </section>

      <div className="text-center pt-4">
        <p className="text-sm text-neutral-400">
          * 모든 이벤트는 별도의 신청 없이 조건 충족 시 자동 참여 처리됩니다.
        </p>
      </div>
    </div>
  );
};

export default EventPage;
