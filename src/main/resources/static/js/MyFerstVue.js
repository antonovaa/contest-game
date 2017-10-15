new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue.js!'
  }
});
var app2 = new Vue({
  el: '#app-2',
  data: {
    message: 'Вот когда вы загрузили эту страницу: ' + new Date().toLocaleString()
  }
});

var app3 = new Vue({
  el: '#app-3',
  data: {
    seen: true
  }
});
var app4 = new Vue({
  el: '#app-4',
  data: {
    todoS: [
      { text: 'Посадить дерево' },
      { text: 'Построить дом' },
      { text: 'Вырастить сына' },
      { text: 'Вырастить кота' }
    ]
  }
});

var app5s = new Vue({el: '#app-5s'});


var app5 = new Vue({
  el: '#app-5',
  data: {
    message: 'Hello Vue.js!'
  },
  methods: {
    reverseMessage: function () {
      this.message = this.message.split('').reverse().join('');
    }
  }
});

var app6 = new Vue({
  el: '#app-6',
  data: {
    message: 'Hello Vue!'
  }
});
var app7=Vue.component('todof-item', {
  props: ['todosdsd'],
  template: '<li>{{ todosdsd.text }}</li>'
});
new Vue({
  el: '#app-7',
  data: {
    groceryList: [
      { id: 0, text: 'Овощи' },
      { id: 1, text: 'Сыр' },
      { id: 2, text: 'Что там ещё люди едят?' }
    ]
  }
});

var app7s=Vue.component('todoTem', {
  props: ['todoTem'],
  template: '<li>{{ todo }}Это t asd asd odo</li>'
});
new Vue({
  el: '#app-7s',
  data: {}
});









