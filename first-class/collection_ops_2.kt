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

    val mapByAge: Map<Int, List<Hero>> = heroes.groupBy { x -> x.age }
    println("Group By Age: $mapByAge")

    val (age, group) = mapByAge.maxBy { (_, group) -> group.size}!!
    println("group with max number of people: Age: ${age}, ${group}")

    // associateBy: It associates the whole object
    val mapByName: Map<String, Hero> = heroes.associateBy { it.name }
    println("Frenchy Age: ${mapByName["Frenchy"]?.age}")
    println("Frenchy Age: ${mapByName.getValue("Frenchy").age}")
    println("Random Age: ${mapByName["Random"]?.age ?: 0}")


    // associate: It associates the provided value
    val mapByNameAssociate: Map<String, Int> = heroes.associate { it.name to it.age }
    println("Getting Unknown: ${mapByNameAssociate.getOrElse("unknown") { 0 }}")

}
