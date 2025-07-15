import { createRoot } from "react-dom/client";
import "./index.css";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

import AppRouter from "./app/router/router";

const queryClient = new QueryClient();
import {
  victoria,
  minarForest,
  elnath,
  ludusLake,
  aquaRoad,
} from "@/shared/assets/world";

[victoria, minarForest, elnath, ludusLake, aquaRoad].forEach((src) => {
  const img = new Image();
  img.src = src;
});
createRoot(document.getElementById("root")!).render(
  <QueryClientProvider client={queryClient}>
    <AppRouter />
  </QueryClientProvider>
);
