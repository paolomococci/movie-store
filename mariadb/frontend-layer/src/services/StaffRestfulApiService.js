import axios from 'axios'
import restful from '../../restful-config'

class StaffRestfulApiService {

    create(data) {
        return restful.post('/teams', data);
    }

    read(uri) {
        return axios.get(uri);
    }

    readAll() {
        return restful.get('/teams');
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

export default new StaffRestfulApiService();
