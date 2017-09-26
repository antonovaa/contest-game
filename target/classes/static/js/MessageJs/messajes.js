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
});








