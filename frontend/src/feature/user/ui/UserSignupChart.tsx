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
import { getMonthlySignupStats } from "@/entity/user/api/getSignupCount";
type RawSignupData = Record<string, { createTime: string; count: number }>;
ChartJS.register(
  LineElement,
  CategoryScale,
  LinearScale,
  PointElement,
  Tooltip,
  Legend,
  Filler
);

interface SignupChartProps {
  year: number;
  month: number;
}
interface SignupStat {
  date: string;
  count: number;
}
export const SignupChart = ({ year, month }: SignupChartProps) => {
  const [data, setData] = useState<SignupStat[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const load = async () => {
      setLoading(true);
      try {
        const raw = await getMonthlySignupStats(year, month);
        const transformed = Object.values(raw as RawSignupData).map((v) => ({
          date: v.createTime,
          count: v.count,
        }));
        console.log(transformed);
        setData(transformed);
      } catch (error) {
        console.error("데이터 로딩 실패:", error);
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [year, month]); // ✅ props 의존성 설정

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
        label: "가입자 수",
        data: counts,
        borderColor: "#60a5fa",
        backgroundColor: "rgba(96, 165, 250, 0.2)",
        tension: 0.3,
        pointRadius: 4,
        pointHoverRadius: 6,
        pointBackgroundColor: "#60a5fa",
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
          label: (context: TooltipItem<"line">) => `${context.parsed.y}명 가입`,
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
          callback: (value: number | string) => `${value}명`,
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
        📈 일자별 가입자 수
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
