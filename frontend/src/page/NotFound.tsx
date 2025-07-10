import notFoundImg from "@/shared/assets/notFoundImg.png";
const NotFoundPage = () => {
  return (
    <div className="h-dvh flex flex-col items-center justify-center text-center px-4">
      <img src={notFoundImg} alt="Logo" className="w-16 h-16 mb-6" />
      <h1 className="text-3xl font-bold mb-4">404 - 없는 페이지입니다</h1>
      <p className="text-muted-foreground mb-6">주소를 다시 확인해 주세요.</p>
      <a
        href="/"
        className="text-blue-500 underline hover:text-blue-700 transition"
      >
        홈으로 돌아가기
      </a>
    </div>
  );
};

export default NotFoundPage;
