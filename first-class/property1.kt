import java.util.HashMap;

interface User {
    val nickname: String
}

class FacebookUser(private val accountId: Int) : User {
    override val nickname = getFaceBookName(accountId)

    private fun getFaceBookName(accountId: Int): String {
        println("calculating the name")
        return accountId.toString()
    }
}

class Subscriber(private val email: String): User {
    override val nickname: String
        get() {
            println("calculating the subscriber name")
            return email.substringBefore('@')
        }
}

fun main() {

    val hm = HashMap<String, String>();
    hm["v1"] = "v1"
    hm["v2"] = "v2"

    println("Used Java Map: $hm")

    val fb: User = FacebookUser(12345)
    println("${fb.nickname}, ${fb.nickname}")

    val subscriber: User = Subscriber("foo-subscriber@gmail.com")
    println("${subscriber.nickname}, ${subscriber.nickname}")
}