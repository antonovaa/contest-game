<template>
  <div>

    <!--news-->
    <!--<textarea rows="10" cols="45" name="text" disabled="disabled">-->
      <!--{{allMessages}}-->
      <!--das23231s1s 2s-->
    <!--</textarea>-->
    <!--<input type="text" v-model="message"/>-->
    <!---->

    <div id="new">
      <h1>news</h1>
    </div>


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
    computed: {
      eversedMessage: function () {
        // `this` указывает на экземпляр vm
        return this.message.split('').reverse().join('')
      }
    }
  }
</script>

<style >

#new{

  height: 300px;
  background-color: #bb0018;
}

</style>
