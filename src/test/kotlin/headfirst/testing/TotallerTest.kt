package headfirst.testing

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/** Тестирование с помощью библиотеки JUnit */
class TotallerTest {

    @Test
    fun `should Be Able To Add 3 And 4`() { // включение имени теста в `` дает возможность использовать пробелы
        val totaller = Totaller()
        assertEquals(3, totaller.add(3))
        assertEquals(7, totaller.add(4))
        assertEquals(7, totaller.total)
    }
}