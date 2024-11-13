package headfirst.chapter12

data class Grocery(
    val name: String,
    val category: String,
    val unit: String,
    val unitPrice: Double,
    val quantity: Int
)

fun main(args: Array<String>) {
    val groceries = listOf(
        Grocery("Tomatoes", "Vegetable", "lb", 3.0, 3),
        Grocery("Mushrooms", "Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", "Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", "Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", "Frozen", "Pack", 3.0, 2)
    )

    /** Для сортировки, суммирования или других вычислений с типами, не имеющими естественного порядка, можно работать,
     * передав лямбда-выражение (критерий, как с этими типами работать) */

    /* Максимальное значение по полю unitPrice */
    val highestUnitPrice = groceries.maxBy { it.unitPrice }
    println("highestUnitPrice: $highestUnitPrice")
    /* Минимальное значение по полю quantity */
    val lowestQuantity = groceries.minBy { it.quantity }
    println("lowestQuantity: $lowestQuantity")
    /* Кол-во всех продуктов */
    val sumQuantity = groceries.sumOf { it.quantity }
    println("sumQuantity: $sumQuantity")
    /* Итоговая цена всех продуктов */
    val totalPrice = groceries.sumOf { it.quantity * it.unitPrice }
    println("totalPrice: $totalPrice")

    /** Фильтрация */

    /* Возвращает List с элементами groceries, у которых свойство category содержит «Vegetable» */
    val vegetables = groceries.filter { it.category == "Vegetable" }
    println("vegetables: $vegetables")
    /* filterNot возвращает элементы, для которых тело лямбда-выражения дает результат false.
    * В данном случае возвращает List с элементами groceries, у которых свойство category не содержит «Frozen» */
    val notFrozen = groceries.filterNot { it.category == "Frozen" }
    println("notFrozen: $notFrozen")

    /** Преобразования */

    /* Новый список List со значениями name каждого элемента Grocery в groceries. Исходный список не изменяется */
    val groceryNames = groceries.map { it.name }
    println("groceryNames: $groceryNames")
    /* Возвращает список List со всеми значениями unitPrice, умноженными на 0,5 */
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
    println("halfUnitPrice: $halfUnitPrice")
    /* Цепочка вызовов, состоящая из фильтрации и преобразования */
    val newPrices = groceries.filter { it.unitPrice > 3.0 }
        .map { it.unitPrice * 2 }
    println("newPrices: $newPrices")
}