<template>
  <v-container>
    <v-data-table
        :headers="getHeaders()"
        :items="allUsers"
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Users</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-spacer></v-spacer>
        </v-toolbar>
      </template>
      <template v-slot:item.icon="{ item }">
        <v-icon v-if="isUserStudent(item)" small class="mr-2" >mdi-school</v-icon>
        <v-icon v-else small class="mr-2" >mdi-account-tie</v-icon>
      </template>
      <template v-if="isAuthUserAdmin" v-slot:item.actions="{ item }">
        <v-icon small @click="editUser(item)">mdi-pencil</v-icon>
        <v-icon small @click="deleteUser(item)">mdi-delete</v-icon>
      </template>
    </v-data-table>
  </v-container>
</template>

<script>
import router from "@/router";
import store from "@/store";

export default {
  name: "UsersView",
  data() {
    return {
      dialog: false,
      selectedItem: 1,
      headers: [
        {text: '', value: 'icon', sortable: false},
        {text: 'First Name', value: 'firstName'},
        {text: 'Last Name', value: 'lastName'},
        {text: 'Middle Name', value: 'middleName'},
        {text: 'Actions', value: 'actions', sortable: false},
      ]
    }
  },
  computed: {
    allUsers() {
      return store.state.users.allUsers.filter(user => user.username !== 'admin')
    }
  },
  created() {
    store.dispatch('users/getAllUsersAction').catch(e => console.log(e))
  },
  methods: {
    routeToUserProfile(userId) {
      router.push(`/users/${userId}`)
    },
    isAuthUserAdmin() {
      const roles = store.state.users.userAuthProfile.roles
      return !!roles && roles.includes(store.state.users.adminRole)
    },
    isUserStudent(user) {
      return user.roles.includes('STUDENT')
    },
    editUser(user) {
      store.dispatch('users/editUserAction', user)
    },
    deleteUser(user) {
      store.dispatch('users/deleteUserAction', user)
    },
    getHeaders(user) {
      if (this.isAuthUserAdmin) {
        return this.headers
      } else {
        return this.headers.slice(0, -1)
      }
    },
  }
}
</script>

<style scoped>

</style>