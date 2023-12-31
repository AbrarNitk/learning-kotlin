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

```kotlin
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


# Nullable

- In Kotlin nullable types allow a variable to hold the null value
- `var name: String? = null`
- use safe calls `name?.length` to access the value of the variable
- elvis operator `?:` provides the default value in case of the value is null
- `val len = name?.length ?: 0`
- safe cast `as?` use the safe cast operator to perform safe cast that returns null if cast was unsuccessful
- `val stringLength: Int? = someValue as? String`
- `!!` explicitly throw the null pointer exception

```kotlin
val s: String?
// below len should also be type of null
val len: Int? = s?.length
// or assign a default value to it
val len: Int = s?.length ?: 0
```

## Nullable Types Under the hood

- Under the hood, @Nullable and @NotNull added to the types

```kotlin
fun foo(): String = "foo"
// Under the hood
@NotNull
public static final String foo() {
    return "foo"
}
```

```kotlin
fun foo(): String? = "foo"
// Under the hood
@Nullable
public static final String foo() {
   return "foo" 
}
```



# Lambda

## Syntax

```kotlin
{x: Int, y: Int -> x + y}
```

### Examples

- Full Syntax

```kotlin
list.any({x: Int -> x > 0})
```

- When lambda is the last argument it can be moved out of the parenthesis

```kotlin
list.any() {x: Int -> x > 0}
```

- if brackets are empty, they can be omitted

```kotlin
list.any {x: Int -> x > 0}
```

- also type can be omitted also

```kotlin
list.any {x -> x > 0}
```

- if it has only one argument it can be replaced with it

```kotlin
list.any { it > 0}
```

- multi line lambda

```kotlin
list.any {
    println("processing $it")
    it > 0
}
```

- destructuring declaration

```kotlin
map.mapValues { entry -> "${entry.key} -> ${entry.value}" }
map.mapValues { (key, value) -> "$key -> $value" }
```


## Using Collection Functions

- filter: filter out the elements based on predicate
- map: maps the element based on given mapper
- any: check if there is any element matching with the predicate
- find: it finds the element with the matching predicate
- first/firstOrNull: same as find
- count: counts the element based on the given predicate
- partition: divides the collection into two collections based on the given predicate
- groupBy: group the elements based on provided key
- associateBy: associate the elements with the given key and value as the collection value
    - key should be unique in the collection. if keys are not unique, duplicate keys will be
    - removed and last element will be choosen.
- associate: associate build a map based on specified keys and values
- zip: zip the elements of two lists as key value pair, if one of the list is the bigger sizes
    - the final list will be having size equal to the shorter list.
- zipWithNext: it zip elements with its adjacent element [(1, 2), (2, 3), (3, 4)]
- flatten: flatten the list of list in one single list
- flatMap: It combines two operations flat and map: first it will flat the element then it will use the
    - mapper function.



# Function types

```kotlin
val sum = {x: Int, y: Int -> x + y}
// OR
val newSum: (x: Int, y: Int) -> Int = {x, y -> x + y } 
```

## Calling Lambda directly

```kotlin
{ name -> println("Hey: $name") }("Abrar Khan")
// OR

run { println("Hey") }
```

## Lambda for Runnable

```kotlin
val run = Runnable { println("Hello Runnable") }
```

## Function types and nullability

- () -> Int? vs (() -> Int)?
- `() -> Int?`: Means return type of the function ins nullable
- `(() -> Int)?`: Means this lambda can be nullable

### How to call the nullable function

```kotlin
val fn: (() -> Int)? = null

// first way
if(fn != null) { fn() } // smart cast applies here

// another way
fn?.invoke()

```



# Member References

```kotlin
class Person(val name: String, val age: Int)
people.maxBy{ it.age }
people.maxBy(Person::age) // member reference
```

## Store a function in variable

```kotlin
fun isEven(i: Int): Boolean = i % 2 == 0
val predicate = ::isEven
// the above line is same as below line
val predicate1 = { i: Int -> isEven(i) }
```


## Bound and non-bound reference

```kotlin
class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
}

