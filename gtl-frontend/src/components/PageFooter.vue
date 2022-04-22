<template>
  <!-- Footer -->
    <footer class="page-footer font-small">
      <div class="container-fluid">
        <div class="row">
          <!-- Copyright -->
          <div class="footer-copyright py-4 col-sm-12 col-lg-3">© 2022 Copyright:
            <a href="#"> GetToLearn.com</a>
          </div>
          <div class="col-sm-12 col-lg-9 socialWrapper">
            <a href="https://facebook.com" target="_blank">
              <i class="fa fa-facebook-square fa-3x" aria-hidden="true"></i></a>
            <a href="https://google.com" target="_blank">
              <i class="fa fa-google-plus-square fa-3x" aria-hidden="true"></i></a>
            <a href="https://instagram.com" target="_blank">
              <i class="fa fa-instagram fa-3x" aria-hidden="true"></i></a>
          </div>
        </div>
      </div>
    </footer>
</template>

<script>
export default {
  name: 'PageFooter',
}
</script>

<style>
footer.page-footer {
    position: absolute;
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
