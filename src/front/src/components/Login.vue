<template>
  <div>
    <div>
      <p>{{ userProfile }}</p>
      <button type="button" @click="getUserProfile()">getUserProfile</button>
    </div>
  </div>
</template>

<script>

export default {
  name: "Login",
  data() {
    return {
      loginMessage: "вход",
      isVisible: false,
      userProfile: ""
    }
  },
  methods: {
    getUserProfile() {
      this.axios.get('localhost:8888/user/auth')
          .then((response) => {this.userProfile = response});
    }
  }
}
</script>

<style scoped>

</style>