<template>
  <div>
    <section class="contentList row">
      <div class="container col-sm-10 col-md-8">
        <div class="section-header">
          <h1 class="header">Featured Sections</h1>
        </div>
        <div class="content-wrapper">
          <router-link :to="{ name: 'ArticleView', params: {id: data.id} }" class="linkTag" v-for="data in dataArr" :key="data.id">
            <div class="content-object">
              <div class="content-box">
                <img :src="data.imgAddress" class="img" />
              </div>
              <h2 class="content-header">{{ data.header.substring(0, 7) + "..." }}</h2>
              <div class="content-text">{{ data.paragraph[0].content.substring(0, 40) + "..." }}</div>
            </div>
          </router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ContentExplorer",
  data() {
    return {
      articlePicked: "",
      dataArr: [],
    };
  },
  created() {
    this.fetchArticles();
  },
  methods: {
    // toggleContent(articleId) {
    //   this.goArticle = true;
    //   this.articlePicked = articleId;
    // },
    async fetchArticles() {
      await axios.get("article/preview")
      .then(response => {
        this.dataArr = response.data.data;
        // console.log(this.dataArr)
      })
      .catch(error => {
        alert(error);
      })
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
