package code.camp.grails

class QuestionController {

    def matchers = [
            /what currency did Spain use before the Euro/: { "Pesetas" },
            /what is ([0-9]+) plus ([0-9]+)/: { (it[0][1] as int) + (it[0][2] as int) },
            /what is ([0-9]+) multiplied by ([0-9]+)/: { (it[0][1] as int) * (it[0][2] as int) },
            /which of the following numbers is the largest: (.+)/: { ((it[0][1] as String).split(", ") as List<Integer>).max() },
            /who played James Bond in the film Dr No/: { "Sean Connery" },
            /who is the Chancellor of Germany/: { "Angela Merkel" },
            /what is the ([0-9]+)th number in the Fibonacci sequence/: { fib((it[0][1] as int) - 1) },
            /which of the following numbers are primes: (.+)/: { ((it[0][1] as String).split(", ") as List<Integer>).findAll{ (it as BigInteger).isProbablePrime(99) }.join(", ") }
    ]

    def answer = {
        def q = params.q
        def question = q.substring(q.indexOf(":") + 2)
        println "Question: $question"

        def processor = matchers.find { expression, operation ->
            (question =~ expression).matches()
        }

        if (processor) {
            def answer = processor.value(question =~ processor.key)
            println "Answer: $answer"
            render (answer as String)
        } else {
            render "Sorry, but I have no answer for your question: '$question'"
        }
    }

    def manual = {
        params.q = "5bea3a70: " + params.q
        answer(params)
    }

    private int fib(int i) {
        i < 2 ? 1 : fib(i - 2) + fib(i - 1);
    }

}
