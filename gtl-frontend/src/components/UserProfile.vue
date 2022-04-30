<template>
  <div class="container-fluid">
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#main_nav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="main_nav">
      <ul class="navbar-nav">
        <li class="nav-item dropdown" id="myDropdown">
          <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" >
            <img
              src="../assets/userIcon.png"
              alt="user-profileImg"
              class="user-profileImg"
            />
          </a>
          <ul class="dropdown-menu">
            <li>
              <a class="dropdown-item disabled" href="#">
                {{ userAccountInfo.userName }}
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#">&lsaquo; Bookmark </a>
              <ul class="submenu dropdown-menu" v-show="bookmark.length !== 0">
                <li v-for="item in bookmark" :key="item">
                  <router-link
                    :to="{ name: 'ArticleView', params: { id: item.articleId } }"
                    class="dropdown-item"
                    >{{ item.articleHeader.substring(0, 7) + "..." }}</router-link
                  >
                </li>
              </ul>
            </li>
            <li>
              <a class="dropdown-item" href="#">&lsaquo; Contributions </a>
              <ul class="submenu dropdown-menu" v-show="userContribution.length !== 0">
                <li v-for="item in userContribution" :key="item">
                  <router-link
                    :to="{ name: 'ArticleView', params: { id: item.articleId } }"
                    class="dropdown-item"
                    >{{ item.articleHeader.substring(0, 7) + "..." }}</router-link
                  >
                </li>
              </ul>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserProfile",
  props: ["userAccountInfo", "userBookmark", "userContribution"],
  data() {
    return {
      bookmark: this.userBookmark,
    };
  },
//   watch: {
//     bookmark(newVal, oldVal) {
//         console.log(newVal)
//       if (newVal.userBookmark.length !== oldVal.userBookmark.length) {
//           this.$data.bookmark = newVal;
//         console.log(this.$data.bookmark);
//       }
//       //   location.reload();
//     },
//     deep: true
//   },
};
</script>

<style scoped>
.dropdown {
  margin-right: 6rem;
}

@media all and (min-width: 992px) {
  .dropdown-menu li {
    position: relative;
  }
  .nav-item .submenu {
    display: none;
    position: absolute;
    right: 100%;
    top: -7px;
  }
  .nav-item .submenu-left {
    left: 100%;
    right: auto;
  }
  .dropdown-menu > li:hover {
    background-color: #f1f1f1;
  }
  .dropdown-menu > li:hover > .submenu {
    display: block;
  }
}
/* ============ desktop view .end// ============ */

/* ============ small devices ============ */
@media (max-width: 991px) {
  .dropdown-menu .dropdown-menu {
    margin-left: 0.7rem;
    margin-right: 0.7rem;
    margin-bottom: 0.5rem;
    display: block;
  }
}
</style>
