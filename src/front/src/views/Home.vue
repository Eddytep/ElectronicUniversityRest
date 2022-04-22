<template>
  <div class="home">
    <img alt="Vue logo" width="150" src="../assets/electronic_university_logo.png">
    <Login msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import Login from "../components/Login";

export default {
  name: 'Home',
  components: {
    Login
  }
}
</script>
