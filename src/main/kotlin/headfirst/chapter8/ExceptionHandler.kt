package headfirst.chapter8

class ExceptionHandler {

    /* В Kotlin не нужно объявлять, что метод выдает исключение.
    Kotlin не различает проверяемые и непроверяемые исключения. */

    fun parse(str: String) {
        try {
            val x = str.toInt()
            println(x)
        } catch (e: NumberFormatException) {
            println("Exception!")
        } finally {
            println("parse() has ended")
        }
    }
}

fun main() {
    ExceptionHandler().parse("5")

    /** Использование try в качестве выражения */
    val str = "8"
    val result = try { // Попытаться присвоить result значение str.toInt(), иначе присвоить result значение null
        str.toInt()
    } catch (e: Exception) {
        null
    }

    /** Использование throw как выражения */
    /* Если w и hunger отличны от null, то значение свойства hunger переменной w присвоится новой переменной с именем h.
     Но если w или hunger содержит null, выдается исключение AnimalException.
    val h = w?.hunger ?: throw AnimalException() */
}