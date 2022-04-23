<template>
  <div class="home">
    <img alt=" logo" src="../assets/logo.png">

    <div><p>{{ userProfile }}</p></div>
    <div><a href="/login">Login</a></div>
    <div><a href="/registration">Register</a></div>
  </div>
</template>

<script>

export default {
  name: 'HomeView',
  data() {
    return {
      userProfile: '',
    }
  },
  created() {
    this.axios.get('/users/auth')
        .then((response) => {this.userProfile = response.data.username});
  }
}
</script>
