package headfirst.chapter11

/** Лямбда-выражение, или лямбда, представляет собой тип объекта, который содержит блок кода.
 *
 * Лямбда-выражение начинается и завершается фигурными скобками {}:
 * {x: Int -> x + 5}
 *
 * Тут происходит то же самое, что при написании функции (к x прибавляется 5):
 * fun addFive(x: Int) = x + 5
 *
 * Лямбда-выражение может не получатьт параметров и просто возвращать значение, например строку «Pow!»:
 * {"Pow!"}
 * */
fun main(args: Array<String>) {

    /** Присваивание и выполнение кода лямбда-выражения */
    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    val result2 = addInts(6, 7) // сокращенная форма

    /** Лямбда-выражение принимает 2 параметра типа int и возвращет int */
    val add: (Int, Int) -> Int // объявление переменной лямбда-выражения
    add = { x: Int, y: Int -> x + y } // присваивание лямбда-выражения

    /** Лямбда-выражение не принимает параметров и возвращет String. Сокращенная запись */
    val greeting: () -> String = { "Hello!" }

    /** Единственный параметр может заменяться на it */
    val addFive: (Int) -> Int = { it + 5 } // аналогично val addFive: (Int) -> Int = { x -> x + 5 }
    /* val addFive = { it + 5 } Не компилируется, потому что компилятор не может определить тип параметра */

    /** Unit и лямбда-выражения без возвращаемого значения */
    val myLambda: () -> Unit = { println("Hi!") } // просто выводит, ничего не возвращает

    /* Вызываем метод и передаем в него лямбда-параметр */
    convert(20.0, { c: Double -> c * 1.8 + 32 })
    /* Лямбда-выражение можно вынести за скобки и сократить до it, если параметр всего один */
    convert(20.0) { c: Double -> c * 1.8 + 32 }
    convert(20.0) { it * 1.8 + 32 }
    /* Скобки можно опустить */
    convertFive { it * 1.8 + 32 }
}

/** Лямбда-выражение может использоваться как параметр функции */
fun convert(x: Double, converter: (Double) -> Double): Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double) : Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

/** Псевдонимы типов, которые можно использовать в коде */
typealias DoubleConversion = (Double) -> Double
/* использование: */
fun combine(lambda1: DoubleConversion,
            lambda2: DoubleConversion): DoubleConversion {
    return { x: Double -> lambda2(lambda1(x)) }
}

/* Позволяет обращаться к типу по имени StringArray вместо Array<String> */
typealias StringArray = Array<String>