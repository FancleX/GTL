<template>
  <div class="row">
    <div class="col"></div>
    <div class="col-sm-10 col-md-8">
      <section class="discussion">
        <div class="discussionTitle">Discussions:</div>
        <div class="breakLine"></div>
        <div v-if="userComment.length !== 0">
          <div class="discussionContent" v-for="(item, index) in userComment" :key="item">
            <label> {{ commentMakerNames[index] }}: </label>
            {{ item.message }}

            <span
              style="cursor: pointer"
              class="delete"
              v-show="userId && userId == commentMakerIds[index]"
              @click="deleteComment(index)"
            ></span>
          </div>
        </div>

        <input
          class="discussionContent"
          placeholder="Leave your comments here: (press enter to submit)"
          v-if="userId"
          v-model="submitComment"
          @keyup.enter="commitComment()"
        />
        <div v-else class="discussionContent" disabled>
          Please
          <router-link to="/login"> login</router-link>
          to comment!
        </div>
      </section>
    </div>
    <div class="col"></div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ArticleComments",
  props: ["userComment", "userId", "articleId"],
  mounted() {
    this.init();
  },
  data() {
    return {
      commentMakerIds: [],
      commentMakerNames: [],
      submitComment: "",
    };
  },
  methods: {
    init() {
      this.fetchCommentMakerId();
    },
    async commitComment() {
      if (this.submitComment !== "" && this.submitComment.trim().length !== 0) {
        await axios
          .post("article/addComment", {
            userId: parseInt(this.userId),
            articleId: parseInt(this.articleId),
            message: this.submitComment,
          })
          .then((response) => {
            // console.log(response);
            if (response.data.message === "succeed") {
              alert("Thanks for comments!");
              // location.reload();
              this.$router.push('/article/' + this.articleId);
            }
          })
          .catch((error) => {
            alert(error);
          });
      } else {
        alert("Comments can not be empty!");
      }
    },
    async fetchCommentMakerId() {
      await axios
        .get("article/getCommentMaker/" + this.articleId)
        .then((response) => {
          // console.log(response);
          this.commentMakerIds = response.data.data;
          // console.log(self.commentMakerIds);
          this.getCommentMaker(this.commentMakerIds);
        })
        .catch((error) => {
          alert(error);
        });
    },
    async getCommentMaker(ids) {
      // console.log(ids);
      await axios
        .post("user/getNames", {
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
    async deleteComment(commentIndex) {
      const commentId = this.userComment[commentIndex].id;
      // console.log(commentId);
      await axios.delete('article/delete/comment/' + commentId)
      .then(response => {
        if (response.data.code === 200){
          alert('Comment deleted');
          // location.reload();
        } else {
          alert(response.data.message);
        }
      })
      .catch(error => {
        alert(error);
      })
    },
  },
};
</script>

<style scoped>
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

.delete:before {
  content: "\2716";
  color: #b20610;
  float: right;
  padding-right: 5px;
}

</style>
