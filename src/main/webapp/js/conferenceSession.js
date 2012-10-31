function Intent(domElement) {
    this.toggle = function(){
        $(domElement).toggleClass("active");
    };
};
