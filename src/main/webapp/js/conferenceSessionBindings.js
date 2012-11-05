// Understands behavior bindings for the Conference Session page
$(document).ready(function() {
    $("#goingButton").click(function(){
        (new ConferenceSession(this)).toggleAttendance();
        return false;
    });
});
