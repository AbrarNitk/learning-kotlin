fun main() {
    val list = listOf("a", "b", "c");
    for(s in list) {
        print(s)
    }

    for((index, element) in list.withIndex()) {
        println("${index}, ${element}")
    }
    

    for(x in 1..9) {
        println(x)
    }
    
    for(x in 9 downTo 1 step 2) {
        println(x)
    }
   
    // Iterate over the string
    for(ch in "abc") {
        print(ch + 1)
    }
}
