<template>
  <!-- questions -->
  <div class="problemhandle">
    <p style="white-space: pre-line">{{ question.description }}</p>
    <form class="questionForm">
      <div
        v-for="(item, index) in question.optionList"
        :key="item"
        style="display: inline-block"
      >
        <div v-if="item.content !== ''">
          <input
            title="optinoList"
            type="radio"
            name="fav_language"
            @click="checkAnswer(options[index], question.answer)"
            :disabled="isClicked"
          />
          <label class="option">{{ options[index] + ": " + item.content }}</label>
        </div>
      </div>
      <span class="option correct" v-show="isCorrect"></span>
      <span class="option incorrect" v-show="!isCorrect && isCorrect != null"></span>
      <button type="button" class="showAnswer" @click="toggleAnswer">Hint</button>
    </form>
    <p v-if="showAnswer">
      {{ "Answer: " + question.answer + "\n" + question.explaination }}
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
      isCorrect: null,
      isClicked: null,
    };
  },
  methods: {
    toggleAnswer() {
      this.showAnswer = true;
    },
    checkAnswer(pickedAnswer, answer) {
      if (pickedAnswer === answer) {
        // console.log(true);
        this.isCorrect = true;
      } else {
        this.isCorrect = false;
      }
      this.isClicked = true;
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
  float: right;
  margin-right: 2rem;
}

.showAnswer:active {
  box-shadow: 0 0 0 0.1rem rgba(0, 0, 0, 0.5);
}

.correct:before {
  content: "\2714";
  color: #008100;
}
.incorrect:before {
  content: "\2716";
  color: #b20610;
}
</style>
