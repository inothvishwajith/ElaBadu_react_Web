import axios from 'axios'

const USER_BASE_REST_API_URL = 'http://localhost:8082/api/v1/orders';
class OrderService {
    saveOrder(order) {
        return axios.post(USER_BASE_REST_API_URL + "/save", order)
    }

    getOrdersForCustomer(customerId) {
        return axios.get(USER_BASE_REST_API_URL + "/getAllOrders" + customerId)
    }

    getOrderDetailsForOrder(orderId) {
        return axios.get(USER_BASE_REST_API_URL + "/getOrderDetails" + orderId)
    }
    // getAllUser() {
    //     return axios.get(USER_BASE_REST_API_URL + "/");
    // }

    // getUserById(id) {
    //     return axios.get(USER_BASE_REST_API_URL + "/" + id);
    // }

    // getUserByEmail(email) {
    //     return axios.get(USER_BASE_REST_API_URL + "/getUser" + email);
    // }

    // deleteUser(id) {
    //     return axios.delete(USER_BASE_REST_API_URL + "/delete/" + id);
    // }

    // updateUser(id, user) {
    //     return axios.put(USER_BASE_REST_API_URL + "/update/" + id, user);
    // }
}
export default new OrderService();