<template>
  <div class="container-fluid">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <PageHeader />
    <MainPage />
    <PageFooter />
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
import PageHeader from "./components/PageHeader.vue";
import MainPage from "./components/MainPage.vue";
import PageFooter from "./components/PageFooter.vue";

export default {
  name: "App",
  components: {
    PageHeader,
    MainPage,
    PageFooter,
  },
};
</script>

<style>
.container-fluid {
  padding: 0;
}
</style>
