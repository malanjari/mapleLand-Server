import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { lazy, Suspense } from "react";

import AppLayout from "@/shared/ui/layouts/AppLayout";
import { RequireAuth } from "../guard/RequireAuth";
import { RequireAdmin } from "../guard/RequireAdmin";
import { Spinner } from "@/shared/ui/spinner/Spinner";

// Lazy imports
const Home = lazy(() => import("@/page/Home"));
const NotFound = lazy(() => import("@/page/NotFound"));
const OAuthSuccessPage = lazy(() => import("@/page/OAuthSuccess"));
const OAuthBannedPage = lazy(() => import("@/page/OAuthBanned"));
const ProfilePage = lazy(() => import("@/page/Profile"));
const NotificationGuide = lazy(() => import("@/page/NotificationGuide"));
const Notice = lazy(() => import("@/page/Notice"));

// 자리 관련
const JariDetail = lazy(() => import("@/page/JariDetail"));
const JariRegisterPage = lazy(() => import("@/page/JariRegister"));
const JariRegisterDetailPage = lazy(() => import("@/page/JariRegisterDetail"));
const WorldDetailPage = lazy(() => import("@/page/WorldDetail"));

// 관리자 관련
const AdminDashboardPage = lazy(() => import("@/page/admin/Dashboard"));
const AllUsersPage = lazy(() => import("@/page/admin/AllUsers"));
const UserSignupPage = lazy(() => import("@/page/admin/AdminUserSignup"));
const ReportPage = lazy(() => import("@/page/admin/Report"));
const ReportDetailPage = lazy(() => import("@/page/admin/ReportDetail"));

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
          { path: ":name", element: <JariDetail /> },
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
                <UserSignupPage />
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
