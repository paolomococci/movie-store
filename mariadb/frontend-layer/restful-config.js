import axios from 'axios'

export default axios.create({
    baseURL: '',
    headers: {
        "Content-Type": "application/hal+json"
    }
});
