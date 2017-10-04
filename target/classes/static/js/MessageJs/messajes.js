$(document).ready(function() {
    
    // console.log( "ready!" );

    alert("прива всем /оляяяяя");

    $("a").click(function() {

        alert( "Handler for .click() called." );
        var a = new Audio();
        a.src = "media/charlie_puth_-_attention_(zf.fm).mp3"
        // a.play();
        
        // '<audio id="soundcard" src="resources/mymp3/beat.mp3" autoplay></audio>';

    });




    $("img").jPlayer( {
        ready: function () {
            $(this).jPlayer("setMedia", {
                mp3: "media/charlie_puth_-_attention_(zf.fm).mp3"
            });
        }
    });


    var socket = new SockJS("/hello");
    var stompClient = Stomp.over(socket);

    // callback function to be called when stomp client is connected to server (see Note 2)
    var connectCallback = function() {
        alert("connected!");
        stompClient.subscribe('/topic/greetings', function(greeting){
            alert(JSON.parse(greeting.body).content);
        });
    };

    // callback function to be called when stomp client could not connect to server (see Note 3)
    var errorCallback = function(error) {
        // display the error's message header:
        alert(error.headers.message);
    };

    // Connect as guest (Note 4)
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
});








