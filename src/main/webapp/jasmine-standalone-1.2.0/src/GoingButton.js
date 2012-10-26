var going;
function initGoingButton() {
    $(".going_button").addClass("going_button_inactive");
    going = false;
    $(".going_button_inactive").click(toggleGoing);
    //$(".going_button_active").click(toggleNotGoing);
}
function toggleGoing() {
    $(this).removeClass("going_button_inactive");
    $(this).addClass("going_button_active");
    $(".going_button_active").click(toggleNotGoing);
    going = true;
}
function toggleNotGoing(){
    $(this).removeClass("going_button_active");
    $(this).addClass("going_button_inactive");
    $(".going_button_inactive").click(toggleGoing);
    going = false;
}