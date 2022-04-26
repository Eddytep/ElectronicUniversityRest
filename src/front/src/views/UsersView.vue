<template>
  <div>
    <h1>Users View</h1>
    <div v-for="(user, i) in allUsers" :key="i">
      <router-link :to="`/users/${user.id}`">{{user.username}}</router-link>
    </div>
  </div>
</template>

<script>
import store from "@/store";

export default {
  name: "UsersView",
  computed: {
    allUsers() {
      return store.state.users.allUsers
    },
  },
  created() {
    store.dispatch('users/getAllUsers')
  }
}
</script>

<style scoped>

</style>