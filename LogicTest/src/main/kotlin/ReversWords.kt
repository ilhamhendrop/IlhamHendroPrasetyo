import java.util.*

fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)

    println("Input Kata: ")
    val string: String = scanner.nextLine()

    println("Into")
    println(reversWord(string))

}

fun reversWord(string: String): String {
    val strList = string.split(" ")
    val sb = StringBuilder()

    for (items in strList) {
        if (items != "") {
            val rev = StringBuilder(items).reverse().toString()

            sb.append("$rev ")
        }
    }

    return sb.toString()
}