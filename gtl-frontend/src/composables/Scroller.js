import { StorageSerializers, useStorage } from '@vueuse/core';

const scrollpos = useStorage("scrollpos", 0, sessionStorage, {
    serializer: StorageSerializers.number
})

document.addEventListener("DOMContentLoaded", function (event) {
    if (scrollpos.value !== 0) {
        window.scrollTo(0, scrollpos.value);
    }
});

window.onbeforeunload = function (e) {
    scrollpos.value = window.scrollY;
};