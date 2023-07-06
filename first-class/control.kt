enum class Color {
    BLUE, ORANGE, RED
}

fun getDescription(color: Color): String {
    return when(color) {
        Color.BLUE -> "blue"
        Color.ORANGE -> "orange"
        else -> "red"
    }
}

fun main() {
    println(getDescription(Color.RED))
    println(getDescription(Color.ORANGE))
    println(getDescription(Color.BLUE))
}
