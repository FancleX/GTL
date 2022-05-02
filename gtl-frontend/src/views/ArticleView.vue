<template>
  <div v-if="articleId">
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
        <div class="col">
          <div v-if="userId">
            <button type="button" class="bookmarkButtion" @click="bookmark()">
              &hearts;Bookmark
            </button>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-4 navList">
          <ul class="navbar-vertical">
            <div class="nav-wrapper">
              <a style="cursor: pointer" @click="jumpingTo('articleHeader')">
                <li class="overview">Overview</li>
              </a>
              <a
                @click="jumpingTo(item.order)"
                style="cursor: pointer"
                v-for="item in paragraphs"
                :key="item"
              >
                <li class="nav-list" v-if="item.subHeader !== ''">
                  {{ item.subHeader.substring(0, 6) + "..." }}
                </li>
              </a>
            </div>
          </ul>
        </div>

        <div class="col-sm-10 col-md-8">
          <section class="introduction">
            <div class="format">
              <article
                class="articleBody"
                v-for="item in paragraphs"
                :key="item.order"
                style="white-space: break-spaces"
              >
                <!-- subheader -->
                <h1 class="subheader" :id="item.order" v-if="item.subHeader !== ''">
                  {{ item.subHeader }}
                </h1>
                <!-- body -->
                {{ item.content }}

                <!-- img -->
                <div v-if="item.imgSrcList.length !== 0">
                  <div v-for="img in item.imgSrcList" :key="img" class="articleBody">
                    <img
                      :src="getImgUrl(item.order, img.imgSrc)"
                      class=""
                      alt="paragraphImg"
                    />
                  </div>
                </div>

                <!-- questions -->
                <div class="row" v-if="item.questions.length !== 0">
                  <div class="col-sm-12 col-md-12">
                    <h1 class="subheader">Exercise</h1>
                    <ol>
                      <li v-for="problem in item.questions" :key="problem">
                        <ProblemHandle :question="problem" />
                      </li>
                    </ol>
                  </div>
                </div>
              </article>
            </div>
          </section>
        </div>
      </div>

      <!-- comments -->
      <ArticleComments
        :userComment="comments"
        :userId="userId"
        :articleId="articleId"
      />
    </div>
  </div>

  <div v-else>
    <p>Loading ...</p>
  </div>
</template>

<script>
import axios from "axios";
import ProblemHandle from "../components/ProblemHandle.vue";
import ArticleComments from "../components/ArticleComments.vue";
import { user, isLogin } from "@/composables/User";

export default {
  name: "ArticleView",
  components: { ArticleComments, ProblemHandle },
  data() {
    return {
      // article
      showAnswer: false,
      articleId: null,
      header: "",
      paragraphs: [],
      comments: [],

      // user
      userId: null,
      isLogin: isLogin,
    };
  },
  mounted() {
    this.init();
  },
  watch: {
    isLogin(newVal) {
      if (newVal !== null) {
        this.fetchUser();
      }
    },
  },
  methods: {
    init() {
      this.articleId = this.$route.params.id;
      // console.log(this.articleId);
      this.fetchArticle();
      this.fetchUser();
      // this.getCommentMaker();
    },
    async fetchArticle() {
      await axios
        .get("article/search/" + this.articleId)
        .then((response) => {
          // console.log(response);
          this.header = response.data.data.header;
          this.paragraphs = response.data.data.paragraphs;
          this.comments = response.data.data.comments;
          this.paragraphs.sort(function (a, b) {
            if (a.order !== b.order) {
              return a.order - b.order;
            }
          });
          // console.log(this.header);
          // console.log(this.paragraphs);
          // console.log(this.questions);
          // console.log(this.comments);
        })
        .catch((error) => {
          alert(error);
        });
    },
    jumpingTo(index) {
      let e = document.getElementById(index);
      e.scrollIntoView({
        block: "start",
        behavior: "smooth",
        inline: "nearest",
      });
    },
    fetchUser() {
      if (user.value) {
        this.userId = user.value.id;
      } else {
        return;
      }
    },
    async bookmark() {
      await axios
        .post("user/bookmark/add", {
          userId: this.userId,
          articleId: parseInt(this.articleId),
        })
        .then((response) => {
          if (response.data.code === 200) {
            alert("Added a bookmark");
          } else {
            alert(response.data.message);
          }
        })
        .catch((error) => {
          alert(error);
        });
    },
    getImgUrl(paragraphOrder, imgName) {
      const relativePath =
        "../imgMaterials/article" +
        this.articleId +
        "/paragraph" +
        paragraphOrder +
        "/" +
        imgName +
        ".png";
      return relativePath;
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
  line-height: normal;
}

.navbar-vertical {
  display: flex;
  padding: 10px 10px 20px 10px;
  /* margin: auto; */
  flex-direction: column;
  align-items: center;
  list-style-type: circle;
  list-style-position: inside;
  width: 100%;
  position: sticky;
  top: 3rem;
  z-index: 100;
}

.nav-wrapper {
  max-width: 300px;
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
  padding: 0 1rem 1rem 1rem;
  text-align: justify;
  line-height: 2rem;
  font-size: 1.1rem;
}

.subheader {
  font-size: 1.5rem;
  text-decoration: underline;
  margin-top: 10px;
}

.bookmarkButtion {
  border-radius: 5px;
  padding: 3px;
  color: rgb(228, 79, 98);
}

img {
  max-width: 500px;
  padding: 10px;
}
</style>
