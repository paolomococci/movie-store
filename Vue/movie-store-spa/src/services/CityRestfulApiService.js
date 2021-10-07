import axios from 'axios'
import restful from '../../restful-config'

class CityRestfulApiService {

    create(data) {
        return restful.post('/cities', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/cities');
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

export default new CityRestfulApiService();
