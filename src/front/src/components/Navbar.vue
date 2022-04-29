<template>
  <v-app-bar dense app>
    <v-app-bar-nav-icon disabled>
      <img src="@/assets/electronic_university_logo.png" alt="" width="32">
    </v-app-bar-nav-icon>
    <v-app-bar-title>
      <h3 class="text-h5 mr-2">Electronic University</h3>
    </v-app-bar-title>
    <v-btn plain @click="routeToHomeView">Home</v-btn>
    <v-btn plain @click="routeToUsersView">Users</v-btn>

    <v-spacer></v-spacer>

    <v-btn v-if="authUsername" plain>{{ authUsername }}</v-btn>
    <v-btn v-if="!authUsername" plain @click="loginDialogOpen = !loginDialogOpen">
      Login
    </v-btn>
    <v-btn v-else icon @click="logout">
      <v-icon>mdi-logout</v-icon>
    </v-btn>

    <LoginDialog
        :login-dialog-open="loginDialogOpen"
        @closeDialog="closeLoginDialog($event)"
    ></LoginDialog>

  </v-app-bar>
</template>

<script>
import axios from "axios";
import store from "@/store";
import LoginDialog from "@/components/LoginDialog";

export default {
  name: "Navbar",
  components: {
    LoginDialog
  },
  data() {
    return {
      loginDialogOpen: false,
    }
  },
  computed: {
    authUsername() {
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
      if (this.$router.currentRoute.path !== path) {
        this.$router.push(path)
      }
    },
    routeToUsersView() {
      const path = '/users'
      if (this.$router.currentRoute.path !== path) {
        this.$router.push(path)
      }
    },
    closeLoginDialog(event) {
      this.loginDialogOpen = event

    },
    logout() {
      axios.get('/logout')
          .then(res => {
            if (res.status === 200) {
              store.dispatch('users/getUserAuthProfileAction')
            }
          })
          .catch(e => console.log(e));
    },
  }
}
</script>

<style scoped>

</style>