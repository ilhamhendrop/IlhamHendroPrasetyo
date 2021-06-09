import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    println("Input N: ")
    val number = scanner.nextInt()

    var first = 0
    var second = 1
    var third = first + second

    while (third <= number){
        first = second
        second = third
        third = first + second
    }

    val hitung = (Math.abs(third - number) >= Math.abs(second - number))?:second ?:third

    print(hitung)
}

