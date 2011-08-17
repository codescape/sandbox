package code.camp.grails

import grails.test.*

class QuestionControllerTests extends ControllerUnitTestCase {
    
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCurrencyInSpain() {
        controller.params.q = "5bea3a70: what currency did Spain use before the Euro"
        controller.answer()
        assert "Pesetas" == controller.response.contentAsString
    }

    void testAddition() {
        controller.params.q = "5eeb1250: what is 7 plus 8"
        controller.answer()
        assert "15" == controller.response.contentAsString
    }

    void testMultiply() {
        controller.params.q = "b011e500: what is 3 multiplied by 10"
        controller.answer()
        assert "30" == controller.response.contentAsString
    }

    void testLargest() {
        controller.params.q = "bbffb1c0: which of the following numbers is the largest: 70, 940, 25, 718"
        controller.answer()
        assert "940" == controller.response.contentAsString
    }

    void testJamesBond() {
        controller.params.q = "f1bb2d70: who played James Bond in the film Dr No"
        controller.answer()
        assert "Sean Connery" == controller.response.contentAsString
    }

    void testChancellorOfGermany() {
        controller.params.q = "0c97db10: who is the Chancellor of Germany"
        controller.answer()
        assert "Angela Merkel" == controller.response.contentAsString
    }

    void testFibonacci() {
        controller.params.q = "6814ab00: what is the 20th number in the Fibonacci sequence"
        controller.answer()
        assert "6765" == controller.response.contentAsString
    }

    void testSquareAndCube() {
        controller.params.q = "9dc58680: which of the following numbers are primes: 942, 281, 91, 109"
        controller.answer()
        assert "281, 109" == controller.response.contentAsString
    }

    void testUnknownQuestion() {
        def question = "Why don't you answer me?"
        controller.params.q = question
        controller.manual()
        assert controller.response.contentAsString.contains(question)
    }

}
