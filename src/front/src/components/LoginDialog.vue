<template>
  <v-dialog
      persistent
      v-model="loginDialogOpen"
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
            label="Login"
            v-model="loginUsername"
        ></v-text-field>
        <v-text-field
            class="px-3"
            label="Password"
            v-model="loginPassword"
        ></v-text-field>
        <v-row>
          <v-spacer></v-spacer>
          <v-col class="flex-grow-0 px-0 mx-0">
            <v-btn
                text
                color="primary"
                @click="cancel"
            >
              Cancel
            </v-btn>
          </v-col>
          <v-col class="flex-grow-0 pl-0">
            <v-btn
                text
                color="primary"
                @click="submit"
            >
              Login
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-dialog>
</template>

<script>
import axios from "axios";
import store from "@/store";

export default {
  name: "LoginDialog",
  props: ['loginDialogOpen'],
  data() {
    return {
      loginUsername: '',
      loginPassword: ''
    }
  },
  methods: {
    submit() {
      const params = new URLSearchParams();
      params.append('username', this.loginUsername);
      params.append('password', this.loginPassword);
      axios.post('/authenticate', params)
          .then(res => {
            if (res.status === 200) {
              store.dispatch('users/getUserAuthProfileAction')
            }
          })
          .catch(e => console.log(e))
      this.loginUsername = ''
      this.loginPassword = ''
      this.$emit('closeDialog', false)
    },
    cancel() {
      this.loginUsername = ''
      this.loginPassword = ''
      this.$emit('closeDialog', false)
    }
  }
}
</script>

<style scoped>
v-card {

}
</style>