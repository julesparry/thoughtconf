// Understands behavior bindings for the Conference Session page
$(document).ready(function() {
    $("#goingButton").click(function(){
        that = this;
        $.ajax( "/thoughtconf/api/session/attend/" + $(that).data('sessionid') )
            .done(function() { (new ConferenceSession(that)).toggleAttendance(); })
            .fail(function() { alert("error"); })
            .always(function() {  });

        return false;
    });
});
