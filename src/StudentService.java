import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void deleteByNim(String nim) {
        int before = students.size();

        List<Student> filtered = students.stream()
                .filter(s -> s.getNim() == null || !s.getNim().equalsIgnoreCase(nim))
                .collect(Collectors.toList());

        boolean removed = filtered.size() < before;

        students.clear();
        students.addAll(filtered);

        System.out.println(removed
                ? "Student with NIM " + nim + " has been deleted."
                : "Student with NIM " + nim + " not found.");
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        students.forEach(System.out::println);
    }
}
