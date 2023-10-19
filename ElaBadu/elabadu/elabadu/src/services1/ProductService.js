import axios from 'axios'

const BASE_REST_API_URL = 'http://localhost:8081/api/v1/products';
class ProductService {

    createProduct(product) {
        return axios.post(BASE_REST_API_URL+"/createProduct" , product);
    }

    getAllProduct() {
        return axios.get(BASE_REST_API_URL+"/getAllProducts" );
    }

    getProductById(id) {
        return axios.get(BASE_REST_API_URL + "/" + id);
    }

    deleteProduct(id) {
        return axios.delete(BASE_REST_API_URL + "/deletes" + id);
    }
    

    updateProduct(id, product) {
        return axios.put(BASE_REST_API_URL + "/updates/" + id, product);
    }

   
}
export default new ProductService();