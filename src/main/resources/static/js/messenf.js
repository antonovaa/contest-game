booK.controller('FrontPageController', function ($scope, $http) {
    $scope.question2=[];
    var stompClient=null;
    $scope.sea=function () {
        $http(
            {
                method: 'POST',
                url: '/sea',
                data: JSON.stringify({x:15,y:22,str:"s12333ss"}),
                headers: {'Content-Type': 'application/json'}
            }
        ).
        then(function(response) {
            $scope.question2.push(response.data);
            $scope.loaded=true;
        });
    };

    function setConnected(connected) {
        document.getElementById('connect').disabled = connected;
        document.getElementById('disconnect').disabled = !connected;
        document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
        document.getElementById('response').innerHTML = '';
    }

    $scope.connect2 = function () {
        var socket = new SockJS('/hello');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            setConnected(true);
            console.log('Connected: ' + frame);
            console.log('Connected: ' + sessionStorage);
            stompClient.subscribe('/topic/greetings', function (greeting) {
                $scope.showGreeting(JSON.parse(greeting.body).content);
            });
        });
    };

    function disconnect() {
        stompClient.disconnect();
        setConnected(false);
        console.log("Disconnected");
    }

    $scope.sendName = function () {
        var name = document.getElementById('name').value;
        stompClient.send("/app/hello", {}, JSON.stringify({'name': name}));
    };

    $scope.showGreeting = function (message) {
        var response = document.getElementById('response');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
    }


});