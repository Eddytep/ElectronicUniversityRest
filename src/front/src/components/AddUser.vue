<template>
  <v-form
      ref="form"
  >
    <v-text-field
        v-model="username"
        label="Name"
        required
    ></v-text-field>

    <v-text-field
        v-model="password"
        label="E-mail"
        required
    ></v-text-field>
  </v-form>
</template>

<script>
// import bcrypt from 'bcrypt';

export default {
  name: "AddUser",

  data:() => ({
    username: '',
    password: '',
  }),
  // methods: {
  //   encryptPassword() {
  //     const salt = bcrypt.genSaltSync(8)
  //     return bcrypt.hashSync(this.password, salt)
  //   },
  // }
}
</script>

<style scoped>

</style>