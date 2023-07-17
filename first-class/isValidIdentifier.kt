fun isValidIdentifier(s: String): Boolean {

    fun isValidCharacter(c: Char): Boolean = c == '_' || c in '0'..'9' || c in 'a'..'z' || c in 'A'..'Z'

    if(s.isEmpty() || s[0] in '0'..'9') {
        return false
    }

    for(c in s) {
        if(!isValidCharacter(c)) {
            return false
        }
    }
    return true
}

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}