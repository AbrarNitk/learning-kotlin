val foo1 = run {
    println("Foo1 calculating the answer")
    42
}

val foo2: Int
    get() {
        println("Foo2 calculating the answer")
        return 42
    }

fun main() {
    println("$foo1 $foo1 $foo2 $foo2")
}
