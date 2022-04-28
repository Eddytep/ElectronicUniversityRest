<template>
  <v-app-bar dense app>
    <v-app-bar-nav-icon>
      <img src="@/assets/electronic_university_logo.png" alt="" width="32">
    </v-app-bar-nav-icon>
    <v-app-bar-title>
      <h3 class="text-h5 mr-2">Electronic University</h3>
    </v-app-bar-title>
    <v-btn plain @click="routeToHomeView">Home</v-btn>
    <v-btn plain @click="routeToUsersView">Users</v-btn>

    <v-spacer></v-spacer>

    <v-btn v-if="username" plain>{{ username }}</v-btn>
    <v-btn v-if="!username" plain href="/login">
      Login
    </v-btn>
    <v-btn v-if="!username" plain href="/registration">
      Register
    </v-btn>
    <v-btn v-else icon href="/logout">
      <v-icon>mdi-logout</v-icon>
    </v-btn>

  </v-app-bar>
</template>

<script>
import store from  "@/store";

export default {
  name: "Navbar",
  computed: {
    username() {
      return store.state.users.userAuthProfile.username
    },
    isAdmin() {
      const roles = store.state.users.userAuthProfile.roles
      return !!roles && roles.includes(store.state.users.adminRole);
    },
  },
  methods: {
    routeToHomeView() {
      const path = '/'
      if (this.$router.currentRoute.path !== path){
        this.$router.push(path)
      }
    },
    routeToUsersView() {
      const path = '/users'
      if (this.$router.currentRoute.path !== path){
        this.$router.push(path)
      }
    },
  }
}
</script>

<style scoped>

</style>