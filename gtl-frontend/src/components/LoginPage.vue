<template>
  <div class="container">
    <form class="form" :id="login">
      <h1 class="title">Login</h1>
      <div class="message message-error"></div>
      <div class="input-group">
        <input type="text" class="input" autofocus placeholder="Email" />
        <div class="input-error-message"></div>
      </div>
      <div class="input-group">
        <input type="password" class="input" autofocus placeholder="Password" />
        <div class="input-error-message"></div>
      </div>
      <button class="button" type="submit">Continue</button>
      <p class="text">
        <a href="#" class="link">Forgot your password?</a>
      </p>
      <p class="text">
        <a class="link" href="./" id="linkCreateAccount"
          >Don't have an account? Sign Up Here</a
        >
      </p>
    </form>
    <form class="form form-hidden" id="createAccount">
      <h1 class="title">Create Account</h1>
      <div class="message message-error"></div>
      <div class="input-group">
        <input
          type="text"
          id="signupUsername"
          class="input"
          autofocus
          placeholder="Username"
        />
        <div class="input-error-message"></div>
      </div>
      <div class="input-group">
        <input
          type="text"
          id="signupEmail"
          class="input"
          autofocus
          placeholder="Email Address"
        />
        <div class="input-error-message"></div>
      </div>
      <div class="input-group">
        <input
          type="password"
          id="signupPassword"
          class="input"
          autofocus
          placeholder="Password"
        />
        <div class="input-error-message"></div>
      </div>
      <div class="input-group">
        <input
          type="password"
          id="signupPasswordConfirm"
          class="input"
          autofocus
          placeholder="Confirm password"
        />
        <div class="input-error-message"></div>
      </div>
      <button class="button" type="submit">Continue</button>
      <p class="text">
        <a class="link" href="" id="linkLogin">Already have an account? Login</a>
      </p>
    </form>
  </div>
</template>

<script>
import "./Login.js";

export default {
  name: "LoginPage",
  data() {
    return {


    }
  },
  methods: {
    
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container {
  --color-primary: #009579;
  --color-primary-dark: #007f67;
  --color-secondary: #252c6a;
  --color-error: #cc3333;
  --color-success: #4bb544;

  margin: 0;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 18px;
  background-size: cover;
  background-color: #b8c6db;
  background-image: linear-gradient(315deg, #b8c6db 0%, #f5f7fa 74%);

  /* width: 400px;
  max-width: 400px; */
  width: 100%;
  /* margin: 1rem; */
  margin: auto;
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
  margin-bottom: 1rem;
}

.message-success {
  color: var(--color-success);
}

.message-error {
  color: var(--color-error);
}

</style>
