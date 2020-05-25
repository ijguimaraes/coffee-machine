// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var input = scanner.nextInt()
    print("$input ")
    while (input != 1) {
        if (input % 2 == 0) {
            input /= 2
        } else {
            input = input * 3 + 1
        }
        print("$input ")
    }
}