// This reference called non-bound
val agePredicate: (Person, Int) -> Boolean = Person::isOlder
val alice = Person("Alice", 29)
agePredicate(alice, 21) // true

// bound reference
// in the below example, isOlder bounded to alice object
val aliceAgePredicate: (Int) -> Boolean = alice::isOlder
aliceAgePredicate(21) // true

// The above code is same as
val aliceAgePredicate: (Int) -> Boolean = { ageLimit -> alice.isOlder(ageLimit) }
```

## Bound to this reference

```kotlin
class Person(val name: String, val age: Int) { 
    fun isOlder(val ageLimit: Int): Boolean = age > ageLimit 
    // bound function to this reference
   fun getAgePredicate() = this::isOlder // or ::isOlder
}
```



# return from Lambda

```kotlin

// labeled functions
list.flatMap {
    // this 
    if(it == 0) return@flatMap listOf<Int>()
    listOf(it, it)
}

// OR
list.flatMap l@{
  // this 
  if(it == 0) return@l listOf<Int>()
  listOf(it, it)
}

// solution using anonymous functions
fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap(fun(e): List<Int> {
        if (e == 0 ) return listOf<Int>()
        return listOf(e, e)
    })
}

// Another solution no return
fun duplicateNonZero(list: List<Int>): List<Int> {
  return list.flatMap {
    if (it == 0 ) 
        listOf()
    else 
        listOf(it, it)
  }
}

```



# Properties, OOP and Conventions

## Properties

- Java Property(setter and getter called the property)

```java
class JavaClass {
  private int foo = 0;

  public int getFoo() {
    return foo;
  }
  public void setFoo(int foo) {
    this.foo = foo;
  }
}
```

- Kotlin Property

```kotlin
class KotlinClass {
    var foo = 0
}
```

- property = field + accessor
- val = field + getter
- var = field + getter + setter
- use property directly not getter and setter method, under the hood getter and setters


### Properties without field

- property = accessor(s)
- val = getter
- var = getter + setter

```kotlin
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
      private set // make the setter private
      get() {
          return height == width
      }
}
```


## Field

- You can access `field` only inside accessors

```kotlin
class StateLogger { 
    var state = false
      set(value) {
          println("state has changed: " + "$field to $value")
        field = value
      }
}
```

## Default accessors

```kotlin
class A {
    var trivialProperty: String = "abc"
  // auto generate methods
  // get() = field
  // set(value: String) {
  //   field = value
  // }
}
```

- You always use property instead of getter or setter

## More About Properties

- Define a property in the Interface

```kotlin


interface User {
  val nickname: String
}

class FacebookUser(val accountId: Int) : User {
  override val nickname = getFaceBookName(accountId)

  fun getFaceBookName(val accountId: Int) {
    return accountId.toString()
  }
}

class Subscriber(val email: String): User {
    override val nickname: String
    get() = email.substringBefore('@')
}
```

### Extension Properties

```kotlin
var String.lastIndex: Int
  get() = this.length - 1

val String.indices: IntRange
  get() = 0..lastIndex
```

### Mutable Extension Property

```kotlin

var StringBuilder.lastChar: Char
  get() = get(length - 1)
  set(value: Char) {
      this.setCharAt(length - 1, value)
  }

```

## Lazy or late initialization of properties

## Lazy Property

- using `by lazy`
- it takes a lambda to provide the value

```kotlin
val lazyValue: String by lazy {
  println("computed!")
  "Hello"
}

class LazyProps {
  val lazyValue: String by lazy {
    println("computed!")
    "Hello"
  }
}
```

### `lateinit`

- it is to prevent from nullable types
- lateinit variables can not be val
- variable can not also be final
- it can not be null also
- can not be a primitive types
- do not want to initialize int the constructor but after that 


```kotlin
lateinit var myData: MyData
```



## Constructor

- var/val on parameter create a property

```kotlin
class Person(val name: String) {
    fun printName() {
        println(name)
    }
}

