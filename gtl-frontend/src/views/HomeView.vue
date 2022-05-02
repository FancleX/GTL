<template>
  <div v-if="articleIds.length"> 
    <div class="mainPage-content">
    <!-- welcome introduction -->
    <div class="welcome" id="aboutUs">
      <div class="row">
        <div class="col-sm-12">
          <div class="intro intro-fluid">
            <div class="container">
              <h1 class="display-3">Welcome to Get To Learn</h1>
              <p class="lead">At here you will learn some cool stuff</p>
            </div>
          </div>
        </div>
      </div>

      <!-- carousel  -->
      <div class="row slides">
        <div class="col"></div>
        <div class="col-sm-8 col-md-6">
          <div id="content-display" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#content-display"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <button
                type="button"
                data-bs-target="#content-display"
                data-bs-slide-to="1"
                aria-label="Slide 2"
              ></button>
              <button
                type="button"
                data-bs-target="#content-display"
                data-bs-slide-to="2"
                aria-label="Slide 3"
              ></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <router-link :to="{ name: 'ArticleView', params:{ id: articleIds[0] }}">
                  <img
                    :src= "imgUrls[0]"
                    class="d-block img-fluid img-center"
                    alt="first slide"
                /></router-link>
              </div>
              <div class="carousel-item">
                <router-link :to="{ name: 'ArticleView', params:{ id: articleIds[0] }}">
                  <img
                    :src="imgUrls[0]"
                    class="d-block img-fluid img-center"
                    alt="second slide"
                /></router-link>
              </div>
              <div class="carousel-item">
                <router-link :to="{ name: 'ArticleView', params:{ id: articleIds[0] }}">
                  <img
                    :src="imgUrls[0]"
                    class="d-block img-fluid img-center"
                    alt="third slide"
                /></router-link>
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#content-display"
              data-bs-slide="prev"
            >
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#content-display"
              data-bs-slide="next"
            >
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </div>
  </div>
  <div v-else>
    <p>Loading ... </p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "HomeView",
  data() {
    return {
      articleIds: [],
      imgUrls: [],
    }
  },
  mounted() {
    this.fetchRecommendations();
  },
  methods: {
    async fetchRecommendations() {
      await axios.get("article/preview")
      .then(response => {
        let articleId;
        let url = "";
        // console.log(response);
        for (let i = 0; i < 3; i++) {
          articleId = response.data.data[i].id;
          url = response.data.data[i].imgAddress;
          // get three ids and three imgurls
          this.articleIds.push(articleId);
          this.imgUrls.push(url);
        }
        // console.log(this.articleIds);
        // console.log(this.imgUrls);
      })
      .catch(error => {
        alert(error);
      })
    },
  }
};

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.welcome {
    margin: 5rem 0;
}

.intro {
    text-align: center;
}

.slides {
    margin-top: 5rem;
}

.carousel-inner {
    border-radius: 5px;
    box-shadow: 5px 5px 5px .1rem rgba(39, 37, 37, 0.5);
    transition: 500ms;
}

.carousel-inner:hover {
    transform: scale(1.05);
    transition: 700ms;
    box-shadow: 7px 7px 7px .2rem rgba(39, 37, 37, 0.5);
}

.img-center {
    display: block;
    margin: auto; 
    width: 100%;
    height: 400px;
}
</style>

