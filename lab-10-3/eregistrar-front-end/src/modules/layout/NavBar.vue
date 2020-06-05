<template>
  <v-toolbar
    fixed
    app
    clipped-right
    color="navbarColor"
    dark
    height="52" 
  >
    <v-toolbar-side-icon @click="toggleNavBar()"/>
    <v-spacer/>
    <v-toolbar-title class="grey--text text--lighten-3 font-weight-bold">
      {{ appName }}
      <!-- <v-menu 
        :nudge-bottom="14" 
        offset-y 
        origin="center center" 
        class="elelvation-1" 
        transition="scale-transition">
        <v-btn 
          slot="activator" 
          icon 
          flat>
          <v-badge 
            color="primary" 
            overlap>
            <span slot="badge">3</span>
            <v-icon medium>notifications</v-icon>
          </v-badge>
        </v-btn>
      </v-menu> -->
    </v-toolbar-title>
    <v-spacer/>
    <v-toolbar-items>
      
      <v-menu 
        :close-on-content-click="false"
        :nudge-width="200"
        v-model="visible"
        offset-x>
        <v-btn
          slot="activator" 
          icon 
          dark>
          <v-icon>more_vert</v-icon>
        </v-btn>
        <v-card>
          <v-list>
            <v-list-tile 
              avatar 
              @click="$router.push({name:'user-profile'}),visible = false">
              <v-list-tile-avatar>
                <img 
                  src="@/assets/logo.png" 
                  alt="Avator">
              </v-list-tile-avatar>
              <v-list-tile-action/>
            </v-list-tile>
          </v-list>
        </v-card>
      </v-menu>
    </v-toolbar-items>
  </v-toolbar>
</template>
<script>
import { mapState, mapMutations } from "vuex";

export default {
  name: "NavBar",
  data() {
    return {
      visible: true
    };
  },
  computed: {
    ...mapState("core", ["appName"])
  },
  methods: {
    ...mapMutations("layout", ["toggleNavBar"])
  }
};
</script>
