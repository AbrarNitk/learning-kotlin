# First Course From Coursera


## Mac Installation

`brew update && brew install kotlin`


## Hello World

```kotlin

fun main() {
    val name = "Abrar Khan";
    println("Hello: ${name}");
}

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

