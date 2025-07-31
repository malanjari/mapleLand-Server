const NotificationGuide = () => {
  return (
    <div className="max-w-xl mx-auto py-12 px-6 text-white rounded-lg bg-neutral-700">
      <h1 className="text-2xl font-bold mb-6">🔔 디스코드 알림 설정 가이드</h1>
      <p className="mb-4 text-sm sm:text-base leading-relaxed">
        자리 등록 알림을 받으려면 아래 세 단계를 완료해주세요:
      </p>
      <ol className="list-decimal ml-5 space-y-4 text-sm sm:text-base">
        <li>
          <strong>디스코드 서버에 입장</strong>
          <br />
          👉{" "}
          <a
            href="https://discord.gg/6kb8jwbTvR"
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
          <strong>디스코드 내 알림 설정</strong>
          <br />
          디스코드 서버의{" "}
          <span className="text-yellow-300 font-semibold">
            #🔔｜알림받는-설정
          </span>{" "}
          채널에 접속하여 안내된 내용을 읽고,{" "}
          <span className="text-yellow-300 font-semibold">
            원하는 자리를 알림 설정
          </span>
          해주세요.
          <br />
          <span className="text-sm text-neutral-300 mt-1 block leading-relaxed">
            설정이 완료되면 해당 자리에 새 글이 등록될 때{" "}
            <span className="text-yellow-300 font-semibold">디스코드 DM</span>
            으로 자동 알림을 받게 됩니다. 알림 설정은 언제든지 자유롭게
            추가하거나 해제할 수 있어요.
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
