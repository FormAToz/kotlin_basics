package headfirst.chapter9

fun main() {
    /** Простые коллекции List, Set и Map неизменяемы. Если необходимо добавлять или удалять элементы, то существуют
     * изменяемые версии коллекций: MutableList, MutableSet и MutableMap */

    /* Массив, инициализированный значениями null, создается функцией arrayOfNulls */

    val shopping = listOf("Tea", "Eggs", "Milk")
    // shopping[0] = "Cookie" - не выйдет!

    val mShopping = mutableListOf("Tea", "Eggs")
    mShopping[0] = "Cookie" // или mShopping.set(0, "Cookie")
    mShopping.add("Milk")

    /* Сортировка в прямом, обратном порядке или перемешать */
    mShopping.sort()
    mShopping.reverse()
    mShopping.shuffle()

    /* Копирование в новый объект с созданием неизменяемой и изменяемой коллекций */
    val immutable = mShopping.toList()
    val mutable = mShopping.toMutableList()

    printCollection(mShopping)

    /* При добавлении элементов Set делает шаги:
    * 1) сравнивает хеш-код с хеш-кодом объектов в коллекции
    * 2) использует === для проверки указания на один и тот же объект
    * 3) использует == для сравнения значения со всеми объектами в коллекции (вызывает функцию equals) */
    val friendSet = setOf("Jim", "Sue", "Nick", "Jim")

    printCollection(friendSet)

    /* Set — неупорядоченная коллекция, которую невозможно отсортировать напрямую.
    Можно воспользоваться ее функцией toList() для копирования Set в List, а затем отсортировать List. */

    /* Оператор == можно использовать для сравнения содержимого двух множеств Set */
    val a = setOf(1, 2, 3)
    val b = setOf(3, 2, 1)
    println(a == b) // true

    /* Объявление и вывод на печать map */
    val map = mapOf("first" to 1, "second" to 2, "third" to 3) // mutableMapOf() - изменяемая коллекция
    for ((k, v) in map) {
        println("Key: $k, value: $v")
    }

    /* Можно создать Java-коллекции, например, функция arrayListOf создает коллекцию ArrayList,
     а функция hashMapOf — коллекцию HashMap. Но следует учитывать, что эти функции создают изменяемые коллекции. */
}

fun printCollection(collection: Collection<Any>) {
    for (item in collection) {
        println(item)
    }
}