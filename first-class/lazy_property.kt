val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

class LazyProps {
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }
}

fun main() {
    println(lazyValue)
    println(lazyValue)

    val lazyProps = LazyProps()
    println(lazyProps.lazyValue)
    println(lazyProps.lazyValue)

}