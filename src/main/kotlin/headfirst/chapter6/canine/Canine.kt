package headfirst.chapter6.canine

import headfirst.chapter6.Animal

abstract class Canine: Animal() {

    override fun roam() {
        println("The Canine is roaming")
    }
}
