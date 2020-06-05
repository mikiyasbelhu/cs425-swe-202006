import AppLayout from "@/modules/layout";
import NotFoundPage from "@/components/NotFoundPage.vue";

import studentRoutes from "@/modules/student/student.routes";

const routes = [
  {
    path: "/",
    redirect: "/app/students"
  },
  {
    path: "/app",
    component: AppLayout,
    children: [...studentRoutes]
  },
  {
    path: "*",
    name: "not-found",
    component: NotFoundPage
  }
];
export default routes;
