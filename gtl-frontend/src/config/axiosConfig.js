import axios from "axios";

// global url 
let protocol = window.location.protocol;
let host = window.location.host;
let reg = /^localhost+/;
if (reg.test(host)) {
    axios.defaults.baseURL = 'http://localhost:5000';
} else {
    axios.defaults.baseURL = protocol + "//" + host + ":5000";
}