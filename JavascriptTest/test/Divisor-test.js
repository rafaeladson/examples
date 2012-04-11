TestCase("divisorTest", {
    
    setUp: function() {
	this.divisor = new Divisor();
    },

    tearDown: function() {
	delete this.divisor;
    },

    "test divisor can divide 4 by 2": function() {
	var result = this.divisor.divide(4,2);
	assertEquals( 2, result );
    },
    
    "test wrong division": function() {
	var result = this.divisor.divide(4,3);
	assertEquals( 2, result );
    }

   

});