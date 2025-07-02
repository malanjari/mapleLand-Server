// src/app/router/router.tsx

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import AppLayout from "@/shared/ui/layouts/AppLayout";
import Home from "@/page/Home";
import NotFound from "@/page/NotFound";
import JariDetail from "@/page/JariDetail";
import OAuthSuccessPage from "@/page/OAuthSuccess";
import JariRegisterPage from "@/page/JariRegister";
import JariRegisterDetailPage from "@/page/JariRegisterDetail";
import { RequireAuth } from "../guard/RequireAuth";

const router = createBrowserRouter([
  {
    path: "/",
    element: <AppLayout />,
    children: [
      { index: true, element: <Home /> },
      { path: "jari/:name", element: <JariDetail /> },
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
      { path: "oauth2/success", element: <OAuthSuccessPage /> },
    ],
  },
  {
    path: "*",
    element: <NotFound />,
  },
]);

const AppRouter = () => {
  return <RouterProvider router={router} />;
};

export default AppRouter;
