<template>
  <div>
    <section class="contentList row" v-if="!goArticle">
      <div class="container col-sm-10 col-md-8">
        <div class="section-header">
          <h1 class="header">Featured Sections</h1>
        </div>
        <div class="content-wrapper">
          <a href="#" class="linkTag" @click="toggleContent">
            <div class="content-object">
              <div class="content-box">
                <img :src="imgSrc" class="img" />
              </div>
              <h2 class="content-header">{{ title }}</h2>
              <div class="content-text">{{ content }}</div>
            </div>
          </a>
          <div class="content-object">
            <div class="content-box"></div>
            <h2 class="content-header">Project</h2>
            <div class="content-text">
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
              ante sollicitudin. Cras purus odio.
            </div>
          </div>
          <div class="content-object">
            <div class="content-box"></div>
            <h2 class="content-header">Project</h2>
            <div class="content-text">
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
              ante sollicitudin. Cras purus odio.
            </div>
          </div>
        </div>
      </div>
    </section>

    <div class="articlePicker" v-if="goArticle">
      <ArticleDisplay />
    </div>
  </div>
</template>

<script>
import ArticleDisplay from "./ArticleDisplay.vue";

export default {
  name: "ContentExplorer",
  components: {
    ArticleDisplay,
  },
  data() {
    return {
      title: "Project",
      content:
        "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Craspurus odio.",
      imgSrc:
        "https://ichef.bbci.co.uk/news/999/cpsprodpb/15951/production/_117310488_16.jpg",
      goArticle: false,
    };
  },
  methods: {
    toggleContent() {
      this.goArticle = true;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.contentList {
  margin-bottom: 3rem;
}

.section-header {
  text-align: center;
  padding: 6rem 0 4rem;
}

.content-wrapper {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

.linkTag {
  text-decoration: none;
  color: black;
}

.content-object {
  width: 250px;
  margin: 1rem 0;
  border: 2px solid #96a2cf;
  border-radius: 7%;
  transition: 0.2s ease-in-out;
  background: rgba(66, 66, 70, 0.1);
}

.content-box {
  width: 100%;
  height: 200px;
  color: #f1f3fa;
  border-radius: 7%;
  padding: 5px 5px 0 5px;
}

.img {
  width: 100%;
  height: 100%;
  border-radius: 10px;
}

.content-object:hover {
  cursor: pointer;
  transform: scale(1.02);
  color: black;
}

.content-header {
  padding: 10px 5px 0 5px;
  text-align: center;
}

.content-text {
  padding: 2px 10px 10px 10px;
}
</style>
