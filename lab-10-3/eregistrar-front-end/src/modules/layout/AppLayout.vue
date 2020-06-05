<template>
  <div>
    <nav-bar/>
    <side-bar/>
    <v-content>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-content>
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";
import SideBar from "./SideBar.vue";

export default {
  components: {
    NavBar,
    SideBar
  }
};
</script>
