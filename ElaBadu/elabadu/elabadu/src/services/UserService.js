import axios from 'axios'

const USER_BASE_REST_API_URL = 'http://localhost:8083/api/v1/users';
class UserService {

    saveUser(user) {
        return axios.post(USER_BASE_REST_API_URL + "/save", user)
    }

    getAllUser() {
        return axios.get(USER_BASE_REST_API_URL + "/getAll");
    }

    getUserById(id) {
        return axios.get(USER_BASE_REST_API_URL + "/" + id);
    }

    getUserByEmail(email) {
        return axios.get(USER_BASE_REST_API_URL + "/getUser" + email);
    }

    deleteUser(id) {
        return axios.delete(USER_BASE_REST_API_URL + "/delete/" + id);
    }

    updateUser(id, user) {
        return axios.put(USER_BASE_REST_API_URL + "/update/" + id, user);
    }
}
export default new UserService();