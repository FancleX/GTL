<template>
  <div class="container-fluid">
    <BasePage />
  </div>
</template>

<script>
import BasePage from "./components/BasePage.vue";

export default {
  name: "App",
  components: {
    BasePage,
  },
};
</script>

<style>
.container-fluid {
  padding: 0;
}
</style>
