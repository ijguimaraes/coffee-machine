// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextInt()
    var count = 1
    var actualDigit = 1
    while (count <= input) {
        var aux = 1
        while (aux <= actualDigit && count <= input) {
            print("$actualDigit ")
            aux++
            count++
        }
        actualDigit++
    }
}