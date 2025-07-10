import { createRoot } from "react-dom/client";
import "./index.css";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

import AppRouter from "./app/router/router";

const queryClient = new QueryClient();

createRoot(document.getElementById("root")!).render(
  <QueryClientProvider client={queryClient}>
    <AppRouter /> {/* ✅ 여기 App이 아니라 AppRouter */}
  </QueryClientProvider>
);
