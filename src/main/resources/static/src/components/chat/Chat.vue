<template>
  <div id="chat-form">
    <!--<textarea rows="10" cols="45" name="text" disabled="disabled">-->
      <!--{{this.allMessages}}-->
    <!--</textarea>-->
    <!--<input type="text" v-model="this.message"/>-->
    <button v-on:click="showChat=!showChat">свернуть</button>
    <div v-if="showChat">
    <div class="container">
      <img src="https://www.w3schools.com/w3images/bandmember.jpg" alt="Avatar">
      <p>Hello. How are you today?</p>
      <span class="time-right">11:00</span>
    </div>

    <div class="container darker">
      <img src="https://www.w3schools.com//w3images/avatar_g2.jpg" alt="Avatar" class="right">
      <p>Hey! I'm fine. Thanks for asking!</p>
      <span class="time-left">11:01</span>
    </div>

    <div class="container">
      <img src="https://www.w3schools.com//w3images/bandmember.jpg" alt="Avatar">
      <p>Sweet! So, what do you wanna do today?</p>
      <span class="time-right">11:02</span>
    </div>

    <div class="container darker">
      <img src="https://www.w3schools.com//w3images/avatar_g2.jpg" alt="Avatar" class="right">
      <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>
      <span class="time-left">11:05</span>
    </div>
    </div>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        message:'',
        allMessages:'',
        showChat:true
      }
    },
    methods: {

      sendMessages: function () {

      },
      setfilter: function () {

      }
    },
    computed: {
      reversedMessage: function () {
        // `this` указывает на экземпляр vm
//        return this.message.split('').reverse().join('')
      }
    }
  }
</script>

<style>

  /* Chat containers */
  #chat-form .container {
    border: 2px solid #dedede;
    background-color: #f1f1f1;
    border-radius: 5px;
    padding: 10px;
    margin: 10px 0;
  }

  /* Darker chat container */
  .darker {
    border-color: #ccc;
    background-color: #ddd;
  }

  /* Clear floats */
  #chat-form .container::after {
    content: "";
    clear: both;
    display: table;
  }

  /* Style images */
  #chat-form .container img {
    float: left;
    max-width: 60px;
    width: 100%;
    margin-right: 20px;
    border-radius: 50%;
  }

  /* Style the right image */
  #chat-form .container img.right {
    float: right;
    margin-left: 20px;
    margin-right:0;
  }

  /* Style time text */
  .time-right {
    float: right;
    color: #aaa;
  }

  /* Style time text */
  .time-left {
    float: left;
    color: #999;
  }

</style>
