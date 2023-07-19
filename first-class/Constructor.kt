class OldPerson(name: String) {
    val name: String
    init {
        this.name = name
    }
    fun printName() {
        println(name)
    }
}


class Person {
    var name: String
    var age: Int
    fun printName() {
        println(name)
    }

    constructor(name: String) : this() {
        this.name = name
    }

    constructor(name: String, age: Int) : this(name) {
        this.name = name
        this.age = age
    }

    constructor() {
        this.name = ""
        this.age = 0
    }
}

fun main() {
    val person = Person("Abrar Khan", 10)
    person.printName()
}