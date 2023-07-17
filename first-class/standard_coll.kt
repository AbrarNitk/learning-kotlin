fun main() {
    val set = hashSetOf(1, 7, 8,);
    val list = arrayListOf(1, 7, 53);
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifthy-three");
    println("set elements: ${set.javaClass}")
    for(e in set) {
        println(e)
    }

    println("list elements: ${list.javaClass}")
    for(e in list) {
        println(e)
    }

    println("map elements: ${map.javaClass}")
    for(e in map) {
        println(e)
    }

    println("mapped elements: ${map.javaClass}")
    for(e in map.mapValues { entry -> "${entry.key} -> ${entry.value}" }) {
        println(e)
    }
}