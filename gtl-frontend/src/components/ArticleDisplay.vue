<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col"></div>
      <div class="col-sm-12 col-md-10">
        <div class="row">
          <div class="header">
            <header class="articleHeader">Explaination of Set</header>
          </div>
        </div>
      </div>
      <div class="col"></div>
    </div>

    <div class="row">
      <div class="col-md-4 navList">
        <ul class="navbar-vertical">
          <div class="nav-wrapper">
            <a href="#articleHeader" style="text-decoration: none">
              <li class="overview">Overview</li>
            </a>
            <a href="#subheader" style="text-decoration: none">
              <li class="nav-list">section1</li>
            </a>
            <a href="#subheader1" style="text-decoration: none">
              <li class="nav-list">section2</li>
            </a>
            <a href="#subheader2" style="text-decoration: none">
              <li class="nav-list">section3</li>
            </a>
          </div>
        </ul>
      </div>

      <div class="col-sm-10 col-md-8">
        <section class="introduction">
          <div class="format">
            <article class="articleBody">
              <h1 class="subheader" id="subheader">SubHeader</h1>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
              ante sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida
              nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras
              sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.
            </article>
            <article class="articleBody">
              <h1 class="subheader" id="subheader1">SubHeader</h1>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
              ante sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida
              nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras
              sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.
            </article>
            <article class="articleBody">
              <h1 class="subheader" id="subheader2">SubHeader</h1>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
              ante sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida
              nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras
              sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.Cras sit amet
              nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
              sollicitudin. Cras purus odio.Cras sit amet nibh libero, in gravida nulla.
              Nulla vel metus scelerisque ante sollicitudin. Cras purus odio.
            </article>
          </div>
        </section>

        <!-- questions -->
        <div class="row articleBody">
          <div class="col-sm-10 col-md-8">
            <h1 class="subheader">Exercise</h1>
            <ol>
              <li>
                <p>Choose your favorite Web language:</p>
                <form>
                    <input type="radio" name="fav_language" value="A" /> <label class="option" for="A">A</label>
                    <input type="radio" name="fav_language" value="B" /> <label class="option" for="B">B</label>
                    <input type="radio" name="fav_language" value="C" /> <label class="option" for="C">C</label>
                    <input type="radio" name="fav_language" value="D" /> <label class="option" for="D">D</label>
                    <button type="button" class="showAnswer" @click="toggleAnswer">Show answer & explaination</button>
                </form>
                <p v-if="showAnswer"> explaination here </p>
              </li>
              <li>
                <p>Choose your favorite Web language:</p>
                <form>
                    <input type="radio" name="fav_language" value="A" /> <label class="option" for="A">A</label>
                    <input type="radio" name="fav_language" value="B" /> <label class="option" for="B">B</label>
                    <input type="radio" name="fav_language" value="C" /> <label class="option" for="C">C</label>
                    <input type="radio" name="fav_language" value="D" /> <label class="option" for="D">D</label>
                    <button type="button" class="showAnswer" @click="toggleAnswer">Show answer & explaination</button>
                </form>
                <p v-if="showAnswer"> explaination here </p>
              </li>
            </ol>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col"></div>
      <div class="col-sm-10 col-md-8">
        <section class="discussion">
          <div class="discussionTitle">Discussions:</div>
          <div class="breakLine"></div>
          <div class="discussionContent">1111</div>
          <div class="discussionContent">1111</div>
          <input class="discussionContent" placeholder="Leave your comments here: " />
        </section>
      </div>
      <div class="col"></div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "ArticleDisplay",
  props: ['articleToDisplay'],
  data() {
    return {
      showAnswer: false,
      articleId: null,
      header: "",
      paragraphs: [],
      questions: [],
      comments: [],
    }
  },
  created() {
    this.init();
  },
  methods: {
    toggleAnswer() {
      this.showAnswer = true;
    },
    init() {
      this.articleId = this.articleToDisplay;
      console.log(this.articleId);
      this.fetchArticle();
    },
    fetchArticle() {
      axios.get("api/article/search/" + this.articleId)
      .then(response => {
        // console.log(response);
        this.header = response.data.data.header;
        this.paragraphs = response.data.data.paragraphs;
        this.questions = response.data.data.questions;
        this.comments = response.data.data.comments;
        console.log(this.header);
        console.log(this.paragraphs);
        console.log(this.questions);
        console.log(this.comments);
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
.articleHeader {
  font-size: 2rem;
  text-align: center;
  margin: 2rem 1rem;
  padding: 10px 0;
}

.navbar-vertical {
  display: flex;
  padding: 10px 10px 20px 10px;
  margin: auto;
  flex-direction: column;
  align-items: center;
  list-style-type: circle;
  list-style-position: inside;
  width: 300px;
  position: sticky;
  top: 3rem;
  z-index: 100;
}

.nav-wrapper {
  width: 100%;
  border: 2px solid rgba(44, 44, 46, 0.5);
  border-radius: 10px;
  background-color: rgba(171, 171, 238, 0.5);
  box-shadow: 0 0 0px 3px rgba(59, 59, 65, 0.1);
}

.nav-wrapper:hover {
  box-shadow: 0 0 5px 5px rgba(59, 59, 65, 0.3);
  transition: 0.2s ease-in-out;
}

.nav-list {
  padding: 5px 5rem;
  width: 100%;
  color: #303137;
}

.nav-list:hover {
  transform: scale(1.1);
  transition: 0.2s ease-in-out;
}

.overview {
  list-style-type: none;
  background-color: #303137;
  color: #ffffff;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
  padding: 5px 6rem;
  width: 100%;
}

.articleBody {
  width: 100%;
  padding: 0 2rem 1rem 1rem;
  text-align: justify;
  line-height: 2rem;
  font-size: 1.1rem;
}

.subheader {
  font-size: 1.5rem;
  text-decoration: underline;
}

.option {
  padding-right: 2rem;
}

.showAnswer {
  padding: 5px;
  border-radius: 10px;
}

.showAnswer:active {
    box-shadow: 0 0 0 0.1rem rgba(0, 0, 0, 0.5);
}

.discussion {
  width: auto;
  margin: 3rem;
  border: 2px dashed #303137;
  background-color: rgba(255, 255, 255, 0.3);
  border-radius: 5px;
}

.discussionTitle {
  font-size: 1.2rem;
}

.breakLine {
  width: 100%;
  border: #303137;
}

.discussionContent {
  width: 100%;
  padding: auto;
  border-top: 2px solid #303137;
}
</style>
