<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link>
      |
      <router-link to="/about">About</router-link>
      <router-link v-if="isAdmin" to="/users">| Users</router-link>
    </nav>
    <p>Auth user: {{ username }}</p>
    <router-view/>
  </div>
</template>

<script>
import store from "@/store";
import {mapActions, mapState} from 'vuex';

export default {
  name: 'App',
  data() {
    return {
      ...mapState(['users/userAuthProfile']),
    };
  },
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
    ...mapActions(['users/getUserAuthProfileAction']),
  },
  created() {
    store.dispatch('users/getUserAuthProfileAction')
  }
}
</script>
