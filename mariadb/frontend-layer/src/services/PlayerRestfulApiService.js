import axios from 'axios'
import restful from '../../restful-config'

class PlayerRestfulApiService {

    create(data) {
        return restful.post('/players', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/players');
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

export default new PlayerRestfulApiService();
