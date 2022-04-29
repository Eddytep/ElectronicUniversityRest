<template>
  <v-app>
    <Navbar></Navbar>
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import store from "@/store";
import Navbar from "@/components/Navbar";

export default {
  name: 'App',
  components: {
    Navbar
  },
  created() {
    // store.dispatch('users/getUserAuthProfileAction')
  }
}
</script>
