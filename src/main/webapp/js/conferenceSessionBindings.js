// Understands behavior bindings for the Conference Session page
$(document).ready(function() {
    $("#goingButton").click(function(){
        that = this;
        var sessionId = $(that).data('sessionid');
        var going = $(that).hasClass('active')
        var type = going ? 'DELETE' : 'POST';
        var url = "/thoughtconf/api/session/" + sessionId + "/attendance";

        $.ajax( url, { 'type' : type} )
            .done(function() { (new ConferenceSession(that)).toggleAttendance(); })
            .fail(function() { alert("error"); })
            .always(function() {  });

        return false;
    });
});


$(document).ready(function(){
    $.getJSON("/thoughtconf/conferenceList", function(response){
        var conferenceNames = response.toString().split(",");
        
        $("#conferenceName").autocomplete({
                source: conferenceNames
            });
    })

});
