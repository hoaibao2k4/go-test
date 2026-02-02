import type {
  ReportResponse,
  ScoreResponse,
  TopStudentResponse,
} from "../types";
import { instance } from "../service/axios";

export const getScore = async (sbd: string): Promise<ScoreResponse> => {
  const response = await instance.get<ScoreResponse>(`/api/scores?sbd=${sbd}`);
  return response as unknown as ScoreResponse;
};

export const getReport = async (): Promise<ReportResponse> => {
  const response = await instance.get<ReportResponse>("/api/scores/report");
  return response as unknown as ReportResponse;
};

export const getTop10GroupA = async (): Promise<TopStudentResponse[]> => {
  const response = await instance.get<TopStudentResponse[]>(
    "/api/scores/top10-group-a",
  );
  return response as unknown as TopStudentResponse[];
};
