fun main() {
    
    // Immutable Variable
    val name = "Abrar Khan";
    println("name ${name}")
    val typeName: String = "My name is Khan";
    println("another name: ${typeName}");
    // val name = "Abrar Khan 2"; this is an error, we can not define the same variable again
    // it will be result in conflict
    
    // Mutable Variable
    var mut_name = "Abrar Khan"
    println("Mutable name: ${mut_name}")
    mut_name = "My name is Abrar Khan"
    println("Mutable name: ${mut_name}")

}
