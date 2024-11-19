package headfirst.concurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.sound.sampled.AudioSystem

/** Сопрограммы позволяют выполнять код асинхронно.
 *
 * Представляет нечто вроде облегченного потока. Они используют общий пул потоков, и в одном потоке могут выполняться
 * несколько сопрограмм */

/* suspend сообщает компилятору, что функция может приостанавливаться */
suspend fun playBeats(beats: String, file: String) {
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            delay(100 * (part.length + 1L)) // delay приостанавливает текущую сопрограмму
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(
        File(file)
    )
    clip.open(audioInputStream)
    clip.start()
}

suspend fun main() {
    /* Запуск сопрограммы в фоновом режиме */
    runBlocking { // блокирует текущий поток до завершения выполнения содержащегося в ней кода
        launch { playBeats("x-x-x-x-x-x-", "src/main/resources/toms.aiff") } // запуск сопрограммы
        playBeats("x-----x-----", "src/main/resources/crash_cymbal.aiff")
    }
}
