<template>
  <div class="wrapper">
    <div class="container">
      <form class="form" v-if="!goCreateAccount">
        <h1 class="title">Login</h1>
        <div class="message message-error" v-show="!isValidEmail">
          <span> Invalid email </span>
        </div>
        <div class="input-group">
          <input type="text" class="input" placeholder="Email" v-model="email" />
          <div class="input-error-message" v-show="!isCorrectPassword">
            <span> {{ msg }} </span>
          </div>
        </div>
        <div class="input-group">
          <input
            type="password"
            class="input"
            placeholder="Password"
            autocomplete
            v-model="password"
          />
        </div>
        <button class="button" type="button" @click="checkPassword()">Continue</button>
        <p class="text">
          <a href="#" class="link">Forgot your password?</a>
        </p>
        <p class="text">
          <a class="link" @click="toggleCreateAccount()"
            >Don't have an account? Sign Up Here</a
          >
        </p>
      </form>

      <form class="form" v-if="goCreateAccount">
        <h1 class="title">Create Account</h1>
        <div class="message message-error" v-if="!isValidUsername">
          <span> Invalid username </span>
        </div>
        <div class="input-group">
          <input
            type="text"
            id="signupUsername"
            class="input"
            placeholder="Username"
            v-model="signupUserName"
          />
          <div class="message message-error" v-if="!isValidEmail">
            <span> Invalid email </span>
          </div>
        </div>
        <div class="input-group">
          <input
            type="text"
            id="signupEmail"
            class="input"
            placeholder="Email Address"
            v-model="signupEmail"
          />
          <div class="message message-error" v-if="!isValidSignupPassword">
            <span> Invalid password / passwords are inconsistent </span>
          </div>
        </div>
        <div class="input-group">
          <input
            type="password"
            id="signupPassword"
            class="input"
            placeholder="Password"
            autocomplete
            v-model="signupPassword1"
          />
          <div class="input-error-message"></div>
        </div>
        <div class="input-group">
          <input
            type="password"
            id="signupPasswordConfirm"
            class="input"
            placeholder="Confirm password"
            autocomplete
            v-model="signupPassword2"
          />
          <div class="input-error-message" v-if="hasMsg">
            <span>
              {{ signupMsg }}
            </span>
          </div>
        </div>
        <button class="button" type="button" @click="signup">Continue</button>
        <p class="text">
          <a class="link" @click="toggleLogin()">Already have an account? Login</a>
        </p>
      </form>
    </div>
  </div>
</template>

<script>
/* eslint-disable no-useless-escape */
import axios from "axios";

