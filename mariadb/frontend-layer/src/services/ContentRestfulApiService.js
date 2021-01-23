import axios from 'axios'
import restful from '../../restful-config'

class ContentRestfulApiService {

    create(data) {
        return restful.post('/contents', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/contents');
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

export default new ContentRestfulApiService();
