// Understands behavior bindings for the Conference Session page
$(document).ready(function() {
    $("#goingButton").click(function(){
        (new Intent(this)).toggle();
    });
});
