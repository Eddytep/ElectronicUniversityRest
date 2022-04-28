import axios from "axios";
import router from "@/router";

const state = () => ({
    userAuthProfile: '',
    allUsers: [],
    adminRole: "ADMIN"
})

// getters
const getters = {}

// mutations
const mutations = {
    getUserAuthProfileMutation(state, newUserAuthProfile) {
        state.userAuthProfile = newUserAuthProfile
    },
    getAllUsersMutation(state, allUsers) {
        state.allUsers = allUsers
    },
    editUserMutation(state, editedUser) {
        const index = state.allUsers.findIndex(user => user.id === editedUser.id)
        state.allUsers = [
            ...state.allUsers.slice(0, index),
            editedUser,
            ...state.allUsers.slice(index + 1)
        ];
    },
    deleteUserMutation(state, deletedUser) {
        const index = state.allUsers.findIndex(user => user.id === deletedUser.id)
        state.allUsers = [
            ...state.allUsers.slice(0, index),
            ...state.allUsers.slice(index + 1)
        ]

    },
}

// actions
const actions = {
    async getUserAuthProfileAction({commit}) {
        try {
            const result = await axios.get('/api/users/auth');
            commit('getUserAuthProfileMutation', result.data)
        } catch (error) {
            alert(error)
            console.log(error)
        }
    },
    async getAllUsersAction({commit}) {
        try {
            const result = await axios.get('/api/users/');
            commit('getAllUsersMutation', result.data)
        } catch (error) {
            alert(error)
            console.log(error)
        }
    },
    async editUserAction({commit}, user) {
        // const userId = user.id;
        try {
            const result = await axios.patch(`/api/users/${user.id}`, user)
            commit('editUserMutation', result.data)
        } catch (error) {
            console.log(error)
        }
    },
    async deleteUserAction({commit}, user) {
        // const userId = user.id;
        try {
            const result = await axios.delete(`/api/users/${user.id}`, user)
            if (result.request.status === 200) {
                commit('deleteUserMutation', result.data)
            }
        } catch (error) {
            console.log(error)
        }
    },
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}