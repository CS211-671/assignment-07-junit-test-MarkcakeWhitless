package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class StudentListTest {

    private StudentList studentList;
    private Student student;

    @BeforeEach
    void init() {
        studentList = new StudentList();
        student = new Student("61111112", "Jackson");
    }

    @Test
    @DisplayName("Should add new student with ID and name")
    void testAddNewStudentWithIdAndName() {
        studentList.addNewStudent("61111112", "Jackson");
        Student student = studentList.findStudentById("61111112");
        assertNotNull(student);
        assertEquals("Jackson", student.getName());
    }

    @Test
    @DisplayName("Should add new student with ID, name, and score")
    void testAddNewStudentWithIdNameAndScore() {
        studentList.addNewStudent("61111113", "Jackson", 95.0);
        Student student = studentList.findStudentById("61111113");
        assertNotNull(student);
        assertEquals("Jackson", student.getName());
        assertEquals(95.0, student.getScore());
    }

    @Test
    @DisplayName("Should add student with empty ID or name")
    void testAddStudentWithEmptyIdOrName() {
        studentList.addNewStudent("61111113", "Jackson");
        Student student = studentList.findStudentById("61111113");
        assertNotNull(student);
        assertEquals("Jackson", student.getName());
    }

    @Test
    @DisplayName("Should give score to existing student by ID")
    void testGiveScoreToId() {
        studentList.addNewStudent("61111113", "Jackson");
        studentList.giveScoreToId("61111113", 85.0);
        Student student = studentList.findStudentById("61111113");
        assertNotNull(student);
        assertEquals(85.0, student.getScore());
    }

    @Test
    @DisplayName("Should view grade of student by ID")
    void testViewGradeOfId() {
        studentList.addNewStudent("61111113", "Jackson", 75.0);
        String grade = studentList.viewGradeOfId("61111113");
        assertNotNull(grade);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("Should return null for grade of non-existent student ID")
    void testViewGradeOfNonExistentId() {
        String grade = studentList.viewGradeOfId("999");
        assertNull(grade);
    }

    @Test
    @DisplayName("Should return list of all students")
    void testGetStudents() {
        studentList.addNewStudent("61111113", "Jackson");
        studentList.addNewStudent("61111114", "Michael");
        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
        assertEquals("Jackson", students.get(0).getName());
        assertEquals("Michael", students.get(1).getName());
    }
}
