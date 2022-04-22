<template>
  <div class="controller">
    <div v-if="home || aboutUs">
      <MainPage />
    </div>

    <div v-if="explorer">
      <ContentExplorer />
    </div>



  </div>
</template>

<script>
import MainPage from "./MainPage";
import ContentExplorer from "./ContentExplorer.vue";

export default {
  name: "PageController",
  components: {
    MainPage,
    ContentExplorer,
  },
  props: ["home", "explorer", "aboutUs"],
};
</script>

<style scoped></style>
