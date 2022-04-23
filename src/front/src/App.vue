<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
    <router-link v-if="isAdmin" to="/users" >| Users</router-link>
  </nav>
  <p>User name: {{ username }}</p>
  <router-view/>
</template>

<script>
import store from "@/store";
import {mapActions, mapState} from 'vuex';

export default {
  name: 'App',
  data() {
    return {
      ...mapState(['userAuthProfile']),
    };
  },
  computed: {
    profile() {
      return store.state.userAuthProfile;
    },
    username() {
      return store.state.userAuthProfile.username;
    },
    roles() {
      return store.state.userAuthProfile.roles;
    },
    isAdmin() {
      const roles = store.state.userAuthProfile.roles
      return !!roles && roles.includes(store.state.adminRole);
    },
  },
  methods: {
    ...mapActions(['getUserAuthProfileAction']),
  },
  created() {
    this.getUserAuthProfileAction()
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
