// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var firstPosition = 0
    var largest = Int.MIN_VALUE
    var position = 1
    while (scanner.hasNext()) {
        val number = scanner.nextInt()
        if (largest < number) {
            largest = number
            firstPosition = position
        }
        position++
    }
    println("$largest $firstPosition")
}