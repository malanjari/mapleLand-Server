import {
  Chart as ChartJS,
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
} from "chart.js";
import { Line } from "react-chartjs-2";
import { DailyPriceStat } from "../api/priceStat";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend
);

interface Props {
  data: DailyPriceStat[];
}

export const PriceChart = ({ data }: Props) => {
  const labels = data.map((d) =>
    new Date(d.dateTime).toLocaleDateString("ko-KR", {
      month: "numeric",
      day: "numeric",
    })
  );

  const prices = data.map((d) => d.price);

  const chartData = {
    labels,
    datasets: [
      {
        label: "평균 가격",
        data: prices,
        borderColor: "#4ade80",
        backgroundColor: "#4ade80",
        tension: 0.4,
        pointRadius: 4,
        fill: false,
      },
    ],
  };

  const options = {
    responsive: true,
    plugins: {
      legend: {
        display: false,
      },
      tooltip: {
        callbacks: {
          label: (context) => `${context.parsed.y.toLocaleString()}`,
        },
      },
    },
    scales: {
      x: {
        ticks: {
          color: "#ccc",
        },
      },
      y: {
        ticks: {
          color: "#ccc",
          stepSize: 200,
        },
        beginAtZero: false,
      },
    },
  };

  return (
    <div className="w-full bg-neutral-800 p-4 rounded-md">
      <h3 className="text-sm font-semibold text-white mb-2">
        📊 날짜별 평균 가격
      </h3>
      <Line data={chartData} options={options} />
    </div>
  );
};
