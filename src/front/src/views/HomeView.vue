<template>
  <div class="home">
    <img alt="Electronic University logo" width="150" src="../assets/electronic_university_logo.png">

    <div><p>{{ userProfile }}</p></div>
    <div><a href="/login">Login</a></div>
    <div><a href="/registration">Register</a></div>
    <div><a href="/logout">Logout</a></div>
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  data() {
    return {
      userProfile: '',
    }
  }
}
</script>
