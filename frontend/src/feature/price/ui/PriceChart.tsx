import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  Filler,
} from "chart.js";
import { Line } from "react-chartjs-2";
import { DailyPriceStat } from "@/feature/price/model/type";
import { TooltipItem } from "chart.js";
import { convertToKST } from "../../../shared/utils/date";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  Filler
);

interface Props {
  data: DailyPriceStat[];
}

export const PriceChart = ({ data }: Props) => {
  const formatKoreanPrice = (value: number): string => {
    if (value >= 1_0000_0000) {
      const billion = Math.floor(value / 1_0000_0000);
      const million = Math.floor((value % 1_0000_0000) / 1_0000);
      if (million === 0) return `${billion}억 `;
      return `${billion}억 ${million}만 `;
    }

    if (value >= 1_0000) {
      return `${Math.floor(value / 1_0000)}만 `;
    }

    return `${value.toLocaleString()} `;
  };
  const labels = data.map((d) => {
    const kst = convertToKST(d.dateTime);
    return kst.toLocaleTimeString("ko-KR", {
      hour: "2-digit",
      minute: "2-digit",
      hour12: false,
    });
  });

  const prices = data.map((d) => d.price);

  const chartData = {
    labels,
    datasets: [
      {
        label: "평균 가격",
        data: prices,
        borderColor: "#4ade80",
        backgroundColor: "rgba(74, 222, 128, 0.2)",
        tension: 0.4,
        pointRadius: 4,
        pointHoverRadius: 6,
        pointBackgroundColor: "#4ade80",
        fill: true, // 배경 채우기
      },
    ],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        display: false,
      },
      tooltip: {
        backgroundColor: "#1f2937",
        titleColor: "#fff",
        bodyColor: "#d1d5db",
        callbacks: {
          label: (context: TooltipItem<"line">) =>
            `${formatKoreanPrice(context.parsed.y)}`,
        },
      },
    },
    scales: {
      x: {
        ticks: {
          color: "#d1d5db",
          font: {
            size: 12,
          },
        },
        grid: {
          color: "#374151",
        },
      },
      y: {
        ticks: {
          color: "#d1d5db",
          font: {
            size: 12,
          },
          callback: (value: number | string) => {
            if (typeof value !== "number") return value;
            return formatKoreanPrice(value);
          },
        },
        grid: {
          color: "#374151",
        },
      },
    },
  };

  return (
    <div className="w-full bg-neutral-800 p-6 rounded-sm shadow-md">
      <h3 className="text-base font-semibold text-white mb-4">
        ⏱️ 시간별 평균 가격
      </h3>
      <div className="relative max-h-[300px]">
        <Line data={chartData} options={options} />
      </div>
    </div>
  );
};
