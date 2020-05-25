// Posted from EduTools plugin
import java.util.*

fun main(args: Array<String>) {
    var d = 0
    var c = 0
    var b = 0
    var a = 0
    val scanner = Scanner(System.`in`)
    val numberOfGrades = scanner.nextInt()
    repeat(numberOfGrades) {
        val grade = scanner.nextInt()
        when (grade) {
            2 -> d++
            3 -> c++
            4 -> b++
            5 -> a++
        }
    }
    println("$d $c $b $a")
}