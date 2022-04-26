import axios from "axios";

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
    getAllUsers(state, allUsers) {
        state.allUsers = allUsers
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
    async getAllUsers({commit}) {
        try {
            const result = await axios.get('/api/users/');
            commit('getAllUsers', result.data)
        } catch (error) {
            alert(error)
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