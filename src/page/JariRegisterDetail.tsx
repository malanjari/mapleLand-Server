import { useState } from "react";
import { SearchInputWithSuggestions } from "@/shared/ui/SearchInputWithSuggestions/SearchInputWithSuggestions";
import { Button } from "@/shared/ui/button/Button";

// 🚨 userId는 실제 로그인 정보에서 가져와야 함
const mockUserId = 123;

const JariRegisterDetailPage = () => {
  const [form, setForm] = useState({
    mapName: "",
    mapColor: null as "red" | "yellow" | "green" | null,
    comment: "",
    price: "",
    negotiationOption: false,
    area: "",
    userId: mockUserId,
    tradeType: null as "SELL" | "BUY" | null,
  });

  const handleSubmit = () => {
    const { mapName, mapColor, comment, price, area, tradeType } = form;
    if (!mapName || !mapColor || !comment || !price || !area || !tradeType) {
      alert("모든 필수 항목을 입력해주세요.");
      return;
    }

    const requestBody = {
      ...form,
      price: Number(form.price),
    };

    console.log("제출할 데이터:", requestBody);
    alert("등록 완료 (콘솔 확인)");
  };

  return (
    <div className="flex flex-col items-center pt-10 h-full gap-5 px-4 pb-20">
      {/* 안내 박스 */}
      <div className="space-y-3 text-sm sm:text-base text-left leading-relaxed bg-neutral-900 text-white p-6 rounded-md border border-neutral-700 w-full max-w-2xl">
        <p>
          ⚠️ 메랜자리 등록은{" "}
          <span className="font-semibold text-yellow-400">
            동시에 하나만 등록
          </span>
          할 수 있습니다.
        </p>
        <p>
          ⚠️ <span className="text-red-400">현금 거래나 허위 매물</span>은 사전
          통보 없이 삭제 및 제재될 수 있습니다.
        </p>
        <p>
          ✅{" "}
          <span className="text-green-400">정확하고 신뢰할 수 있는 정보</span>만
          등록해 주세요!
        </p>
      </div>

      {/* mapName */}
      <div className="w-full max-w-2xl">
        <SearchInputWithSuggestions
          placeholder="자리를 입력해주세요"
          className="w-full"
          onSelect={(val) => setForm((prev) => ({ ...prev, mapName: val }))}
        />
      </div>

      {/* tradeType */}
      <div className="w-full max-w-2xl space-y-2">
        <p className="text-white text-sm font-medium text-center">
          거래 타입을 선택해주세요
        </p>
        <div className="flex gap-4">
          <Button
            variant="none"
            onClick={() => setForm((prev) => ({ ...prev, tradeType: "SELL" }))}
            className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
              form.tradeType === "SELL"
                ? "bg-red-600 text-white border-red-600"
                : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
            }`}
          >
            팝니다
          </Button>
          <Button
            variant="none"
            onClick={() => setForm((prev) => ({ ...prev, tradeType: "BUY" }))}
            className={`flex-1 py-3 rounded-md text-sm font-semibold transition border ${
              form.tradeType === "BUY"
                ? "bg-blue-600 text-white border-blue-600"
                : "bg-neutral-800 text-white border-neutral-600 hover:border-white"
            }`}
          >
            삽니다
          </Button>
        </div>
      </div>

      {/* 거래 폼 */}
      {form.tradeType && (
        <div className="w-full max-w-2xl space-y-4 mt-4 text-white">
          {/* mapColor (빨/노/초 라디오) */}
          <div>
            <p className="text-sm font-medium mb-2">맵 상태를 선택해주세요</p>
            <div className="flex gap-4">
              <label className="flex items-center gap-2 cursor-pointer">
                <input
                  type="radio"
                  name="mapColor"
                  value="red"
                  checked={form.mapColor === "red"}
                  onChange={() =>
                    setForm((prev) => ({ ...prev, mapColor: "red" }))
                  }
                  className="accent-red-500"
                />
                <span className="text-white">빨강</span>
              </label>
              <label className="flex items-center gap-2 cursor-pointer">
                <input
                  type="radio"
                  name="mapColor"
                  value="yellow"
                  checked={form.mapColor === "yellow"}
                  onChange={() =>
                    setForm((prev) => ({ ...prev, mapColor: "yellow" }))
                  }
                  className="accent-yellow-400"
                />
                <span className="text-white">노랑</span>
              </label>
              <label className="flex items-center gap-2 cursor-pointer">
                <input
                  type="radio"
                  name="mapColor"
                  value="green"
                  checked={form.mapColor === "green"}
                  onChange={() =>
                    setForm((prev) => ({ ...prev, mapColor: "green" }))
                  }
                  className="accent-green-500"
                />
                <span className="text-white">초록</span>
              </label>
            </div>
          </div>

          {/* price */}
          <div>
            <label className="block mb-1 text-sm font-medium">가격</label>
            <input
              type="number"
              value={form.price}
              onChange={(e) =>
                setForm((prev) => ({ ...prev, price: e.target.value }))
              }
              className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
              placeholder="거래 가격을 입력해주세요"
            />
          </div>

          {/* area */}
          <div>
            <label className="block mb-1 text-sm font-medium">지역</label>
            <select
              value={form.area}
              onChange={(e) =>
                setForm((prev) => ({ ...prev, area: e.target.value }))
              }
              className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
            >
              <option value="">지역 선택</option>
              <option value="Victoria">Victoria</option>
              <option value="Ellanas">Ellanas</option>
              <option value="LudusNihal">LudusNihal</option>
              <option value="Leafre">Leafre</option>
            </select>
          </div>

          {/* negotiationOption */}
          <div className="flex items-center gap-2">
            <input
              type="checkbox"
              checked={form.negotiationOption}
              onChange={(e) =>
                setForm((prev) => ({
                  ...prev,
                  negotiationOption: e.target.checked,
                }))
              }
              id="negotiation"
            />
            <label htmlFor="negotiation" className="text-sm">
              흥정 가능
            </label>
          </div>

          {/* comment */}
          <div>
            <label className="block mb-1 text-sm font-medium">거래 메모</label>
            <textarea
              value={form.comment}
              onChange={(e) =>
                setForm((prev) => ({ ...prev, comment: e.target.value }))
              }
              className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
              placeholder="거래 관련 안내 메시지 (5~60자)"
              minLength={5}
              maxLength={60}
            />
          </div>

          {/* 등록 버튼 */}
          <Button
            className="w-full bg-green-600 hover:bg-green-700 text-white"
            onClick={handleSubmit}
          >
            등록하기
          </Button>
        </div>
      )}
    </div>
  );
};

export default JariRegisterDetailPage;
