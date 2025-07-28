import { useState } from "react";
import ReactMarkdown from "react-markdown";
import { Input } from "@/shared/ui/input/Input";

const NoticeWritePage = () => {
  const [title, setTitle] = useState("");
  const [markdown, setMarkdown] = useState("");

  const handleSubmit = async () => {
    await fetch("/api/notices", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, content: markdown }),
    });
  };

  return (
    <div className="max-w-3xl mx-auto space-y-4">
      <Input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="공지 제목"
      />
      <textarea
        value={markdown}
        onChange={(e) => setMarkdown(e.target.value)}
        rows={12}
        className="w-full border p-3 rounded bg-neutral-900 text-white"
        placeholder="공지 내용을 마크다운으로 작성하세요"
      />
      <h3 className="text-lg font-bold mt-4">🖼️ 미리보기</h3>
      <div className="p-4 border rounded bg-neutral-800 text-white prose prose-invert max-w-none">
        <ReactMarkdown>{markdown}</ReactMarkdown>
      </div>

      <button
        onClick={handleSubmit}
        className="bg-blue-600 text-white px-4 py-2 rounded"
      >
        공지 작성하기
      </button>
    </div>
  );
};
export default NoticeWritePage;
