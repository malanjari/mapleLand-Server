interface PriceInputProps {
  price: string;
  onChange: (value: string) => void;
  formatToWonStyle: (value: number | string) => string;
}

export const PriceInput = ({
  price,
  onChange,
  formatToWonStyle,
}: PriceInputProps) => {
  return (
    <div className="border-b border-neutral-700 pb-4 mb-4">
      <label className="block mb-1 text-sm font-medium text-white">가격</label>
      <input
        type="number"
        value={price}
        onChange={(e) => onChange(e.target.value)}
        className="w-full p-2 bg-neutral-800 text-white rounded border border-neutral-600"
        placeholder="거래 가격을 입력해주세요"
      />
      {price && (
        <p className="mt-1 px-2 text-sm text-white">
          {formatToWonStyle(price)}
        </p>
      )}
    </div>
  );
};
