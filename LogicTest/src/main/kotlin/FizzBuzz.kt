import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)

    println("angka: ")
    val angka = reader.nextInt()

    for (i in 1..angka){
        when {
            (i % 3 == 0 && i % 5 == 0) -> println("FizzBuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println("$i")
        }
    }
}



