enum class Gender { MALE, FEMALE }

data class Hero (
        val name: String,
        val age: Int,
        val gender: Gender?
)

fun main() {
    val heroes = listOf(
            Hero("The Captain", 60, Gender.MALE),
            Hero("Frenchy", 42, Gender.MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, Gender.FEMALE),
            Hero("First Mate", 29, Gender.MALE),
            Hero("Sir Stephen", 37, Gender.MALE)
    )
    // last: last element in the list
    println(heroes.last().name)

    // firstOrNull: based on the predicate
    println(heroes.firstOrNull { it.age == 29 }?.name)
    println(heroes.firstOrNull { it.age == 30 }?.name)

    // first: it throws the exception if no element is found in the list
    try {
        println(heroes.first { it.age == 30 }.name) // NoSuchElement Exception
    } catch(e: NoSuchElementException) {
        println(e)
    }

    // how many people are different age
    println("count of people with distinct age: ${ heroes.map { it.age }.distinct().size }")

    // filter and count with age lesser than 30
    println("People of age lesser than 30: ${heroes.filter { it.age < 30 }.size}")

    // partition the collection into two, younger and oldest
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println("Youngest Count: ${youngest.size}, Oldest Count: ${oldest.size}")

    // mayBy function age
    println("person maxBy age: ${heroes.maxBy { it.age }.name}")

    // check if all people younger than the age of 50
    println("check if all people with age lesser than 50: ${heroes.all{ it.age < 50 }}")

    // check if anyone is FEMALE
    println("check if any one is female: ${heroes.any { it.gender == Gender.FEMALE }}")
}
