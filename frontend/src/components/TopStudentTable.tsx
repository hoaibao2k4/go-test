import Paper from "@mui/material/Paper";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import type { TopStudentResponse } from "../types";

interface TopStudentTableProps {
  readonly rows: TopStudentResponse[];
}

export default function TopStudentTable({ rows }: TopStudentTableProps) {
  const round = (value: number | null | undefined) => {
    if (value === null || value === undefined) return "-";
    return value.toFixed(2);
  };

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Registration Number</TableCell>
            <TableCell align="right">Math</TableCell>
            <TableCell align="right">Physics</TableCell>
            <TableCell align="right">Chemistry</TableCell>
            <TableCell align="right">Total Score</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow
              key={row.sbd}
              sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {row.sbd}
              </TableCell>
              <TableCell align="right">{round(row.toan)}</TableCell>
              <TableCell align="right">{round(row.vatLi)}</TableCell>
              <TableCell align="right">{round(row.hoaHoc)}</TableCell>
              <TableCell align="right">{round(row.totalScore)}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
