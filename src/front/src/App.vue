<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/electronic_university_logo.png" width="150">
    <h1>Hello!</h1>
    <div><a :href="loginPage">Login</a></div>
    <div><a :href="registrationPage">Registration</a></div>
    <div><a :href="logoutPage">Logout</a></div>
    <div>User: {{ userProfile }}</div>
  </div>
</template>

<script>
import axios from "axios";
import {serverUrl} from "./main";

export default {
  name: 'App',
  data() {
    return {
      loginPage: serverUrl + '/login',
      registrationPage: serverUrl + "/registration",
      logoutPage: serverUrl + "/logout",
      userProfile: "Guest"
    }
  },
  methods: {
    getUserProfile() {
      axios
          .get('/users/auth')
          .then(response => (this.userProfile = response.data.username))
    }
  },
  created: function () {
    this.axios
        .get('/users/auth')
        .then(response => (this.userProfile = response.data.username))
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
  margin-top: 60px;
}
</style>
