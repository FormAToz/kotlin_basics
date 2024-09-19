package headfirst.chapter6

import headfirst.chapter6.canine.Wolf

/* Абстрактному классу не нужен модификатор 'open' */
abstract class Animal: Roamable {

    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

fun main(args: Array<String>) {

    val animals = arrayOf(Hippo(), Wolf())
    for (item in animals) {
        item.roam()
        item.eat()
    }
    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)

    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())
    for (item in roamables) {
        item.roam()
        if (item is Animal) { /* Проверка отношения к заданному классу (или одному из его подклассов) */
            item.eat()
        }
    }
}
