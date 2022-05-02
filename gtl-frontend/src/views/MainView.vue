<template>
  <div class="container-fluid">
    <!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
      <div class="container-fluid">
        <img src="../assets/logo.png" class="navbar-brand" alt="logo" />
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link to="/" class="nav-link active" aria-current="page"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/explore" class="nav-link active">Explore</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/" class="nav-link active">About us</router-link>
            </li>
          </ul>
          <form class="d-flex">
            <div v-if="isLogin">
              <UserProfile />
            </div>
            <div v-else>
              <button
                class="btn btn-outline-success"
                type="button"
                @click="$router.push('/login')"
              >
                Login
              </button>
            </div>
          </form>
        </div>
      </div>
    </nav>

    <div class="container dynamic">
      <router-view :key="$route.fullPath" @close="renderUserProfile()" />
    </div>

    <!-- Footer -->
    <footer class="page-footer font-small">
      <div class="container-fluid">
        <div class="row">
          <!-- Copyright -->
          <div class="footer-copyright py-4 col-sm-12 col-lg-3">
            © 2022 Copyright:
            <router-link to="/"> GetToLearn.com</router-link>
          </div>
          <div class="col-sm-12 col-lg-9 socialWrapper">
            <a href="https://facebook.com" target="_blank">
              <i class="fa fa-facebook-square fa-3x" aria-hidden="true"></i
            ></a>
            <a href="https://google.com" target="_blank">
              <i class="fa fa-google-plus-square fa-3x" aria-hidden="true"></i
            ></a>
            <a href="https://instagram.com" target="_blank">
              <i class="fa fa-instagram fa-3x" aria-hidden="true"></i
            ></a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
import UserProfile from "../components/UserProfile.vue";

export default {
  name: "App",
  components: {
    UserProfile,
  },
  data() {
    return {
      user: null,
      isLogin: false,
    };
  },
  methods: {
    renderUserProfile() {
      this.isLogin = !this.isLogin;
    },
  },
};
</script>

<style>
.container-fluid {
  padding: 0;
}

.navbar {
  box-shadow: 0 0 10px #000000;
}

img.navbar-brand {
  width: 60px;
  height: auto;
}

.navbar-custom {
  width: 100%;
  padding: 0.75rem;
}

img.user-profileImg {
  width: 40px;
  height: auto;
  border: 2px solid rgba(39, 37, 37, 0.5);
  border-radius: 50%;
  margin-right: 10px;
}

.btn-outline-success {
  color: #303137;
  border-color: #303137;
}

.btn-outline-success:hover {
  background-color: #303137;
  border-color: black;
  box-shadow: 0 0 0 0.2rem rgba(0, 0, 0, 0.2) !important;
}

.btn-outline-success:active {
  box-shadow: 0 0 0 0.25rem rgba(0, 0, 0, 0.5) !important;
}

.btn-outline-success:focus {
  box-shadow: none;
}

.nav-item:hover {
  font: bold;
}

.dynamic {
  min-height: 75vh;
  margin-top: 3rem;
  width: 100%;
}

footer.page-footer {
  position: relative;
  bottom: 0;
  width: 100%;
  height: 1.5rem;
  margin-top: auto;
  border-top: 2px solid rgba(44, 44, 46, 0.5);
}

.footer-copyright {
  padding-left: 3rem;
}

.socialWrapper {
  margin: auto;
  padding-left: 3rem;
}

.fa {
  margin: 10px 3px 10px 10px;
}

.fa-facebook-square {
  color: #3b5998;
}

.fa-google-plus-square {
  color: #c32f10;
}

.fa-instagram {
  color: #ffffff;
}
</style>
