<template>
  <!-- questions -->
  <div class="problemhandle">
    <p style="white-space: pre-line">{{ question.description }}</p>
    <form>
      <div v-for="(item, index) in question.optionList" :key="item" style="display:inline-block">
        <input
          type="radio"
          name="fav_language"
          @click="checkAnswer(options[index], question.answer)"
        />
        <label class="option">{{
          options[index] + ": " + item.content
        }}</label>
      </div>




      <label class="option">
        {{ indicator }}
      </label>
      <button type="button" class="showAnswer" @click="toggleAnswer">
        Hint
      </button>
    </form>
    <p v-if="showAnswer">
      {{ item.explaination }}
    </p>
  </div>
</template>

<script>
export default {
  name: "Problem",
  props: ["question"],
  data() {
    return {
      showAnswer: false,
      options: ["A", "B", "C", "D"],
      indicator: "",
    };
  },
  methods: {
    toggleAnswer() {
      this.showAnswer = true;
    },
    checkAnswer(pickedAnswer, answer) {
      // console.log(pickedAnswer);
      // console.log(answer)
      // this.currentQuestion = index;
      // this.showAnswer = false;
      // console.log(this.questionId);
      if (pickedAnswer === answer) {
        // console.log(true);
        this.indicator = "Correct!";
      } else {
        this.indicator = "Wrong!";
      }
    },
  },
};
</script>

<style scoped>
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
</style>
