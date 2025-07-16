interface Props {
  title: string;
  value: number;
}

export const SummaryCard = ({ title, value }: Props) => {
  return (
    <div className="bg-neutral-800 rounded-xl p-5 shadow flex flex-col gap-2">
      <p className="text-sm text-neutral-400">{title}</p>
      <p className="text-3xl font-bold text-white">{value.toLocaleString()}</p>
    </div>
  );
};
