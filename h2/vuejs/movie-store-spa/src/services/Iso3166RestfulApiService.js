import axios from 'axios'
import restful from '../../restful-config'

class Iso3166RestfulApiService {

    create(data) {
        return restful.post('/countryCodes', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/countryCodes');
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

export default new Iso3166RestfulApiService();
