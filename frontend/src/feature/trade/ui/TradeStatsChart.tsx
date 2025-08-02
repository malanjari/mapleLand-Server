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
import { TooltipItem } from "chart.js";
import { useEffect, useState } from "react";
import {
  getMonthlyCompletedTradeStats,
  CompletedTradeStats,
} from "@/entity/trade/api/getCompletedTradeCount";

ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  Filler
);

interface TradeStatsChartProps {
  year: number;
  month: number;
}

export const TradeStatsChart = ({ year, month }: TradeStatsChartProps) => {
  const [data, setData] = useState<CompletedTradeStats[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      setLoading(true);
      try {
        const tradeStats = await getMonthlyCompletedTradeStats(year, month);
        setData(tradeStats);
      } catch (error) {
        console.error("데이터 로딩 실패:", error);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [year, month]);

  const labels = data.map((d) =>
    new Date(d.date).toLocaleDateString("ko-KR", {
      month: "numeric",
      day: "numeric",
    })
  );

  const counts = data.map((d) => d.count);

  const chartData = {
    labels,
    datasets: [
      {
        label: "완료된 거래 수",
        data: counts,
        borderColor: "#10b981",
        backgroundColor: "rgba(16, 185, 129, 0.2)",
        tension: 0.3,
        pointRadius: 4,
        pointHoverRadius: 6,
        pointBackgroundColor: "#10b981",
        fill: true,
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
          label: (context: TooltipItem<"line">) => `${context.parsed.y}건 완료`,
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
          callback: (value: number | string) => `${value}건`,
        },
        grid: {
          color: "#374151",
        },
      },
    },
  };

  return (
    <div className="w-full bg-neutral-800 p-6 rounded-xl shadow-md">
      <h3 className="text-base font-semibold text-white mb-4">
        📊 일자별 완료된 거래 수
      </h3>
      <div className="relative max-h-[300px]">
        {loading ? (
          <p className="text-white">로딩 중...</p>
        ) : (
          <Line data={chartData} options={options} />
        )}
      </div>
    </div>
  );
};
