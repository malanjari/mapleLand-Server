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
  const labels = data.map((d) => {
    const utc = new Date(d.dateTime);
    const kst = new Date(utc.getTime() + 9 * 60 * 60 * 1000); // +9시간
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
            `${context.parsed.y.toLocaleString()} 메소`,
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
          callback: (value: number | string) => `${value}메소`,
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
