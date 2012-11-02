function ConferenceSession(domElement) {
    this.toggleAttendance = function(){
        $(domElement).toggleClass("active");
    };
};
