<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col"></div>
      <div class="col-sm-12 col-md-10">
        <div class="row">
          <div class="header">
            <header class="articleHeader" id="articleHeader">{{ header }}</header>
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
            <a
              :href="jumpingTarget"
              @click="jumpingTo(index)"
              style="text-decoration: none"
              v-for="(item, index) in paragraphs"
              :key="item"
            >
              <li class="nav-list">
                {{ (item.subHeader || "").substring(0, 6) + "..." }}
              </li>
            </a>
          </div>
        </ul>
      </div>

      <div class="col-sm-10 col-md-8">
        <section class="introduction">
          <div class="format">
            <article class="articleBody" v-for="(item, index) in paragraphs" :key="item">
              <h1 class="subheader" :id="index">{{ item.subHeader }}</h1>
              {{ item.content }}
            </article>
          </div>
        </section>

        <!-- questions -->
        <div class="row articleBody">
          <div class="col-sm-10 col-md-10">
            <h1 class="subheader">Exercise</h1>
            <ol>
              <li v-for="(item, index) in questions" :key="item" :id="currentQuestion">
                <p>{{ item.description }}</p>
                <form>
                  <input
                    type="radio"
                    name="fav_language"
                    @click="checkAnswer('A', item.answer, index)"
                  />
                  <label class="option">A</label>
                  <input
                    type="radio"
                    name="fav_language"
                    @click="checkAnswer('B', item.answer, index)"
                  />
                  <label class="option">B</label>
                  <input
                    type="radio"
                    name="fav_language"
                    @click="checkAnswer('C', item.answer, index)"
                  />
                  <label class="option">C</label>
                  <input
                    type="radio"
                    name="fav_language"
                    @click="checkAnswer('D', item.answer, index)"
                  />
                  <label class="option">D</label>
                  <label class="option" v-show="currentQuestion === index">
                    {{ indicator }}
                  </label>
                  <button type="button" class="showAnswer" @click="toggleAnswer">
                    Show answer & explaination
                  </button>
                </form>
                <p v-if="showAnswer && currentQuestion === index">
                  {{ item.explaination }}
                </p>
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
          <div class="discussionContent" v-for="(item, index) in comments" :key="item">
            <label> {{ commentMakerNames[index] }}: </label>
            {{ item.message }}
          </div>
          <input
            class="discussionContent"
            placeholder="Leave your comments here: "
            v-model="submitComment"
            @keyup.enter="commitComment"
          />
        </section>
      </div>
      <div class="col"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ArticleDisplay",
  props: ["articleToDisplay"],
  data() {
    return {
      showAnswer: false,
      articleId: null,
      header: "",
      paragraphs: [],
      questions: [],
      comments: [],
      commentMakerIds: [],
      commentMakerNames: [],
      jumpingTarget: "",
      indicator: "",
      currentQuestion: null,
      submitComment: "",
    };
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
      // console.log(this.articleId);
      this.fetchArticle();
      this.fetchCommentMakerId();
      // this.getCommentMaker();
    },
    async fetchArticle() {
      await axios
        .get("api/article/search/" + this.articleId)
        .then((response) => {
          // console.log(response);
          this.header = response.data.data.header;
          this.paragraphs = response.data.data.paragraphs;
          this.questions = response.data.data.questions;
          this.comments = response.data.data.comments;
          // console.log(this.header);
          // console.log(this.paragraphs);
          // console.log(this.questions);
          // console.log(this.comments);
        })
        .catch((error) => {
          alert(error);
        });
    },
    async fetchCommentMakerId() {
      await axios
        .get("api/article/getCommentMaker/" + this.articleId)
        .then((response) => {
          // console.log(response);
          this.commentMakerIds = response.data.data;
          // console.log(self.commentMakerIds);
          this.getCommentMaker(this.commentMakerIds);
        })
        .catch((error) => {
          alert.error(error);
        });
    },
    async getCommentMaker(ids) {
      // console.log(ids);
      await axios
        .post("api/user/getNames", {
          userIds: ids,
        })
        .then((response) => {
          // console.log(response);
          this.commentMakerNames = response.data.data;
          // console.log(this.commentMakerNames)
        })
        .catch((error) => {
          alert(error);
        });
    },
    jumpingTo(index) {
      this.jumpingTarget = "#";
      this.jumpingTarget += index;
      // console.log(this.jumpingTarget)
    },
    checkAnswer(pickedAnswer, answer, index) {
      // console.log(pickedAnswer);
      // console.log(answer)
      this.currentQuestion = index;
      this.showAnswer = false;
      // this.questionId = "#Q";
      // this.questionId += index;
      // console.log(this.questionId);
      if (pickedAnswer === answer) {
        // console.log(true);
        this.indicator = "Correct!";
      } else {
        this.indicator = "Wrong!";
      }
    },
    async commitComment() {
      if (this.submitComment !== "" && this.submitComment.trim().length !== 0) {
        await axios
          .post("api/article/addComment", {
            userId: 1,
            articleId: this.articleId,
            message: this.submitComment,
          })
          .then((response) => {
            console.log(response);
            if (response.data.message === "succeed") {
              alert("Thanks for comments!");
            }
          })
          .catch((error) => {
            alert(error);
          });
      } else {
        alert("Comments can not be empty!");
      }
    },
  },
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
  /* margin: auto; */
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
  padding-left: 5px;
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
  padding-left: 0.3rem;
}

.breakLine {
  width: 100%;
  border: #303137;
}

.discussionContent {
  width: 100%;
  padding-left: 0.3rem;
  border-top: 2px solid #303137;
}
</style>