// OR

class Person(name: String) {
  val name: String
  init {
    this.name = name
  }
  fun printName() {
    println(name)
  }
}
```


### `extends` and `implements`

```kotlin
interface Base
class BaseImpl: Base

open class Parent

class Child: Parent() // constructor call
```

```kotlin
open class Parent(val name: String)
class Child(name: String): Parent(name)
```

```kotlin
open class Parent(val name: String)
class Child: Parent {
    constructor(name: String, param: Int): super(name)
}
```

- In kotlin while overriding the property, it means we are overriding the getter not a field

### Overriding the property


```kotlin
open class Parent {
    open val foo = 1
    init {
        println(foo)
    }
}

class Child: Parent() {
    override val foo = 2
}

fun main() {
    Child()
}

```


# Class Modifiers

## `enums`

```kotlin
enum class Color {
    BLUE, ORANGE, RED 
}

fun getDescription(color: Color) = 
        when(color) {
            Color.BLUE -> "cold"
            Color.ORANGE -> "mild"
            Color.RED -> "hot"
        }
```

### enum class with properties

```kotlin
enum class Color(val r: Int, val g: Int, val b: Int) {
  RED(255, 0, 0), ORANGE(255, 165, 0), BLUE(0, 0, 255);
  fun rgb() = (r * 256 + g) * 256 + b
}
```

### data class

- generates methods: equals, hashCode, copy, toString, and some others
- compiler only uses the properties defined inside the constructor while auto generating the methods

#### Examples

```kotlin
data class Contact(val name: String, val address: String)
contact.copy(address = "New Address") // only address will be change and the rest value will be the same
```

### Equal & reference equality

- set1 == set2 means `calls equals`
- set1 === set2 means `calls reference equality`
- default equals checks reference equality

```kotlin
class Foo(val a: Int, val b: Int) // default equals only with reference equality
data class Bar(val a: Int, val b: Int) // equals with member check
```

```kotlin
// Auto generated equals
data class Bar(val first: Int, val second: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (this !is Bar) return false
        return (first == other.first && second == other.second)
    }

    override fun hashCode(): Int = 
            first * 31 + second
  
}

```

### `sealed` modifier for class

- restricts class hierarchy
- all the subclasses must be in the same file

```kotlin
sealed class Expr
class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
   // Now here we do not need the else branch
}
```


### `inner` modifier

- adds reference to the outer class

```kotlin
class A {
    class B {
        inner class C {
            fun foo() {
                val a = this@A
                val b = this@B
            }
        }
    }
}
```

### class delegation

```kotlin

class Customer
interface Repository {
  fun getById(id: Int): Customer
  fun getAll(): List<Customer>
}

interface Logger {
  fun logAll()
}

// class delegation
// by repository delegates to the Repository
// by logger delegates to the Logger
class Controller(repository: Repository, logger: Logger): Repository by repository, Logger by logger

fun use(controller: Controller) {
    controller.logAll()
}

```


## Object, object expressions and companion objects

- `object` classes = singleton in java

```kotlin
object KSingleton {
    fun foo(){}
}

KSingleton.foo()

// This is equavalent to Java

public class JSingleton {
    // one public final static member
    // private constructor
    // one instance creator method
    // and members
}

```

### object expression

- it is a way to create an anonymous class
- it allows you to implement one or more interfaces, and you don't need to create a full-fledged named class
- object expression and object declaration are different
- object expression does not create a singleton object

```kotlin
val myObject = object : SuperType, Interface1, Interface2 {
    // Implementation of SuperType, Interface1, and Interface2 methods/properties
    // Additional properties and functions specific to this object expression
}

interface Greeter {
  fun greet(): String
}

