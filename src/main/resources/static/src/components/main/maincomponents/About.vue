<template>
  <div id="about">
    <iframe   width="640" height="360"
              src="https://www.youtube.com/embed/Xwzd7GcWx3U?rel=0&showinfo=0&autoplay=1&controls=0&iv_load_policy=3&loop=1"
              frameborder="3"  allowfullscreen>

    </iframe>
    <i>About</i>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        message:'',
        allMessages:'',
      }
    },
  }
</script>

<style>
  #about img{
    width: 1000px;
  }
</style>
