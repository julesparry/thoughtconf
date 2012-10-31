describe("Behavior of dom element based on intent to attend", function() {

    describe("given a dom element which represents intention to attend", function() {
        it("should change to represent intention to not attend when selected", function() {
            var domElement = document.createElement("a");
            $(domElement).addClass("active");

            (new ConferenceSession(domElement)).toggleAttendance();

            expect($(domElement).hasClass("active")).toBeFalsy();
        })
    });

    describe("given a dom element which represents an intention not to attend", function() {
        it("should change to represent intention to attend when selected", function() {
            var domElement = document.createElement("a");

            (new ConferenceSession(domElement)).toggleAttendance();

            expect($(domElement).hasClass("active")).toBeTruthy();
        })
    });
});


