import axios, { AxiosHeaders } from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:8081',
    timeout: 4000,
})

export default instance