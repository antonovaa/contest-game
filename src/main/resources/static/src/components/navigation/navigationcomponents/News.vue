<template>
  <div>


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
      reversedMessage: function () {
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
