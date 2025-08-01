import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { lazy, Suspense } from "react";

import AppLayout from "@/shared/ui/layouts/AppLayout";
import { RequireAuth } from "../guard/RequireAuth";
import { RequireAdmin } from "../guard/RequireAdmin";
import { Spinner } from "@/shared/ui/spinner/Spinner";

// Lazy imports
const Home = lazy(() => import("@/page/Home"));
const NotFound = lazy(() => import("@/page/NotFound"));
const OAuthSuccessPage = lazy(() => import("@/page/oauth/OAuthSuccess"));
const OAuthBannedPage = lazy(() => import("@/page/oauth/OAuthBanned"));
const ProfilePage = lazy(() => import("@/page/Profile"));
const NotificationGuide = lazy(() => import("@/page/notice/NotificationGuide"));
const Notice = lazy(() => import("@/page/notice/Notice"));
const Event = lazy(() => import("@/page/notice/Event"));

// 자리 관련
const JariDetailPage = lazy(() => import("@/page/jari/Detail"));
const JariRegisterPage = lazy(() => import("@/page/jari/Register"));
const JariRegisterDetailPage = lazy(() => import("@/page/jari/RegisterDetail"));
const WorldDetailPage = lazy(() => import("@/page/jari/WorldDetail"));

// 관리자 관련
const AdminDashboardPage = lazy(() => import("@/page/admin/Dashboard"));
const AllUsersPage = lazy(() => import("@/page/admin/AllUsers"));
const UserStatsPage = lazy(() => import("@/page/admin/UserStatsPage"));
const ReportPage = lazy(() => import("@/page/admin/Report"));
const ReportDetailPage = lazy(() => import("@/page/admin/ReportDetail"));
const UserReportsPage = lazy(() => import("@/page/admin/UserReports"));

const router = createBrowserRouter([
  {
    path: "/",
    element: <AppLayout />,
    children: [
      { index: true, element: <Home /> },

      // 🪑 자리 관련
      {
        path: "jari",
        children: [
          { path: ":name", element: <JariDetailPage /> },
          { path: "world/:world", element: <WorldDetailPage /> },
          {
            path: "register",
            element: (
              <RequireAuth>
                <JariRegisterPage />
              </RequireAuth>
            ),
          },
          {
            path: "register/:name",
            element: (
              <RequireAuth>
                <JariRegisterDetailPage />
              </RequireAuth>
            ),
          },
        ],
      },

      // 👤 유저 관련
      { path: "profile/:userId", element: <ProfilePage /> },

      // 📢 공지/가이드
      { path: "notification-guide", element: <NotificationGuide /> },
      { path: "notice", element: <Notice /> },
      { path: "event", element: <Event /> },

      // 🔐 OAuth 관련
      { path: "oauth2/success", element: <OAuthSuccessPage /> },
      { path: "oauth/banned", element: <OAuthBannedPage /> },

      // 🔧 관리자 페이지
      {
        path: "admin",
        children: [
          {
            index: true,
            element: (
              <RequireAdmin>
                <AdminDashboardPage />
              </RequireAdmin>
            ),
          },
          {
            path: "users",
            element: (
              <RequireAdmin>
                <AllUsersPage />
              </RequireAdmin>
            ),
          },
          {
            path: "signupcount",
            element: (
              <RequireAdmin>
                <UserStatsPage />
              </RequireAdmin>
            ),
          },
          {
            path: "reports",
            element: (
              <RequireAdmin>
                <ReportPage />
              </RequireAdmin>
            ),
          },

          {
            path: "reports/:userMapId",
            element: (
              <RequireAdmin>
                <ReportDetailPage />
              </RequireAdmin>
            ),
          },
          {
            path: "user-reports",
            element: (
              <RequireAdmin>
                <UserReportsPage />
              </RequireAdmin>
            ),
          },
        ],
      },
    ],
  },
  { path: "*", element: <NotFound /> },
]);

const AppRouter = () => (
  <Suspense fallback={<Spinner />}>
    <RouterProvider router={router} />
  </Suspense>
);

export default AppRouter;
