<template>
  <div class="controller">
    <div v-if="home || aboutUs">
      <MainPage />
    </div>

    <div v-if="explorer">
      <ContentExplorer />
    </div>

    <div v-if="login"> 
      <LoginPage @getUser="grabUserInfo($event)" />
    </div>

  </div>
</template>

<script>
import MainPage from "./MainPage";
import ContentExplorer from "./ContentExplorer.vue";
import LoginPage from "./LoginPage.vue";

export default {
  name: "PageController",
  components: {
    MainPage,
    ContentExplorer,
    LoginPage,
  },
  props: ["home", "explorer", "aboutUs", "login"],
  data() {
    return {
    }
  },
  methods: {
    grabUserInfo(id) {
      this.$emit("fetchUser", id);
      // console.log(id);
    },
  }
};
</script>

<style scoped>
.controller {
  height: 100%;
}

</style>
