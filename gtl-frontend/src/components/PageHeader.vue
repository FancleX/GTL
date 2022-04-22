<template>
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
            <a
              class="nav-link active"
              aria-current="page"
              href="index.html"
              @click="showAboutUs"
              >Home</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="#" @click="goExplore">Explore</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="#aboutUs" @click="showAboutUs">About us</a>
          </li>
        </ul>
        <form class="d-flex">
          <!-- <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"> -->
          <!-- <img src="../assets/logo.png" alt="user-profileImg" class="user-profileImg"> -->
          <button class="btn btn-outline-success" type="submit">Login</button>
        </form>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "PageHeader",
};
</script>

<style>
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
  transform: scale(1.3);
  font: bold;
}
</style>
