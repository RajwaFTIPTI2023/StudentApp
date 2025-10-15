import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {
    // gunakan MM (huruf besar) untuk bulan
    private static final DateTimeFormatter dob_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentService service = new StudentService();

            while (true) {
                System.out.println("\n=== Student Management Menu ===");
                System.out.println("1. Add Student");
                System.out.println("2. List Students");
                System.out.println("3. Delete Student (Nim)");
                System.out.println("99. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter NIM: ");
                        String nim = scanner.next();
                        scanner.nextLine(); // consume newline

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        LocalDate dob = null;
                        while (true) {
                            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                            String dobInput = scanner.nextLine().trim();
                            try {
                                dob = LocalDate.parse(dobInput, dob_format);
                                break;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                            }
                        }

                        // pindahkan input alamat ke luar loop DOB
                        System.out.print("Enter Address: ");
                        String alamat = scanner.nextLine().trim();

                        Student student = new Student();
                        student.setNim(nim);
                        student.setName(name);
                        student.setDOB(dob);     // sesuai method milikmu
                        student.setAlamat(alamat);

                        service.addStudent(student);
                        break;

                    case 2:
                        service.listStudents();
                        break;

                    case 3:
                        System.out.print("Enter NIM to delete: ");
                        String deleteNim = scanner.nextLine().trim();
                        service.deleteByNim(deleteNim);
                        break;

                    case 99:
                        System.out.println("Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
