import gowl from "@/assets/g-owl.png";
import DashboardIcon from "@mui/icons-material/Dashboard";
import OutlinedFlagIcon from "@mui/icons-material/OutlinedFlag";
import ScreenSearchDesktopIcon from "@mui/icons-material/ScreenSearchDesktop";
import SettingsIcon from "@mui/icons-material/Settings";
import { type Navigation } from "@toolpad/core/AppProvider";
import { ReactRouterAppProvider } from "@toolpad/core/react-router";
import { Outlet } from "react-router";
const NAVIGATION: Navigation = [
  {
    segment: "dashboard",
    title: "Dashboard",
    icon: <DashboardIcon />,
  },
  {
    segment: "scores",
    title: "Search Scores",
    icon: <ScreenSearchDesktopIcon />,
  },
  {
    segment: "reports",
    title: "Reports",
    icon: <OutlinedFlagIcon />,
  },
  {
    segment: "settings",
    title: "Settings",
    icon: <SettingsIcon />,
  },
];

const BRANDING = {
  logo: <img src={gowl} alt="GO logo" width={50} />,
  title: "G-Scores",
  homeUrl: "/",
};

export default function App() {
  return (
    <ReactRouterAppProvider navigation={NAVIGATION} branding={BRANDING}>
      <Outlet />
    </ReactRouterAppProvider>
  );
}
