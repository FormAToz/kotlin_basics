package headfirst.chapter6

interface Roamable {

    /* Св-ва интерфейса абстрактны по умолчанию. инициализироваться не могут, но можно вернуть значение через геттер */
    val velocity: Int
        get() = 20

    fun roam()

    /**
    В интерфейсах не может использоваться ключевое слово «field», поэтому нельзя базовое значение свойства:
    var velocity: Int
        get() = 20
        set(value) {
            field = value  - ошибка компиляции
        }

    Этот код компилируется, потому что в нем не используется ключевое слово field.
    Тем не менее этот код не обновляет базовое значение свойства:
    var velocity: Int
        get() = 20
        set(value) {
            println("Unable to update velocity")
        }
     */
}