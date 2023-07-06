fun max(a: Int, b: Int): Int {
    return if (a > b) a else b;
}

fun min(a: Int, b: Int): Int = if (a > b) b else a;


fun topLevel(): Int = 1

fun main() {
    println("Min: ${min(5, 6)}");
    println("Max: ${max(5, 6)}");

    println(topLevel());
}
