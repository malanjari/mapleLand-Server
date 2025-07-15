const NotificationGuide = () => {
  return (
    <div className="max-w-xl mx-auto py-12 px-6 text-white rounded-lg bg-neutral-700">
      <h1 className="text-2xl font-bold mb-6">🔔 디스코드 알림 설정 가이드</h1>
      <p className="mb-4 text-sm sm:text-base leading-relaxed">
        자리 등록 알림을 받으려면 아래 세 단계를 완료해야 합니다:
      </p>
      <ol className="list-decimal ml-5 space-y-4 text-sm sm:text-base">
        <li>
          <strong>디스코드 서버에 입장</strong>
          <br />
          👉{" "}
          <a
            href="https://discord.gg/tmrzYvFh"
            target="_blank"
            rel="noopener noreferrer"
            className="text-yellow-300 underline hover:text-yellow-200"
          >
            디스코드 서버 참여하기
          </a>
        </li>
        <li>
          <strong>DM 수신 허용 확인</strong>
          <br />
          알림은 디스코드{" "}
          <span className="text-yellow-300 font-semibold">DM</span>으로
          발송됩니다. 대부분 자동으로 설정되어 있지만, 메시지를 받지 못했다면
          서버 설정에서{" "}
          <span className="text-yellow-300 font-semibold">
            “이 서버의 다른 멤버가 보내는 다이렉트 메시지 허용”
          </span>{" "}
          옵션이 켜져 있는지 확인해주세요.
        </li>
        <li>
          <strong>원하는 자리 알림 설정</strong>
          <br />
          <span className="text-yellow-300 font-semibold">
            ⚠️ 월드 페이지가 아닌
          </span>{" "}
          개별 <span className="font-semibold">자리 상세 페이지</span>에서{" "}
          <span className="text-yellow-300 font-semibold">🔔 알림 받기</span>{" "}
          버튼을 눌러주세요. 해당 자리에 새로운 등록이 생기면 디스코드 DM으로
          알려드립니다.
          <br />
          <span className="text-xs text-neutral-300 italic mt-1 block">
            ※ 최대 <span className="text-yellow-300 font-bold">2개</span>{" "}
            자리까지 알림 설정이 가능합니다.
          </span>
        </li>
      </ol>

      <div className="mt-8 bg-blue-900/50 p-4 rounded-md text-blue-100 text-sm">
        💡 알림은 디스코드 DM으로 발송됩니다. 위 3단계를 모두 완료해야
        정상적으로 알림을 받을 수 있어요.
      </div>
    </div>
  );
};

export default NotificationGuide;
