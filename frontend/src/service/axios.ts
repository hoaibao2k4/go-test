import axios from 'axios';


const instance = axios.create({
  baseURL: 'http://localhost:8080',
  headers: {'X-Custom-Header': 'foobar'}
});

instance.interceptors.response.use(
  function (instance) {
    return instance.data;
  },
  function (error) {
    if (error.response) {
      console.error('Error:', error.response.data || error.response.statusText);
    } else if (error.request) {
      console.error('No response received:', error.request);
    } else {
      console.error('Request Error:', error.message);
    }
    return Promise.reject(error);
  }
);

export { instance };