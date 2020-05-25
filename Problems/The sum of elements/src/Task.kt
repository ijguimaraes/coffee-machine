// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var sum = 0
    var input = 0
    do {
        sum += input
        input = scanner.nextInt()
    } while (input != 0)
    println(sum)
}