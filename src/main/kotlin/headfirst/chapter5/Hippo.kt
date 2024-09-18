package headfirst.chapter5

class Hippo: Animal() { /* Наследование и вызов конструктора Animal */
    /* Переопределение свойств суперкласса */
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}
