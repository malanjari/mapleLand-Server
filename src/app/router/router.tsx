// src/app/router/router.tsx

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import AppLayout from "@/shared/ui/layouts/AppLayout";
import Home from "@/page/Home";
const router = createBrowserRouter([
  {
    path: "/",
    element: <AppLayout />,
    children: [{ index: true, element: <Home /> }],
  },
]);

const AppRouter = () => {
  return <RouterProvider router={router} />;
};

export default AppRouter;
