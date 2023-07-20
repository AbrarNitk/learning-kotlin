fun fibSeq() = sequence {
    var a = 0
    var b = 1
    while(true) {
        val c = a + b
        a = b
        b = c
        yield(c)
    }
}


fun main() {
    for(x in fibSeq().take(5)) {
        println(x)
    }
}