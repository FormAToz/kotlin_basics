package headfirst.chapter5.canine

import headfirst.chapter5.Animal

open class Canine: Animal() {

    override fun roam() {
        println("The Canine is roaming")
    }
}
