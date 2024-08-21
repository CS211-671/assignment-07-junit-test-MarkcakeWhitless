package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s1;

    @BeforeEach
    void init(){
        s1 = new Student("6xxxxxxxx", "mark");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "mark");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "mark");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName(){
        Student s = new Student("6xxxxxxxxx", "mark");
        s.changeName("Moodang");
        assertEquals("Moodang", s.getName());
    }

    @Test
    @DisplayName("ทดสอบ toString")
    void testToString(){
        Student s = new Student("6xxxxxxxxx", "mark", 85);
        String expected = "{id: '6xxxxxxxxx', name: 'mark', score: 85.0}";
        assertEquals(expected , s.toString());
    }

    @Test
    @DisplayName("Test ID")
    void testIsID(){
        Student s = new Student("6xxxxxxxxx", "mark", 85);
        assertEquals("6xxxxxxxxx" , s.getId());
    }

    @Test
    @DisplayName("Test Constructor")
    void testConstructor(){
        Student s = new Student("6xxxxxxxxx", "mark");
        assertEquals("6xxxxxxxxx", s.getId());
        assertEquals("mark", s.getName());
        assertEquals(0, s.getScore());
    }

}