export default {
  name: "LoginPage",
  data() {
    return {
      email: "",
      password: "",
      isValidEmail: true,
      isCorrectPassword: true,
      goCreateAccount: false,
      msg: "",
      userId: null,

      signupUserName: "",
      signupEmail: "",
      signupPassword1: "",
      signupPassword2: "",
      isValidUsername: true,
      isValidSignupPassword: true,
      signupMsg: "",
      hasMsg: false,
    };
  },
  watch: {
    // eslint-disable-next-line
    email(email) {
      this.checkEmailValidation(email);
    },
    signupUserName(username) {
      this.checkUsername(username);
    },
    signupEmail(email) {
      this.checkEmailValidation(email);
    },
  },
  methods: {
    checkEmailValidation(email) {
      if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
        this.isValidEmail = true;
      } else {
        this.isValidEmail = false;
      }
      // console.log(this.isValidEmail);
    },
    async checkPassword() {
      await axios
        .post("api/user/sign_in", {
          email: this.email,
          password: this.password,
        })
        .then((response) => {
          // console.log(response);
          
          if (response.data.message == "the user is not in the database") {
            this.isCorrectPassword = false;
            this.msg = "Account does not exist!";
          } else if (response.data.message == "incorrect password") {
            this.isCorrectPassword = false;
            this.msg = "Incorrect password!";
          } else {
            this.isCorrectPassword = true;
            this.userId = response.data.data;
            // console.log(userId);
            this.$emit("getUser", this.userId);
            localStorage.userId = this.userId;
            window.location.href = '/home';
          }
        })
        .catch((error) => {
          alert(error);
        });
    },
    toggleCreateAccount() {
      this.goCreateAccount = true;
      this.isValidEmail = true;
    },
    toggleLogin() {
      this.goCreateAccount = false;
      this.isValidEmail = true;
    },
    // sign up
    checkUsername(username) {
      if (username == "" || username.trim().length === 0) {
        this.isValidUsername = false;
      } else {
        this.isValidUsername = true;
      }
    },
    checkSignupPassword() {
      if (this.signupPassword1 == "" || this.signupPassword1.trim().length === 0) {
        this.isValidSignupPassword = false;
      } else if (this.signupPassword1 !== this.signupPassword2) {
        this.isValidSignupPassword = false;
      } else {
        this.isValidSignupPassword = true;
      }
    },
    async signup() {
      this.checkSignupPassword();
      if (
        this.isValidSignupPassword == false ||
        this.isValidEmail == false ||
        this.isValidUsername == false
      ) {
        return;
      }

      await axios
        .post("api/user/sign_up", {
          account: {
            userName: this.signupUserName,
            email: this.signupEmail,
            passWord: this.signupPassword1,
            accountType: "NORMAL",
          },
          bookMarks: [],
          contribution: [],
          comments: [],
        })
        .then((response) => {
          console.log(response);
          if (response.data.message !== "succeed") {
            this.signupMsg = response.data.message;
            this.hasMsg = true;
          } else {
            this.hasMsg = false;
            alert("Thank you for joining us!")
          }
        })
        .catch((error) => {
          alert(error);
        });
    },



  },
};
</script>

<style scoped>
.wrapper {
  --color-primary: #009579;
  --color-primary-dark: #007f67;
  --color-secondary: #252c6a;
  --color-error: #cc3333;
  --color-success: #4bb544;

  margin: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 18px;
  background-size: cover;
  padding-top: 5rem;
}

.container {
  width: 400px;
  max-width: 400px;
  margin: 1rem;
  padding: 2rem;
  box-shadow: 0 0 40px rgba(0, 0, 0, 0.2);
  border-radius: 10px;
  background: #ffffff;
}

.container,
.input,
.button {
  font: 400 1rem;
}

.form-hidden {
  display: none;
}

.form > *:first-child {
  margin-top: 0;
}

.form > *:last-child {
  margin-bottom: 0;
}

.title {
  margin-bottom: 2rem;
  text-align: center;
  color: #444;
}

.input-group {
  margin-bottom: 1rem;
}

.input {
  display: block;
  width: 100%;
  padding: 0.75rem;
  box-sizing: border-box;
  border-radius: 20px;
  border: 1px solid #dddddd;
  outline: none;
  background: #f0f0f0;
}

.input:focus {
  border-color: var(--color-primary);
  background: #ffffff;
}

.input-error {
  color: var(--color-error);
  border-color: var(--color-error);
}

.input-error-message {
  margin-top: 0.5rem;
  font-size: 0.85rem;
  color: var(--color-error);
}

.button {
  display: block;
  margin: 0 auto;
  width: 40%;
  height: 45px;
  font-weight: bold;
  font-size: 1.1rem;
  color: #ffffff;
  border: none;
  border-radius: 55px;
  outline: none;
  cursor: pointer;
  background: var(--color-primary);
}

.button:hover {
  background: var(--color-primary-dark);
}

.button:active {
  transform: scale(0.98);
}

.text {
  margin-top: 10px;
  text-align: center;
}

.link {
  color: var(--color-secondary);
  text-decoration: none;
  cursor: pointer;
}

.link:hover {
  text-decoration: underline;
}

.message {
  text-align: center;
  margin-top: 0.7rem;
  margin-bottom: 0.3rem;
}

.message-success {
  color: var(--color-success);
}

.message-error {
  color: var(--color-error);
}
</style>
