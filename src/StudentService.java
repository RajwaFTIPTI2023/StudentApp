import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void deleteByNim(String nim) {
        boolean removed = students.removeIf(s -> s.getNim() != null && s.getNim().equalsIgnoreCase(nim));
        if (removed) {
            System.out.println("Student with NIM " + nim + " has been deleted.");
        } else {
            System.out.println("Student with NIM " + nim + " not found.");
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }
}
