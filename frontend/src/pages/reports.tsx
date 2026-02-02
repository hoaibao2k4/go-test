import { useEffect, useState } from "react";
import { getReport, getTop10GroupA } from "../api/api";
import SubjectChart from "../components/bar-chart";
import TopStudentTable from "../components/TopStudentTable";
import type { ReportResponse, TopStudentResponse } from "../types";

export default function ReportsPage() {
  const [reportData, setReportData] = useState<ReportResponse | null>(null);
  const [topStudents, setTopStudents] = useState<TopStudentResponse[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [report, top10] = await Promise.all([
          getReport(),
          getTop10GroupA(),
        ]);
        setReportData(report);
        setTopStudents(top10);
      } catch (error) {
        console.error("Failed to fetch data", error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  if (loading) {
    return <div className="p-5 text-center">Loading...</div>;
  }

  // Process data for Chart
  const subjects = [
    { key: "toan", label: "Math" },
    { key: "nguVan", label: "Literature" },
    { key: "ngoaiNgu", label: "English" },
    { key: "vatLi", label: "Physics" },
    { key: "hoaHoc", label: "Chemistry" },
    { key: "sinhHoc", label: "Biology" },
    { key: "lichSu", label: "History" },
    { key: "diaLi", label: "Geography" },
    { key: "gdcd", label: "Civic Education" },
  ] as const;

  const xAxisLabels = subjects.map((s) => s.label);

  const series = [
    {
      data: subjects.map((s) => reportData?.[s.key]?.level1 || 0),
      label: "Excellent", // >= 8
      stack: "total",
      color: "#4caf50",
    },
    {
      data: subjects.map((s) => reportData?.[s.key]?.level2 || 0),
      label: "Good", // 6 <= x < 8
      stack: "total",
      color: "#2196f3",
    },
    {
      data: subjects.map((s) => reportData?.[s.key]?.level3 || 0),
      label: "Average", // 4 <= x < 6
      stack: "total",
      color: "#ff9800",
    },
    {
      data: subjects.map((s) => reportData?.[s.key]?.level4 || 0),
      label: "Poor", // < 4
      stack: "total",
      color: "#f44336",
    },
  ];

  return (
    <div className="w-full p-5 flex flex-col gap-10">
      <h2 className="text-3xl font-bold text-center">Reports & Statistics</h2>

      <div className="flex flex-col gap-5">
        <h3 className="text-2xl font-semibold">
          Score Distribution by Subject
        </h3>
        <div className="w-full h-[450px] bg-white p-4 rounded-lg shadow">
          {reportData && (
            <SubjectChart xAxisLabels={xAxisLabels} series={series} />
          )}
        </div>
      </div>

      <div className="flex flex-col gap-5">
        <h3 className="text-2xl font-semibold">Top 10 Group A Students</h3>
        <div className="w-full bg-white p-4 rounded-lg shadow">
          <TopStudentTable rows={topStudents} />
        </div>
      </div>
    </div>
  );
}
