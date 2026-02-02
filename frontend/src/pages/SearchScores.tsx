import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import { useState } from "react";
import { getScore } from "../api/api";
import type { ScoreResponse } from "../types";

export default function SearchScores() {
  const [sbd, setSbd] = useState("");
  const [score, setScore] = useState<ScoreResponse | null>(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleCheckScore = async () => {
    if (!sbd) return;
    setLoading(true);
    setError("");
    setScore(null);
    try {
      const data = await getScore(sbd);
      setScore(data);
    } catch (err) {
      setError("Registration number not found or an error occurred.");
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  const renderSubjectScore = (
    label: string,
    value: number | undefined | null,
  ) => {
    if (value === undefined || value === null) return null;
    const roundedValue = Number(value.toFixed(2));
    return (
      <span className="flex gap-1">
        <span className="font-bold">{label}:</span>
        <span>{roundedValue}</span>
      </span>
    );
  };

  return (
    <div className="w-full p-5">
      <div className="flex flex-col items-center justify-center gap-5">
        <h2 className="text-3xl font-bold">Check Exam Scores</h2>
        <div className="flex flex-col justify-between gap-4 items-center">
          <div className="flex gap-2 items-center">
            <h3 className="text-base">Registration Number</h3>
            <TextField
              label="Enter Registration Number"
              placeholder="Example: 02000001"
              variant="outlined"
              fullWidth
              size="small"
              value={sbd}
              onChange={(e) => setSbd(e.target.value)}
              onKeyDown={(e) => {
                if (e.key === "Enter") handleCheckScore();
              }}
            />
          </div>
          <Button
            variant="contained"
            sx={{ width: 120 }}
            onClick={handleCheckScore}
            disabled={loading}
          >
            {loading ? "Checking..." : "Check"}
          </Button>
        </div>
      </div>

      {error && <div className="text-red-500 text-center mt-4">{error}</div>}

      {score && (
        <div className="mt-8">
          <h3 className="my-3 text-xl text-center">
            Registration Number: {score.sbd}
          </h3>
          <h3 className="text-lg font-semibold mb-2 text-center">
            Detailed Scores:
          </h3>
          <div className="flex flex-wrap justify-center gap-6">
            {renderSubjectScore("Math", score.toan)}
            {renderSubjectScore("Literature", score.nguVan)}
            {renderSubjectScore("English", score.ngoaiNgu)}
            {renderSubjectScore("Physics", score.vatLi)}
            {renderSubjectScore("Chemistry", score.hoaHoc)}
            {renderSubjectScore("Biology", score.sinhHoc)}
            {renderSubjectScore("History", score.lichSu)}
            {renderSubjectScore("Geography", score.diaLi)}
            {renderSubjectScore("Civic Education", score.gdcd)}
          </div>
        </div>
      )}
    </div>
  );
}
