import java.util.*

fun main(arg: Array<String>){

    val scanner = Scanner(System.`in`)

    println("Masukan Kata: ")
    val inString: String = scanner.nextLine()

    if (PolindromeString(inString)) {
        println("$inString # --> palindrome ")
    } else {
        println("$inString # --> not palindrome")
    }

}

fun PolindromeString(string: String) : Boolean {
    val sb = StringBuilder(string)
    val reverse = sb.reverse().toString()

    return string.equals(reverse, ignoreCase = true)
}