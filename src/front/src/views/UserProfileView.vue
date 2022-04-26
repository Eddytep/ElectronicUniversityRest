<template>
  <div>
    <h1>UserProfileView</h1>
    <p>User id: {{ currentUserId() }}</p>
    <p>Username: {{ getNameOfCurrentUser() }}</p>
    <p>User roles: {{ currentUser.roles }}</p>
  </div>
</template>

<script>
import store from "@/store";
// import {mapState} from "vuex"

export default {
  name: "UserProfile",
  computed: {
    currentUser() {
      return store.state.users.allUsers
          .find(user => String(user.id) === this.currentUserId())
    },
  },
  methods: {
    currentUserId() {
      return this.$route.params.id
    },
    getNameOfCurrentUser() {
      return this.currentUser.username
    },
  }
}
</script>

<style scoped>

</style>