fun main() {
  val greeter = object : Greeter {
    override fun greet(): String {
      return "Hello, I'm an anonymous object!"
    }
  }
  println(greeter.greet()) // Output: "Hello, I'm an anonymous object!"
}

```


### companion object

- special object inside a class
- can be used instead java static methods
- companion object can implement an interface
- companion object can be a receiver of extension function
- no static keyword, no static method

```kotlin
class A {
    private constructor()
    companion object: Abc<A> {
        override fun create() = A()
    }
}

fun <T> createNewInstance(factory: Factory<T>)
createNewInstance(A)
A.create()
```

### How To declare static members:

- at the top level
- inside objects
- inside companion object
- @JvmStatic to call a companion method from Java
- we can define extension function to companion objects 
- `inner` is not applicable to `object`



## Constants

- const(for primitive types and String)
- @JvmField(eliminate accessors)

### Compile-time constants

```kotlin
// the value will be inlined at the compile time
// means compiler replaces the value everywhere
const val answer = 42
```

### `@JvmField`

```kotlin
// no getter and setter generated for it
@JvmField
val prop = MyClass()

// same as in Java
public static final MyClass prop = new MyClass();
```

```kotlin
object A {
    @JvmField
    val prop = MyClass() // static field will be generated
}

class B {
    @JvmField
    val prop = MyClass() // regular field will be generated
}

```


## Generic interface and classes


### Generic Interface

```kotlin
interface List<E> {
    fun get(index: Int): E
}
```


### Generic Functions

```kotlin

fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    val dest = ArrayList<T>()
    for(e in this) {
        if((predicate(e))) dest.add(e)
    }
  return dest
}
```

#### Non-nullable upper bound

- In the below example elements of list cannot be nullable

```kotlin
fun<T: Any> foo(list: List<T>) {
    for(element in list) {
        
    }
}
```

- In the below example elements of the returned list will not be nullable

```kotlin
fun<T: Any> List<T?>.filterNotNull(): List<T>{}
```

- With Comparable upper bound

```kotlin
fun<T: Comparable<T>> max(first: T, second: T): T {
    return if(first > second) first else second
}
```

- Multiple constraints for a type parameter

```kotlin
fun <T> ensureTrailingPeriod(seq: T): T
    where T: CharSequence, T: Appendable {}
```


## Conventions


### Operator Overloading

```kotlin

class Point(val a: Int, val b: Int)

operator fun Point.plus(other: Point): Point {
    return Point(a + other.a, b + other.b)
}

fun addExample() { 
    val p = Point(1, 2) + Point(2, 3)
}
```

### Arithmetic Operator for overloading

| expression | function name | 
|:----------:|:-------------:|
|   a + b    |     plus      |
|   a - b    |     minus     |
|   a * b    |     times     |
|   a / b    |      div      |
|   a % b    |      mod      |
|     -a     |  unaryMinus   |


### Conventions

- Destructuring declaration & data classes
- The below class autogenerate 3 methods

```kotlin

```

```kotlin
data class Contact(val name: String, val email: String, val phoneNumber: String) {
    // auto generated
    fun component1() = name
    fun component2() = email
    fun component3() = phoneNumber
}
val (name, _, phoneNumber) = Contact("", "", "")
```


# Useful library functions

- run: run the block of code
- let: allows to check the argument for being non-null
  ```kotlin
    fun getEmail(): Email?
    val email = getEmail()
    if (email != null) sendEmail(email)
    // OR
    email?.let { e -> sendEmail(e) }
    // OR
    getEmail()?.let { sendEmail(it) }
    
  ```
- takeIf: returns the receiver object if it satisfies the given predicate, otherwise returns null
  ```kotlin
    issue.takeIf { it.status == FIXED }
  val number = 42
  number.takeIf { it > 10 } // 42
  number.takeIf { it > 50 } // null
  ```
- takeUnless: Just opposite to takeIf
- repeat: repeat given number of times `repeat(n)`
- use: use instead of try catch to close the resources automatically
- withLock
- synchronise



### Power of `inline`

- compiler substitutes a body of the function instead of calling it
- No performance overhead


## Collections and Sequences 

### Sequences

- lazy evaluation
- it stores the data and function together
- It does not run the functions until the result is not needed
- `val seq = listOf(1, 2, 3).asSequence()`



### Creating Sequences

```kotlin
generateSequence { Random.nextInt() }

