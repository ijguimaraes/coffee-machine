// Posted from EduTools plugin
import java.util.Scanner

fun main(args: Array<String>) {
    val pairSum = 20
    val scanner = Scanner(System.`in`)
    val input1 = scanner.nextInt()
    val input2 = scanner.nextInt()
    val input3 = scanner.nextInt()
    println(input1 + input2 == pairSum || input1 + input3 == pairSum || input2 + input3 == pairSum)
}