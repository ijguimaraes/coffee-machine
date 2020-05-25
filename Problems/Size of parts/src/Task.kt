// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var fixed = 0
    var reject = 0
    var ready = 0
    val numberOfParts = scanner.nextInt()
    repeat(numberOfParts) {
        val part = scanner.nextInt()
        when (part) {
            1 -> fixed++
            -1 -> reject++
            0 -> ready++
        }
    }
    println("$ready $fixed $reject")
}