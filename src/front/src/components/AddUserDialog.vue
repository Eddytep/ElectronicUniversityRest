<template>
  <v-dialog
      persistent
      v-model="addUserDialogOpen"
      max-width="300px"
  >
    <v-card fluid>
      <v-container>
        <v-row>
          <v-spacer></v-spacer>
          <img
              src="@/assets/electronic_university_logo.png" alt=""
              width="100"
              class="my-4"
          >
          <v-spacer></v-spacer>
        </v-row>
        <v-text-field
            class="px-3"
            label="Username"
            v-model="username"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="First Name"
            v-model="firstName"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="Last Name"
            v-model="lastName"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="Middle Name"
            v-model="middleName"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="E-mail"
            v-model="email"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="Birthday"
            v-model="birthday"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="Password"
            v-model="password"
        ></v-text-field>
        <v-row>
          <v-spacer></v-spacer>
          <v-col class="flex-grow-0">
            <v-btn
                text
                color="primary"
                @click="submit"
            >
              Add user
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
// import axios from "axios";

export default {
  name: "AddUserDialog",
  props: ['addUserDialogOpen'],
  data() {
    return {
      username: '',
      firstName: '',
      lastName: '',
      middleName: '',
      email: '',
      birthday: '',
      password: '',
    };
  },
  methods: {
    submit() {

      this.$emit('closeDialog', false)
    },
  },
  beforeDestroy() {
    console.log('close add user dialog')
  }
}
</script>

<style scoped>

</style>