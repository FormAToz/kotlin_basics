package headfirst

fun main() {
    var a = 1 // изменяемая переменная
    val b = 2 // неизменяемая переменная

    var c: Short = 3 // явное определение типа переменной
    var myArray: Array<Byte> = arrayOf(1, 2, 3) // явное определение типа массива

    val x = 3
    val y = 4
    println(if (x > y) "x is greater than y" else "x is not greater than y") // вывод на основе выражения "if"

    forArrayIndexWithItem()
}

/** Функции */

/* :Unit означает, что функция не возвращает значения (аналог void). Эта часть не обязательна, и ее можно опустить */
fun printSum(int1: Int, int2: Int): Unit {
    val result = int1 + int2
    println(result)
}

/* Тело функции max состоит из единственного выражения, результат которого возвращается функцией */
fun max(a: Int, b: Int): Int {
    val maxValue = if (a > b) a else b
    return maxValue
}

/* Более короткая запись:
fun max(a: Int, b: Int): Int = if (a > b) a else b

Еще короче - компилятор знает, что a и b имеют тип Int, и поэтому может определить возвращаемый тип по выражению:
fun max(a: Int, b: Int) = if (a > b) a else b
*/

/** Перебор значений */

/* Оператор .. включает завершающее число в диапазоне */
fun forDotted() {
    for (x in 1..100) println(x) // вывод чисел от 1 до 100
}

/* Оператор until исключает завершающее число в диапазоне */
fun forUntil() {
    for (x in 1 until 100) println(x) // вывод чисел от 1 до 99
}

/* Вывести числа в обратном порядке */
fun forDownTo() {
    for (x in 15 downTo 1) println(x) // вывод чисел от 15 до 1
}

/* По умолчанию операторы .., until и downTo перебирают диапазон с единичным шагом.
При желании можно увеличить размер шага при помощи ключевого слова step */
fun forDottedByStep() {
    for (x in 1 .. 100 step 2) println(x) // вывод нечетных чисел в диапазоне от 1 до 100
}

/* Перебор элементов массива */
val array = arrayOf("one", "two", "three")
fun forArrayItem() {
    for (item in array) {
        println("$item is an item in the array")
    }
}

/* Перебор элементов массива по индексу */
fun forArrayIndex() {
    for (index in array.indices) {
        println("Index $index has item ${array[index]}")
    }
}

/* Перебор массива по индексу и элементу */
fun forArrayIndexWithItem() {
    for ((index, item) in array.withIndex()) {
        println("Index $index has item $item")
    }
}