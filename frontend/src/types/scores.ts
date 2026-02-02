export interface SubjectReport {
  level1: number; // >= 8 -> Very Good
  level2: number; // 6 <= x < 8 -> Good
  level3: number; // 4 <= x < 6 -> Average
  level4: number; // < 4 -> Poor
}

export interface ReportResponse {
  toan: SubjectReport;
  nguVan: SubjectReport;
  ngoaiNgu: SubjectReport;
  vatLi: SubjectReport;
  hoaHoc: SubjectReport;
  sinhHoc: SubjectReport;
  lichSu: SubjectReport;
  diaLi: SubjectReport;
  gdcd: SubjectReport;
}

export interface TopStudentResponse {
  sbd: string;
  toan: number;
  vatLi: number;
  hoaHoc: number;
  totalScore: number;
}

export interface ScoreResponse {
  sbd: string;
  groupType: string;
  toan: number;
  nguVan: number;
  ngoaiNgu: number;
  vatLi: number;
  hoaHoc: number;
  sinhHoc: number;
  lichSu: number;
  diaLi: number;
  gdcd: number;
}
