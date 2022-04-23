import {createStore} from 'vuex'
import axios from "axios";

export default createStore({
    state: {
        userAuthProfile: '',
        adminRole: "ADMIN"
    },
    getters: {},
    mutations: {
        getUserAuthProfileMutation(state, newUserAuthProfile) {
            state.userAuthProfile = newUserAuthProfile
        },
    },
    actions: {
        async getUserAuthProfileAction({commit}) {
            try {
                const result = await axios.get('/users/auth');
                commit('getUserAuthProfileMutation', result.data)
            } catch (error) {
                alert(error)
                console.log(error)
            }
        }
    },
    modules: {}
})
