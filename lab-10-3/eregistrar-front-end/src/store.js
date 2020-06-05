/* eslint no-param-reassign:0 */

import Vue from "vue";
import Vuex from "vuex";
import theme from "@/themes/theme.store";

const core = {
  namespaced: true,
  state: {
    appName: "Eregistrar",
    version: "0.0.1",
    pendingNetworkRequest: 0
  },
  mutations: {
    addPendingRequest(state) {
      state.pendingNetworkRequest += 1;
    },
    removePendingRequest(state) {
      state.pendingNetworkRequest -= 1;
    }
  },
  getters: {
    getFullAppName: state => `${state.appName} v${state.version}`,
    getAppName: state => state.appName,
    showNetworkProgressBar: state => state.pendingNetworkRequest > 0
  }
};

const layout = {
  namespaced: true,
  state: {
    navDrawerToggle: true
  },
  getters: {},
  mutations: {
    toggleNavBar(state) {
      state.navDrawerToggle = !state.navDrawerToggle;
    }
  }
};

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    core,
    layout,
    theme
  }
});
