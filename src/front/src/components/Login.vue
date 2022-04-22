<template>
  <div>
    <div><p>{{ userProfile }}</p></div>
    <div><a href="/login">Login</a></div>
    <div><button type="button" @click="getUserProfile()">getUserProfile</button></div>
  </div>
</template>

<script>
// import {serverUrl} from "../main";

export default {
  name: "Login",
  data() {
    return {
      loginUrl: "/login",
      loginMessage: "вход",
      isVisible: false,
      userProfile: ""
    }
  },
  created() {
    this.axios.get('/users/auth')
        .then((response) => {this.userProfile = response.data.username});
  }
}
</script>

<style scoped>

</style>