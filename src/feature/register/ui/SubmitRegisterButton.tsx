import { Button } from "@/shared/ui/button/Button";

interface SubmitRegisterButtonProps {
  onClick: () => void;
}

export const SubmitRegisterButton = ({
  onClick,
}: SubmitRegisterButtonProps) => {
  return (
    <Button
      className="w-full bg-green-600 hover:bg-green-700 text-white"
      onClick={onClick}
    >
      등록하기
    </Button>
  );
};
