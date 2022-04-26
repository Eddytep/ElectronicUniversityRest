import {createStore} from 'vuex'
// import axios from "axios";
import users from './modules/users'

export default createStore({
    // state: {
    //     userAuthProfile: '',
    //     users: [],
    //     adminRole: "ADMIN"
    // },
    // getters: {},
    // mutations: {
    //     getUserAuthProfileMutation(state, newUserAuthProfile) {
    //         state.userAuthProfile = newUserAuthProfile
    //     },
    // },
    // actions: {
    //     async getUserAuthProfileAction({commit}) {
    //         try {
    //             const result = await axios.get('/api/users/auth');
    //             commit('getUserAuthProfileMutation', result.data)
    //         } catch (error) {
    //             alert(error)
    //             console.log(error)
    //         }
    //     }
    // },
    modules: {
        users
    }
})
