
fun another_yield() {
    val mySequence = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(1..5)
        println("yield a list")
        yieldAll(listOf(7, 9))
    }

    println(mySequence.map { it * it }.filter {  it > 10 }.first())
}

fun yield_test() {
    val numbers = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }

    println(numbers.take(6).toList())
}

fun test_print() {
    val numbers = generateSequence(3) {
        n ->
        println("generating element")
        (n + 1).takeIf { it < 7 }
    }
    // nothing will print inside the generator
    println(numbers.first())
    println(numbers.toList())
}

fun main() {
    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())
    test_print()
    yield_test()
    another_yield()
}