// benefit
let input = generateSequence { readLine().takeIf { it != "exit" } }
```


### `yield`

- generate the sequences

```kotlin
val numbers = sequence { 
    var x = 0
  while (true) {
      yield(x++)
  }
}
```


```kotlin
sequence { 
    yield(value)
    doSomeThing()
    yieldAll(list)
    doSomethingElse()
    yieldAll(sequence)
}
```


## Library functions

```kotlin
val people = sequence { 
    var x = 0
  while (true){
      yield(x++)
  }
}
```

- people.filter { it.age > 5 }.size == people.count { it.age > 5 }
- people.sortedBy { it.age }.reversed() == people.sortedByDescending { it.age }
- people.map { p -> p.takeIf { it.isPublic }?.name }.filterNonNull() == people.mapNotNull
- map.getOrPut(1) { listOf() }
- groupBy is not lazy and create a map
- groupingBy is lazy



## Lambda and Receiver

### The `with` function

- It does remove the repeat of the variable usage
- this is called lambda with receiver
```kotlin

val sb = StringBuilder()
with(sb) {
    // here this is an implicit to sb
    // this.appendln("Alphabet: ")
    // but here this can be omitted
    appendln("Alphabet: ")
    for(c in 'a'..'z') {
        append(c)
    }
  toString()
}

```


### lambda vs lambda with receiver

```kotlin
val isEven: (Int) -> Boolean = { it % 2 == 0 } // lambda
val isOdd: Int.() -> Boolean = { this % 2 == 0 } // lambda with receiver

isEven(0)
1.isOdd()
```


### The `with` function declaration

```kotlin
inline fun <T, R>with(receiver: T, block: T.() -> R): R = receiver.block()

with(sb) {
    append("")
}

```

#### More useful library functions

- with
```kotlin
with(window) {
    // by default window is with
    width = 300
    height = 200
    isVisible = true
}
```
- T.run: like with, but extension and can be use safely with optional types
```
// only called if windowById["main"] exists 
windowById["main"]?.run {
    // by default window is with
    width = 300
    height = 200
    isVisible = true
}
```
- T.let
- T.apply: `apply` returns receiver as a result
- T.also: it takes regular lambda instead of this



### lambda and receiver

|                         | `{ ..this.. }` | `{ ..it.. }` |
|:-----------------------:|:--------------:|:------------:|
| return result of lambda |      run       |     let      |
|     return receiver     |     apply      |     also     |



## Kotlin Types

- If it is nullable type is it going be an object in the case of primitive types also
- List<Int> == List<Inetger>
- Array<Int> == Integer[]
- IntArray == int[]
- Kotlin.String == java.lang.String
- Any == Object
- () -> Boolean == Function0<Boolean>
- (Order) -> Int == Function1<Order, Int>
- (Int, Int) -> Int == Function2<Int, Int, Int>


### Types Hierarchy

- Instead of void we use Unit
- Nothing is different to Unit and void(It means function never returns)
- Nothing: a type has no value
- Unit: means the functions completes successfully
- Nothing: means the function never completes
- Nothing: mostly used where functions only throws exceptions
- Nothing: function have infinite loop
- Nothing is also equivalent to void

### Nullable Types

- Kotlin == Java
- Type? == @Nullable Type
- Type == @NotNull Type
- Type!(Nor Nullable, Nor NotNullable) == Type, for safe side Type? == Type
- Advice
- Most of the time Annotate Java Types
- Specify types explicitly 


### Make it an error for Nullable Types

- build.gradle

```kotlin
compileKotlin {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
    }
}
```
