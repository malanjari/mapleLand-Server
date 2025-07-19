import { useNavigate } from "react-router-dom";

interface Props {
  title: string;
  to: string;
  sumUsers?: number;
}

export const SummaryCard = ({ title, to, sumUsers }: Props) => {
  const navigate = useNavigate();
  const handleClick = () => {
    if (to) {
      navigate(to);
    }
  };
  return (
    <div
      onClick={handleClick}
      className="bg-neutral-800 rounded-xl p-5 shadow flex flex-col gap-2 cursor-pointer hover:bg-neutral-900 transition-all "
    >
      <p className="text-sm text-neutral-400">
        {title} : {sumUsers && `${sumUsers}명`}
      </p>
    </div>
  );
};
