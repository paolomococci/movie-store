import axios from 'axios'
import restful from '../../restful-config'

class CategoryRestfulApiService {

    create(data) {
        return restful.post('/categories', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/categories');
    }

    update(uri, data) {
        return axios.put(uri, data);
    }

    partialUpdate(uri, data) {
        return axios.patch(uri, data);
    }

    delete(uri) {
        return axios.delete(uri);
    }
}

export default new CategoryRestfulApiService();
