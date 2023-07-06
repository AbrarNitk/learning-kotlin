fun max(a: Int, b: Int): Int {
    return if (a > b) a else b;
}

fun min(a: Int, b: Int): Int = if (a > b) b else a;


fun topLevel(): Int = 1

fun main() {
    println("Min: ${min(5, 6)}");
    println("Max: ${max(5, 6)}");

    println(topLevel());

    displayChar();
    println();
    displayChar('#');
    println();
    displayChar(size=10);
    println();
    displayChar(size=10, char='5'); // this will also work
}

// default args

fun displayChar(char: Char = '*', size: Int = 10) {
    repeat(size) {
        print(char)
    }
}
