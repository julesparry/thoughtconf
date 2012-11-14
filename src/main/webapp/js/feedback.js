function Feedback(){
    this.presenterRating = 0;
    this.contentRating = 0;
    this.overallRating = 0;
    this.initialVotePoint = function(){
        $(".vote-point li").click(function(){
            var element = this;
            $(element).addClass("active");
            $(element).prevAll().removeClass("active");
            $(element).nextAll().removeClass("active");
        });
    }

     this.getVotedValues = function(){
        this.presenterRating = parseInt($('.presenter .vote-point .active').text());
        this.contentRating = parseInt($('.content .vote-point .active').text());
        this.overallRating = parseInt($('.overall .vote-point .active').text());

         return { presenterRating: this.presenterRating, contentRating: this.contentRating, overallRating: this.overallRating}
     }

}

$(document).ready(function() {
    var feedback = new Feedback();
    feedback.initialVotePoint();
    $('.submit-btn').click(function(){
        console.log('h----------------------------------------');
        $.post("feedback/create", feedback.getVotedValues());
    });
});
