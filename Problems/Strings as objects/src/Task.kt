fun main() {
    val input = readLine()!!

    if (input.isEmpty()) {
        println()
    } else if (input.first() == 'i') {
        val result = input.drop(1)
        println(result.toInt() + 1)
    } else if (input.first() == 's') {
        val result = input.drop(1)
        println(result.reversed())
    } else {
        println(input)
    }
}
