import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory


class StudentTest {
    @TestFactory
    fun testMultipleMarkVariations() =
        listOf(-1 to 0, 0 to 0, 100 to 100, 101 to 0).map {
            dynamicTest("Mark ${it.first} should give ${it.second}") {
                val test = Student("0", "test", "test", it.first)
                assertEquals(test.mark, it.second)
            }
        }

    @TestFactory
    fun testGetGradeVariations() =
        listOf(100 to "First", 70 to "First", 69 to "2/1", 60 to "2/1", 59 to "2/2", 50 to "2/2", 49 to "Third", 40 to "Third", 39 to "Fail", 0 to "Fail").map {
            dynamicTest("Mark ${it.first} should give a grade of ${it.second}") {
                val test = Student("0", "test", "test", it.first)
                assertEquals(test.getGrade(), it.second)
            }
        }
}