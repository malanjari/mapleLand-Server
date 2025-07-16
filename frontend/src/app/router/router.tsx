import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { lazy, Suspense } from "react";

import AppLayout from "@/shared/ui/layouts/AppLayout";
import { RequireAuth } from "../guard/RequireAuth";
import { Spinner } from "@/shared/ui/spinner/Spinner";

const Home = lazy(() => import("@/page/Home"));
const NotFound = lazy(() => import("@/page/NotFound"));
const JariDetail = lazy(() => import("@/page/JariDetail"));
const OAuthSuccessPage = lazy(() => import("@/page/OAuthSuccess"));
const JariRegisterPage = lazy(() => import("@/page/JariRegister"));
const JariRegisterDetailPage = lazy(() => import("@/page/JariRegisterDetail"));
const ProfilePage = lazy(() => import("@/page/Profile"));
const WorldDetailPage = lazy(() => import("@/page/WorldDetail"));
const NotificationGuide = lazy(() => import("@/page/NotificationGuide"));
const Notice = lazy(() => import("@/page/Notice"));
const AdminDashboardPage = lazy(() => import("@/page/admin/DashboardPage"));
const router = createBrowserRouter([
  {
    path: "/",
    element: <AppLayout />,
    children: [
      { index: true, element: <Home /> },
      { path: "jari/:name", element: <JariDetail /> },
      { path: "jari/world/:world", element: <WorldDetailPage /> },
      {
        path: "profile/:userId",
        element: <ProfilePage />,
      },

      { path: "notification-guide", element: <NotificationGuide /> },
      { path: "notice", element: <Notice /> },
      {
        path: "jari/register",
        element: (
          <RequireAuth>
            <JariRegisterPage />
          </RequireAuth>
        ),
      },
      {
        path: "jari/register/:name",
        element: (
          <RequireAuth>
            <JariRegisterDetailPage />
          </RequireAuth>
        ),
      },
      { path: "admin", element: <AdminDashboardPage /> },
      { path: "oauth2/success", element: <OAuthSuccessPage /> },
    ],
  },
  { path: "*", element: <NotFound /> },
]);

const AppRouter = () => {
  return (
    <Suspense fallback={<Spinner />}>
      <RouterProvider router={router} />
    </Suspense>
  );
};

export default AppRouter;
