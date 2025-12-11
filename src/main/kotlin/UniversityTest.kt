import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class UniversityTest {
    @Test
    fun testAddStudent() {
        val testUni = University()
        testUni.addStudent(Student("5", "test", "test", 100))

        assertEquals(testUni.studentList.size, 1)
        assertEquals(testUni.studentList[0].id, "5")
    }

    @Test
    fun testFindStudentById() {
        val testUni = University()
        testUni.addStudent(Student("3", "test", "test", 100))

        val searchedStudent = testUni.findStudentById("3")
        assertFalse(searchedStudent == null)
        assertEquals(searchedStudent?.id, "3")

        assertTrue(testUni.findStudentById("4") == null)
    }

    @Test
    fun testFindStudentsByCourse() {
        val testUni = University()
        testUni.addStudent(Student("0", "test", "science", 100))
        testUni.addStudent(Student("1", "test", "maths", 100))
        testUni.addStudent(Student("2", "test", "maths", 100))

        val foundStudents = testUni.findStudentsByCourse("maths")
        assertEquals(foundStudents.size, 2)

        val expectedIds = listOf("1", "2")
        foundStudents.forEach {
            assertTrue(it.id in expectedIds)
        }

        assertEquals(testUni.findStudentsByCourse("literature").size, 0)
    }
}