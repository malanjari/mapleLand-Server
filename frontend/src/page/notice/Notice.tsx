// src/page/NoticePage.tsx

const NoticePage = () => {
  return (
    <div className="max-w-3xl mx-auto px-6 py-12 text-white bg-neutral-700 rounded-lg">
      <h1 className="text-2xl sm:text-3xl font-bold mb-8 text-yellow-300">
        📢 [공지] 메이플랜드 자리 시스템 이용 수칙 안내
      </h1>

      <p className="mb-6 text-sm leading-relaxed text-gray-300">
        안녕하세요,{" "}
        <span className="font-semibold text-white">
          메이플랜드 자리 시스템 운영팀
        </span>
        입니다.
        <br />
        🛡️ 공정한 거래 문화와 커뮤니티 질서 유지를 위해 아래와 같은 이용 수칙을
        안내드립니다.
        <br />
        ⚠️ 위반 시 사전 경고 없이 제재될 수 있습니다.
      </p>

      <hr className="border-neutral-600 my-8" />

      <section className="space-y-8">
        <div>
          <h2 className="text-lg font-bold text-red-400">
            🔥 1. 분쟁 자리 등록 금지
          </h2>
          <p className="text-sm mt-2 text-gray-300 leading-relaxed">
            분쟁 중인 자리임을 인지하고 있음에도{" "}
            <span className="font-semibold text-white">"팝니다"</span>로
            등록하는 행위는 금지됩니다. 해당 행위 적발 시{" "}
            <span className="text-yellow-300">1차 경고, 2차 무기한 제재</span>
            됩니다.
          </p>
          <ul className="text-sm mt-2 list-disc list-inside text-gray-400">
            <li>1차 적발: 경고 및 해당 거래 삭제</li>
            <li>2차 적발: 무기한 이용 제한</li>
          </ul>
        </div>

        <div>
          <h2 className="text-lg font-bold text-red-400">
            👥 다중 계정 중복 등록 금지
          </h2>
          <p className="text-sm mt-2 text-gray-300 leading-relaxed">
            동일한 캐릭터명을 사용하여 여러 디스코드 계정으로{" "}
            <span className="font-semibold text-white">삽니다/팝니다</span> 글을
            반복 등록하는 행위는
            <br />
            📛{" "}
            <span className="font-semibold text-white">
              자리팔이 및 시세 조작
            </span>
            으로 간주되며 즉시 이용 제한 조치됩니다.
          </p>
        </div>

        <div>
          <h2 className="text-lg font-bold text-red-400">
            💣 담합 및 강요, 비방 행위 금지
          </h2>
          <p className="text-sm mt-2 text-gray-300 leading-relaxed">
            특정 자리를 저렴하게 등록한 사용자에게 가격 담합을 유도하거나,
            <br />
            이에 응하지 않았다고 욕설, 비방, 강요하는 행위는
            <br />
            🚨{" "}
            <span className="font-semibold text-white">
              커뮤니티 질서를 해치는 중대한 위반
            </span>
            입니다.
          </p>
          <p className="text-sm text-red-300 font-semibold mt-1">
            ❌ 적발 시 무기한 제재가 적용됩니다.
          </p>
        </div>

        <div>
          <h2 className="text-lg font-bold text-red-400">
            🕵️ 스토킹 및 보복성 행동 금지
          </h2>
          <p className="text-sm mt-2 text-gray-300 leading-relaxed">
            사이트 정보를 기반으로 특정 사용자를 게임 내에서 추적, 겹사,
            사냥방해하는 행위는 어떤 이유로도 정당화될 수 없습니다.
          </p>
          <p className="text-sm text-red-300 font-semibold mt-1">
            🚫 즉시 무기한 이용 정지 조치됩니다.
          </p>
        </div>

        <div>
          <h2 className="text-lg font-bold text-red-400">
            💰 비정상적인 거래 완료 금지
          </h2>
          <p className="text-sm mt-2 text-gray-300 leading-relaxed">
            시세와 현저히 다른 가격으로 매물을 등록한 뒤{" "}
            <span className="font-semibold text-white">거래 완료</span> 처리하는
            행위는 허위 체결 및 시세 왜곡 시도로 간주됩니다.
          </p>
          <p className="text-sm mt-2 text-yellow-300">
            🔍 예: 시세 5,000만 메소 → 2,000만 메소 등록 후 '거래 완료'
          </p>
          <ul className="text-sm mt-2 list-disc list-inside text-gray-400">
            <li>1차 적발: 경고 및 해당 거래 삭제</li>
            <li>2차 적발: 무기한 이용 제한</li>
          </ul>
        </div>
      </section>

      <hr className="border-neutral-600 my-10" />

      <p className="text-sm text-gray-400">
        📌 위 수칙은 운영 상황에 따라 변경될 수 있으며,
        <br />
        <span className="text-white font-semibold">
          모든 이용자는 이를 숙지하고 준수해야 합니다.
        </span>
      </p>

      <p className="mt-6 text-sm text-gray-500">
        감사합니다. <br />
        메이플랜드 자리 시스템 운영팀
      </p>
    </div>
  );
};

export default NoticePage;
