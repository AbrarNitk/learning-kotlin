# First Course From Coursera

- [Link](https://www.coursera.org/learn/kotlin-for-java-developers/)

## Mac Installation

`brew update && brew install kotlin`


## Hello World

```kotlin

fun main() {
    val name = "Abrar Khan";
    println("Hello: ${name}");
}

```

## Compile the Program


```
kotlinc control.kt -include-runtime -d control.jar
```

## Run the Program

```
java -jar control.jar
```


## Function

- can be declared without the class
- syntax

```kotlin
fun fun_name(val name: String, val age: Int) {
    return "foo"
}
```

## Variables

- val: immutable type `val name: String = "Hii"`
- var: mutable type `var name: String = "Ak 47"`
- local type inference `var age = 45`
- once a type is int we can not assign string to it
- there is immutable list as well in `val list = listOf("Java")` `list.add("Kotlin") will throw an error`
- mutable list `val list = mutableListOf("Java")`
- we can not define a same name variable twice, it will result conflicting


## Functions

```
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun min(a: Int, b: Int): Int = if (a > b) b else a;
```

```
fun topLevel() = 1
```

```
Member Function
class A {
    fun member() = 2
}

// Local Function 
fun other() {
    fun another() = 3
}

```

- we can call top level function from java as static function, which name 
corresponds to the file name.
- @JvmName("Name of the class") keep the name for the Jvm class


### Function with default args

```
fun displaySeparator(char: Char = '*', size: Int = 10) {
    repeat(size) {
        println(char)
    }
}

```

### Returning a value from a function


```kotlin

fun funName(): return_type {
    body
    return statement;
}

```

- `Unit` types are like void in other langs

```kotlin
fun birthdayGreeting(): Unit {
    println("Happy Birthday, Rover!")
    println("You are now 5 years old!")
}
```

- Returning a string

```kotlin
fun birthdayGreeting(val name: String, val age: Int): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}
```

- named arguments

```kotlin
println(birthdayGreeting(name = "Rex", age = 2))
```

- default arguments

```kotlin
fun birthdayGreeting(name: String = "Rover", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}
```


## Control Structure

### when as switch

```
enum class Color {
    BLUE, ORANGE, RED
}

fun getDescription(color: Color): String {
    when(color) {
        BLUE -> "cold"
        ORANGE -> "mild"
        RED -> "hot"
    }
}

// equal or with when
fun respondToInput(input: String) = when (input) {
    "y", "yes" -> "I am glad that you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I do not understand you"
}

// Any expression can be used as a branch
fun mix(c1: Color, c2: Color) = 
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE,
        setOf(YELLOW, BLUE) -> GREEN,
        else -> throw Exception("Dirty Color")
    }

// Checking Types with When
when(pet) {
    is Cat -> pet.meow()
    is Dog -> pet.woof()
}

// capturing when subject in a Variables

fun getSound(): String = 
    when(val pet = getMyFavouritePet()) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> "---"
    }

// checking conditions: when without argument
fun updateWeather(degrees: Int) {
    val (d, c) = when {
        // any boolean condition as branch condition
        degrees < 5 -> "color" to BLUE
        degress < 23 -> "mild" to ORANGE
        else -> "hot" to RED
    }
}
```

## Loops

```

// while loop
while(condition) {}


// do-while loop
do {
} while(condition)


// for loop
val list = listOf("a", "b", "c")
for(s in list) {
    print(s)
}


// or use type also
for(s: String in list) {}


// Iterating with Index
for((index, element) in list.withIndex()) {
    println("${index}: ${element}")
}


// Iterating over range
for(x in 1..9) {
    println(x)
}


// until in range(9 will be excluded)
for(x in 1 until 9) { print(x) }

// Iterating with step
for(x in 9 downTo 1 step 2){}
```

## `in` checks and ranges

- `for(i in 1..9)`
- `c in 'a'..'z'`

### not in a range

- `c !in '0'..'9'`
- `fun isNotDigit(c: Char) = c !in '0'..'9'`

### in as when condition

```kotlin

fun recognise() = when(c) {
    in '0'..'9' -> "It is digit"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter"
    else -> "I do not know"
}
```

## Different Ranges

- `1..9`
- `1 until 10`
- `'a'..'z'`
- `"ab".."az"`
- `startDate..endDate`

### Storing ranges

- val intRange: IntRange = `1..9`
- val anotherIntRage: IntRange = `1 until 10`
- val charRange: CharRange = `'a'..'z'`
- val stringRange: ClosedRange<String> = `"ab".."az"`
- val dateRange: ClosedRange<MyDate> = `startDate..endDate`

### Comparing Strings

`"ball" in "a".."k"` => `a <= "ball" && "ball" <= "k"`

### Range of custom types

```kotlin
class MyDate: Comparable<MyDate>
```

```kotlin
if (myDate.compareTo(startDate) >= 0 && myDate.compareTo(endDate) <= 0) {}
if (startDate <= myDate && myDate <= endDate) {}
if (myDate in startDate..endDate) {}
```

### Belonging to collection

```kotlin
// both are same
if(element in list) {} 
if (list.contains(element)) {}
```

# Exceptions

- No difference between unchecked and checked exceptions
- Your function does need to specify which exception it can throw
- It does also ned not to handle the exceptions

```kotlin
// Example
val percentage = if(number in 0..100) { number }
                    else {
                        throw IllegalArgumentException("Number must be between 0 and 100: $number")
                    }

```

## `try` is an expression

```kotlin
val number = try {
    Integer.parseInt(string)
} catch (e: NumberFormatException) {
    // or assing null
    // null
    return e
}
```

# Extension Functions

- we have to import the extension function wherever we have to use them
- we can't call private function of the extended class from extension functions  
- extension function work in the static function fashion
- Extensions are static java functions under the hood
- No override for extension functions in Kotlin
- Extensions can overload the members

## Example

```kotlin
fun String.lastChar() = this.get(this.length - 1)
val c: Char = "abc".lastChar()
```

## Calling Extension function from Java

Let's say we have a file `StringExtensions.kt` in which the below function is defined

```kotlin
// we can omit this keyword also 
fun String.lastChar() = get(length - 1)
```

If we have to call it in Java let's say in file JavaClass.java

```java
import static StringExtensions.lastChar;
char ch = lastChar("abc")
```

## Extension function: `until` using infix form

```kotlin
infix fun Int.until(to: Int): IntRange
// call type 1
1.until(10)
// OR
1 until 10
```

```kotlin
infix fun <A, B> A.to(that: B): Pair(this, that)
"Answer" to 42

```