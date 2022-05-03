<template>
    <MainView />
</template>

<script>
import MainView from './views/MainView.vue'
import '@/composables/Scroller'

export default {
  name: "App",
  components: {
    MainView,
  },
};
</script>

<style></style>
