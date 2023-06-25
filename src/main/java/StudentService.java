import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {
    // Service class for service layer is to handle service logic
    StudentRepository repository = new StudentRepository();
    Scanner input = new Scanner(System.in);

    // Step 7 -Method to call  createTable() method from Repository layer
    // To get access  to method in Repository class
    public void createTable() throws SQLException {
        repository.createTable();
    }

    // Step 9-Method to create registered  student
    public void safeStudent() {
        System.out.println("Name:  ");
        String name = input.nextLine();
        System.out.println(" Last Name:  ");
        String Lastname = input.nextLine();
        System.out.println("City:  ");
        String City = input.nextLine();


        System.out.println("Age:  ");
        int age = input.nextInt();
        System.out.println("Name:  ");

        Student newStudent = new Student(name, Lastname, City, age);
        repository.safe(newStudent);

    }

    public void getAllStudents() throws SQLException {
        repository.findAll();

        {


        }



    }
    //step -13, method to find student by ID
    public Student getStudentById(int id){
        Student student =  repository.findStudentById(id);
        return student;
    }
}















