describe("Going Button", function() {
    var button;

    beforeEach(function() {
      button = document.createElement("a");
      button.setAttribute("href","#");
      button.setAttribute("data-role","button");
      button.setAttribute("class","going_button");
      button.setAttribute("id","fakeButton")
      document.body.appendChild(button);
    });
    describe("after init",function(){
        beforeEach(function(){
            initGoingButton();
        });
        it("should be inactive", function() {

            expect((document.getElementById("fakeButton").className)).toContain("going_button_inactive");

        });
        it("should have going status false", function() {
            expect(going).toBeFalsy();

        });

        describe("When clicked inactive button", function(){
            beforeEach(function(){
                button.setAttribute("class","going_button going_button_inactive");

                $("#fakeButton").trigger('click');
            })  ;


            it("should change to active", function(){
                expect((document.getElementById("fakeButton").className)).toContain("going_button_active");

            }) ;

            it("should have going status true", function() {
                expect(going).toBeTruthy();

            });
        });
        describe("When clicked active button", function(){
            beforeEach(function(){


                $("#fakeButton").trigger('click');
                $("#fakeButton").trigger('click');

            })  ;


            it("should change to inactive", function(){
                expect((document.getElementById("fakeButton").className)).toContain("going_button_inactive");

            }) ;

            it("should have going status false", function() {
                expect(going).toBeFalsy();

            });
        });

    });




});