describe("feedback test", function() {
    var feedback;
    beforeEach(function(){
        var fixture = "<li class='vote-item presenter clear'>"
            + "<div>Presenter</div>"
            + "<div>"
            + "<ol class='vote-point clear'><li>1</li><li>2</li><li>3</li></ol>"
            + "</div></li>"
        setFixtures(fixture);
        feedback = new Feedback();
        feedback.initialVotePoint();

    }) ;

    it("should change vote point status when click", function() {
        var firstPointItem = $(".vote-point li:first");
        var lastPointItem = $(".vote-point li:last");

        expect(firstPointItem).not.toHaveClass("active");
        firstPointItem.click();
        expect(firstPointItem).toHaveClass("active");

        expect(lastPointItem).not.toHaveClass("active");
        lastPointItem.click()
        expect(firstPointItem).not.toHaveClass("active");
        expect(lastPointItem).toHaveClass("active");
    });

    it("should store point value",function(){
        var firstPointItem = $(".vote-point li:first");
        expect(feedback.presenterRating).toBe(0);
        firstPointItem.click();
        feedback.getVotedValues();
        expect(feedback.presenterRating).toBe(1);

    });



});