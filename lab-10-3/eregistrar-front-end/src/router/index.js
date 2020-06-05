import Vue from "vue";
import Router from "vue-router";
// import AuthService from "@/services";

import routes from "./routes";

Vue.use(Router);

const router = new Router({
  hashbang: false,
  mode: "history",
  routes
});

// router.beforeEach((to, from, next) => {
//   const authenticated = AuthService.isAuthenticated();
//   const publicRoutes = ["login", "forgot"];
//   if (!authenticated && !publicRoutes.includes(to.name)) {
//     next({ name: "login" });
//   } else if (authenticated && to.name === "login") {
//     next({ name: "person" });
//   } else {
//     next();
//   }
// });
export default router;
