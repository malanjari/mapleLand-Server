interface CommentTextareaProps {
  comment: string;
  onChange: (comment: string) => void;
}

export const CommentTextarea = ({
  comment,
  onChange,
}: CommentTextareaProps) => {
  return (
    <div className="border-neutral-700 pb-4 mb-4">
      <label className="block mb-1 text-sm font-medium text-white">
        거래 메모
      </label>
      <textarea
        value={comment}
        onChange={(e) => onChange(e.target.value)}
        className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
        placeholder="거래 관련 안내 메시지"
        minLength={0}
        maxLength={60}
      />
    </div>
  );
};
