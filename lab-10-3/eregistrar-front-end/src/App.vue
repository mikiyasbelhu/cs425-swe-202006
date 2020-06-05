<template>
  <v-app id="app">
    <v-progress-linear 
      v-if="showNetworkProgressBar"
      :indeterminate="true" 
      height="4"
      color="accent"
      style="margin:0; top:0; position:fixed; z-index:999999;"/>
    <notifications :overlap="true"/>
    <modals-container/>
    <router-view/>
  </v-app>
</template>
<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters("core", ["showNetworkProgressBar"])
  },
  methods: {}
};
</script>


<style lang="scss">
#app {
  font-family: "Noto Sans Ethiopic", "Roboto", "Noto Sans", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.headline {
  font-family: "Noto Sans Ethiopic" !important;
  font-weight: bold !important;
}

::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  border-radius: 6px;
  background-color: #f5f5f5;
}

::-webkit-scrollbar {
  width: 8px;
  background-color: #f5f5f5;
}

::-webkit-scrollbar-thumb {
  border-radius: 10px;
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #9a9a9a;
}

.notifications.vue-notifyjs > span > div > span > span > b {
  font-size: 0.8em;
}

// form input
.theme--light .v-text-field--outline .v-input__slot {
  border: 1px solid #adadad;
}
.theme--light
  .v-text-field--outline:not(.v-input--is-focused)
  .v-input__slot:hover {
  border: 1px solid rgba(0, 0, 0, 0.87);
}

.label-text {
  color: #a7a1a1;
}

/*
  This is a workaround for an issue occuring related to modals. When a modal
  is shown if its height is 'auto' with scrollable 'true', and a pivotY
  value is provided, the correct pivotY value effect occurs only when
  the modal is clicked once.
  So as a workaround, we always set pivotY value to 0 and here we set (force)
  the distance between the top of the window and the modal.
*/
.v--modal-box.v--modal {
  top: 50px !important;
}

// to decrease the right padding of toolbar on modals, for the (x) button
.modal-toolbar .v-toolbar__content {
  padding-right: 14px !important;
}
</style>
