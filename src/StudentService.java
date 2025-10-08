import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }
}
