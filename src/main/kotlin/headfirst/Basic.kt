package headfirst

fun main() {
    var a = 1 // изменяемая переменная
    val b = 2 // неизменяемая переменная

    var c: Short = 3 // явное определение типа переменной
    var myArray: Array<Byte> = arrayOf(1, 2, 3) // явное определение типа массива

    val x = 3
    val y = 4
    println(if (x > y) "x is greater than y" else "x is not greater than y") // вывод на основе выражения "if"
}
