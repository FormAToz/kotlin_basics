package headfirst.chapter8

class NullSafety {

    var param = 10
    var inner: NullSafety? = null

    fun printParam() {
        println("Param: $param")
    }
}

fun main() {
    /** По умолчанию типы Kotlin не поддерживают значения null. Нужно явно указать, что ее тип является null-совместимым:
     * null-совместимый тип способен хранить значения null */
    var ns: NullSafety? = NullSafety()

    /* Безопасный вызов без проверки на null: */
    println(ns?.param) // 10
    ns?.printParam()

    /* Безопасное обращение к св-ву вернет null, а функция не будет вызвана: */
    ns = null
    println(ns?.param) // null
    ns?.printParam() // не будет вызвано

    /* Цепочка безопасных вызовов:
    * если ns и inner не равны null, то вернуть param. Иначе вернуть null */
    ns?.inner?.param

    /* Безопасный вызов для присваивания:
    * если ns равен null, то просвоить null. Иначе присвоить param. Соответственно у x будет тип Int? */
    var x = ns?.param
    /* Присваивание значения, если ns != null. Если ns == null, то код ничего не делает */
    ns?.param = 6

    /* Компилятор понимает, что массив может содержать String и null, таким образом массив должен
    * иметь тип Array<String?>: */
    val myArray = arrayOf("Hi", "Hello", null)
    for (el in myArray) {
        print("${el} ")
    }

    /** Использование let{} */
    println("\n** Использование let *")

    /* Код в теле будет выполняться только если значение ns отлично от null */
    ns = NullSafety()
    ns?.let {
        println(it.param) // «it» — не-null-совместимая версия ns, которая содержит ссылку на тот же объект NullSafety
    }

    /* Операции с элементами массива, отличными от null */
    for (el in myArray) {
        el?.let {
            println(it)
        }
    }

    /* Получить объект NullSafety?, и если он не равен null, вызвать для него param */
    getNewInstance()?.let {
        println(it.param)
    }

    /** Элвис-оператор ?: */
    println("\n** Элвис-оператор *")

    /* Альтернатива для if. Возвращает значение из левой части, если целое выражение 'ns?.param' не null.
    * Иначе возвращается значение из правой части */
    println(ns?.param ?: 6) // 10
    ns = null
    println(ns?.param ?: 6) // 6

    /** Оператор проверки на неопределенность !! */
    println("\n** Оператор проверки на неопределенность *")

    /* Он не обеспечивает безопасность кода посредством проверки null, а намеренно выдает NullPointerException,
    * если что-то оказывается равным null */
    ns = getNull()
    var y = ns!!.param // если ns или param равно null, выдается исключение NullPointerException
}

fun getNewInstance(): NullSafety? {
    return NullSafety()
}

fun getNull(): NullSafety? {
    return null
}
