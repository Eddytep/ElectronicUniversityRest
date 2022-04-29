<template>
  <v-container>
    <v-data-table
        :headers="getHeaders()"
        :items="allUsers"
        :search="search"
        dense
    >
      <template v-slot:top>
        <v-toolbar flat>
          <v-toolbar-title>Users</v-toolbar-title>
          <v-divider class="mx-4" inset vertical></v-divider>
          <v-btn text @click="addUserDialogOpen = !addUserDialogOpen">
            <v-icon>mdi-plus</v-icon>
            Add User
          </v-btn>
          <v-spacer></v-spacer>
          <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
          ></v-text-field>
        </v-toolbar>
      </template>
      <template v-slot:item.icon="{ item }">
        <v-icon v-if="isUserStudent(item)" small class="mr-2">mdi-school</v-icon>
        <v-icon v-else small class="mr-2">mdi-account-tie</v-icon>
      </template>
      <template v-if="isAuthUserAdmin" v-slot:item.actions="{ item }">
        <v-icon @click="routeToUserProfile(item.id)">mdi-information-variant</v-icon>
        <v-icon @click="showEditUserDialog(item)">mdi-account-edit</v-icon>
        <v-icon @click="deleteUser(item)">mdi-delete</v-icon>
      </template>
    </v-data-table>

    <AddUserDialog
        :add-user-dialog-open="addUserDialogOpen"
        @closeDialog="closeAddUserDialog($event)"
    ></AddUserDialog>

  </v-container>
</template>

<script>
import router from "@/router";
import store from "@/store";
import AddUserDialog from "@/components/AddUserDialog";

export default {
  name: "UsersView",
  components: {
    AddUserDialog
  },
  data() {
    return {
      dialog: false,
      addUserDialogOpen: false,
      search: '',
      editedUser: '',
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
    },
    isAuthUserAdmin() {
      const roles = store.state.users.userAuthProfile.roles
      return !!roles && roles.includes(store.state.users.adminRole)
    },
  },
  created() {
    store.dispatch('users/getAllUsersAction').catch(e => console.log(e))
  },
  methods: {
    routeToUserProfile(userId) {
      router.push(`/users/${userId}`)
    },
    isUserStudent(user) {
      return user.roles.includes('STUDENT')
    },
    showEditUserDialog(user) {
      this.dialog = !this.dialog;
      this.editedUser = user;
    },
    editUser(user) {

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
    closeAddUserDialog(event) {
      this.addUserDialogOpen = event
    },
  }
}
</script>

<style scoped>

</style>