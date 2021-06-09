import java.util.*

fun main (arg: Array<String>) {
    val reader = Scanner(System.`in`)

    println("Tahun 1: ")
    var tahun1 = reader.nextInt()

    println("Tahun 2: ")
    val tahun2 = reader.nextInt()

   var int = 0

    while (int != tahun2) {

        tahun1 = tahun1 + 1

        if ((tahun1 % 400 == 0) || (tahun1 % 4 == 0 && tahun1 % 100 !=0 )) {

            if (tahun1 == tahun2){
                break
            }

            int++
            println(tahun1)

        }
    }
}