import App from "@/App";
import RootLayout from "@/components/layouts/sidebar";
import NotFoundPage from "@/pages/404Page";
import DashboardPage from "@/pages/DashBoard";
import ReportsPage from "@/pages/reports";
import SearchScores from "@/pages/SearchScores";
import { createBrowserRouter } from "react-router";
export const router = createBrowserRouter([
  {
    Component: App, // root layout route
    children: [
      {
        path: "/",
        Component: RootLayout,
        children: [
          { index: true, Component: DashboardPage },
          {
            path: "/dashboard",
            Component: DashboardPage,
          },
          {
            path: "/scores",
            Component: SearchScores,
          },
                    {
            path: "/reports",
            Component: ReportsPage,
          },
        ],
      },
    ],
  },
  { path: "*", Component: NotFoundPage },
]);
