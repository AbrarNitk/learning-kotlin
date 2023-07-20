
inline fun buildMyList(s: MutableList<Int>.() -> Unit): List<Int>{
    var ll = mutableListOf<Int>()
    //ll.apply(s)
    // OR
    ll.s()
    return ll
}


fun main() {

    val sb = buildString {
        this.appendLine("###### Alphabets ######")
        for(c in 'a'..'z') {
            this.append(c)
        }
        this.appendLine()
        this.appendLine("###### Alphabets ######")
        for(c in 'A'..'Z') {
            this.append(c)
        }
        this.appendLine()
        this.appendLine("###### Alphabets ######")
    }
    println(sb)

    val ll = buildMyList {
        this.add(4)
        this.add(5)
    }
    println(ll)
}