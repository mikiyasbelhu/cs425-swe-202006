import axios from "axios";
import axiosRetry from "axios-retry";

import NetworkErrorAlert from "@/components/NetworkErrorAlert.vue";
import InternalErrorAlert from "@/components/InternalErrorAlert.vue";
import app from "../main";

const Request = axios.create();

axiosRetry(Request, { retries: 3 });

/**
 * Request interceptor
 */
Request.interceptors.request.use(config => {
  app.$store.commit("core/addPendingRequest");
  return config;
});

/**
 * Response interceptor
 */
Request.interceptors.response.use(
  response => {
    app.$store.commit("core/removePendingRequest");
    return response.data;
  },
  err => {
    app.$store.commit("core/removePendingRequest");
    if (!err || !err.response || !err.response.status) {
      app.$notify({
        type: "danger",
        component: NetworkErrorAlert,
        horizontalAlign: "right",
        verticalAlign: "top"
      });
      throw err;
    }
    const { status } = err.response;
    if (status >= 500 && status <= 550) {
      app.$notify({
        type: "danger",
        component: InternalErrorAlert
      });
      throw new Error("Unknown Error");
    }
    throw err.response.data.error;
  }
);

export default Request;
