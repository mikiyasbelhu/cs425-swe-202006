<template>
  <v-navigation-drawer
    :mini-variant.sync="drawerStatus"
    :mobile-break-point="250"
    :width="250"
    :style="cssProps"
    app
    class="sidebarColor"
    dark
  >
    <v-toolbar 
      height="50"
      color="navbarColor"

    >
      <v-list class="pa-0">
        <v-list-tile avatar>
          <v-list-tile-avatar>
            <img src="@/assets/logo.png" >
          </v-list-tile-avatar>
          <v-list-tile-content>
            <v-list-tile-title 
              class="navigation-toolbar-title white--text caption font-weight-bold"
            > {{ appName }} </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-toolbar>

    <v-list>
      <template
        v-for="menu in menus"
      >
        <v-list-tile 
          v-if="!menu.children"
          :key="menu.title"
          :to="{name:menu.route}" 
          ripple >
          <v-list-tile-action>
            <v-tooltip 
              slot="prepend" 
              bottom>
              <v-icon slot="activator">{{ menu.icon }}</v-icon>
              {{ menu.title }}
            </v-tooltip>
          </v-list-tile-action>
          <v-list-tile-title>{{ menu.title }}</v-list-tile-title>
        </v-list-tile>

        <v-list-group
          v-else
          :key="menu.title"
          no-action
        >
          <v-tooltip 
            slot="prependIcon" 
            bottom>
            <v-icon slot="activator">{{ menu.icon }}</v-icon>
            <span>{{ menu.title }}</span>
          </v-tooltip>
          <v-list-tile slot="activator">
            <v-list-tile-title>{{ menu.title }}</v-list-tile-title>
          </v-list-tile>
          <template v-if="!drawerStatus"> 
            <v-list-tile
              v-for="submenu in menu.children"
            
              :key="submenu.title"
              :to="{name:submenu.route}"
              ripple
            >
              <v-list-tile-action>
                <v-icon>{{ submenu.icon }}</v-icon>
              </v-list-tile-action>
              <v-list-tile-content>
                <v-list-tile-title>{{ submenu.title }}</v-list-tile-title>
              </v-list-tile-content>
            </v-list-tile>
          </template>
          

        </v-list-group>
      </template>
    </v-list>
  </v-navigation-drawer>
</template>


<script>
import { mapState } from "vuex";

export default {
  name: "SideBar",
  data() {
    return {
      admins: [["Management", "people_outline"], ["Settings", "settings"]],
      menus: [
        {
          title: "Students",
          icon: "people",
          route: "student-list"
        }
      ]
    };
  },
  computed: {
    isAdministrator() {
      return this.authenticatedProfileUserRole === "Administrator";
    },
    isCommitteeOfficer() {
      return this.authenticatedProfileUserRole === "Committee Officer";
    },
    isInsideMembers() {
      return this.authenticatedProfileUserRole === "Members";
    },
    cssProps() {
      return {
        "--secondary-color": this.$vuetify.theme.secondary
      };
    },
    ...mapState("core", ["appName"]),
    drawerStatus: {
      get() {
        return this.$store.state.layout.navDrawerToggle;
      },
      set(newValue) {
        this.$store.state.layout.navDrawerToggle = newValue;
      }
    }
  }
};
</script>
<style>
.v-list__tile--active {
  background-color: var(--secondary-color);
}
</style>
