import { BarChart } from "@mui/x-charts/BarChart";

interface SubjectChartProps {
  readonly xAxisLabels: string[];
  readonly series: {
    readonly data: number[];
    readonly label: string;
    readonly stack?: string;
    readonly color?: string;
  }[];
}

export default function SubjectChart({
  xAxisLabels,
  series,
}: SubjectChartProps) {
  return (
    <BarChart
      xAxis={[{ scaleType: "band", data: xAxisLabels }]}
      series={series}
      height={400}
      margin={{ top: 20, bottom: 30, left: 40, right: 10 }}
    />
  );
}
