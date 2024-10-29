package headfirst.chapter10

/** Создание функции, возвращающей обобщенный тип */
fun getPets(breed: String): MutableList<Pet> {
    //Получение объектов Duck нужного вида
    return mutableListOf(Pet("Donald"))
}

/** Создание класса с ограниченным типом */
class Zoo<T : Pet>

/** Создание функции, получающей обобщенный тип */
fun printAnimals(pets: MutableList<Pet>) {
    for (animal in pets) {
        animal.type()
    }
}

fun main(args: Array<String>) {

    /** Создание экземпляра обобщенного класса */
    val petList: MutableList<Pet>
    petList = mutableListOf(Pet("Duck"), Pet("Fish"), Pet("Dog"))
    printAnimals(petList)
}