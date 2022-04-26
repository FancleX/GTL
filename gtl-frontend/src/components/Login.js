/* eslint-disable */

const loginForm = document.querySelector("#login");
const createAccountForm = document.querySelector("#createAccount");

function setFormMessage(formElement, type, message) {
  const messageElement = formElement.querySelector(".message");

  messageElement.textContent = message;
  messageElement.classList.remove("message-success", "message-error");
  messageElement.classList.add(`message-${type}`);
}

function setInputError(inputElement, message) {
  inputElement.classList.add("input-error");
  inputElement.parentElement.querySelector(".input-error-message").textContent =
    message;
}

function clearInputError(inputElement) {
  inputElement.classList.remove("input-error");
  inputElement.parentElement.querySelector(".input-error-message").textContent =
    "";
}

function isEmail(email) {
  return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(
    email
  );
}

document.addEventListener("DOMContentLoaded", () => {
  document.querySelector("#linkLogin").addEventListener("click", (e) => {
    e.preventDefault();
    loginForm.classList.remove("form-hidden");
    createAccountForm.classList.add("form-hidden");
  });

  document
    .querySelector("#linkCreateAccount")
    .addEventListener("click", (e) => {
      e.preventDefault();
      loginForm.classList.add("form-hidden");
      createAccountForm.classList.remove("form-hidden");
    });

  loginForm.addEventListener("submit", (e) => {
    e.preventDefault();

    // Making AJAX Calls with Fetch

    setFormMessage(loginForm, "error", "Invalid username/password combination");
  });

  document.querySelectorAll(".input").forEach((inputElement) => {
    inputElement.addEventListener("blur", (e) => {
      if (
        e.target.id === "signupUsername" &&
        e.target.value.length > 0 &&
        e.target.value.length < 4
      ) {
        setInputError(
          inputElement,
          "Username must be at least 4 characters in length"
        );
      }

      if (e.target.id === "signupEmail" && isEmail(e.target.value) === false) {
        setInputError(inputElement, "Not a valid email");
      }

      if (
        e.target.id === "signupPassword" &&
        e.target.value.length > 0 &&
        e.target.value.length < 6
      ) {
        setInputError(
          inputElement,
          "Password must be at least 6 characters in length"
        );
      }

      if (
        e.target.id === "signupPasswordConfirm" &&
        e.target.value.length > 0 &&
        e.target.value.length < 6
      ) {
        password = setInputError(
          inputElement,
          "Password must be at least 6 characters in length"
        );
      }

      if (
        e.target.id === "signupPasswordConfirm" &&
        e.target.value !==
          document.querySelector("#signupPassword").value.trim()
      ) {
        setInputError(inputElement, "Passwords does not match");
      }
    });

    inputElement.addEventListener("input", (e) => {
      clearInputError(inputElement);
    });

    createAccountForm.addEventListener("submit", (e) => {
      e.preventDefault();
    });
  });
});
