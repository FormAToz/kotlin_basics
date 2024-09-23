package headfirst.chapter7

/*
Все классы в Kotlin унаследуются от класса Any.

data преобразует класс в класс данных. Не может быть открытым или абстрактным.
Классы данных автоматически переопределяют свои функции equals для изменения поведения оператора ==,
чтобы равенство объектов проверялось на основании значений свойств каждого объекта.

hashCode объектов с одинаковыми полями тоже будут равны.
*/
data class Recipe(val title: String, val isVegetarian: Boolean) {
    /* !!! не будет включено ни в какие сгенерированные функции (equals, copy и тд.), т. к. не определено
    в первичном конструкторе
    */
    var mainIngredient = ""

    /* Пример объявления вторичного конструктора с вызовом первичного */
    constructor(titleParam: String) : this(titleParam, false) {
        //Код, выполняемый при вызове вторичного конструктора
    }
}

/* Значения по умолчанию */
fun findRecipes(title: String = "", ingredient: String = "", isVegetarian: Boolean = false, difficulty: String = "") {
    //Код поиска рецептов
}

fun main() {
    val r1 = Recipe("Chicken Bhuna", false)
    val r2 = Recipe("Chicken Bhuna", false)
    println("r1 == r2: ${r1 == r2}") // true

    /* Копирование в новый объект с измененным свойством. Исходный объект остается без изменений */
    val r3 = r1.copy(isVegetarian = true)
    println("Copy: $r3")

    /* Альтернативный механизм обращения к значениям свойств объекта - функция componentN,
    где N — количество извлекаемых свойств (в порядке объявления).
    Эквивалентно val title = r.title
    */
    val title = r1.component1()
    println("Title: $title")

    /* Функция componentN предназначена для деструктуризации - разбиение объекта на компоненты.

    Пример создания двух переменных и присвоение значения одного из свойств r1 каждой переменной
    Эквивалентно val title = r.component1()
                 val vegetarian = r.component2(),
    но более компактно
    */
    val (title2, vegetarian) = r1
    println("Title2: $title2, vegetarian: $vegetarian")

    /* Оператор === всегда проверяет, ссылаются ли две переменные на один объект. */
    println("r1 === r2: ${r1 === r2}") // false

    /* оператор == проверяет только свойства title и isVegetarian, определенные в конструкторе класса данных */
    val r4 = Recipe("Thai curry", false)
    r4.mainIngredient = "Chicken"
    val r5 = Recipe("Thai curry", false)
    r5.mainIngredient = "Duck"
    println("r4 == r5: ${r4 == r5}") // true

    /* Для определения поля difficulty придется определить предыдущие 3 */
    val recipes = findRecipes("", "", false, "Easy")

    /* Или использовать именованный параметр для присвоения */
    val recipes2 = findRecipes(difficulty = "Easy")

    /* вызов вторичного конструктора */
    val r7 = Recipe("Chicken")
    println("Chicken: $r7")
}
