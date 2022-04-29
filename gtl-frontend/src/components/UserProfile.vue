<template>
  <div class="dropdown">
    <a
      class="profile"
      href="#"
      role="button"
      id="dropdownMenuLink"
      data-bs-toggle="dropdown"
      aria-expanded="false"
    >
      <img src="../assets/userIcon.png" alt="user-profileImg" class="user-profileImg" />
    </a>

    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
      <li><a class="dropdown-item disabled" href="#">{{ userAccountInfo.userName }}</a></li>
      <li><a class="dropdown-item" href="#">Another action</a></li>
      <li><a class="dropdown-item" href="#">Something else here</a></li>
    </ul>
  </div>
</template>

<script>
export default {
name: 'UserProfile',
props: ['userAccountInfo', 'userBookmark', 'userContribution'],

};
</script>

<style scoped>
.dropdown {
    margin-right: 3rem;
}

.dropdown-menu {
    left: -90px;
}

@media (max-width: 990px) {
    .dropdown-menu {
        left: 0;
    }
}


</style>
