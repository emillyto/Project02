import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    /*
   MiniProject: Student Management System
       1. Create Student Management System that can be used by any educational institution
       2. User (Admin) can: CRUD operations
           -register user (id, name, lastName, city, age fields)
           -list/display students/student
           -update student by id
           -delete student by id

           1)Step-create Menu for the APP
           2)Step-create student class(entity)
           3)Step-create methods for the students
           4)Step-create class to connect Database

*/
    public static void main(String[] args) throws SQLException {
        start();



    }
    // Step 1-Create menu
    public static void start() throws SQLException {
        Scanner input=new Scanner(System.in);
        // to reach out method from service class we need to create instance of StudentService

        StudentService service=new StudentService();
        // Step 8 -Table should be created when start () method is called
        service.createTable();
        System.out.println("Table created successful");

        int select;
     do {
         System.out.println("==========================");
         System.out.println("****Student Admin Panel*****");
         System.out.println("1-Student Register");
         System.out.println("2-List all Students");
         System.out.println("3-Delete Student");
         System.out.println("4-Update Student");
         System.out.println("5-Find Student by ID");
         System.out.println("0-Exit App");
         System.out.println("Select Activity");

         select=input.nextInt();
         input.nextLine();// to call next enter or new line
         int id;
         switch(select){
             case 1:
                 //Register
                 service.safeStudent();
                 break;
             case 2:
                 //display all students
                 //display all students
                 service.getAllStudents();
                 break;


             case 3:
                 //Delete student by ID
                 id=getStudentById(input);
                 break;
             case 4:
                 //Update student by id
                 id=getStudentById(input);
                 break;
             case 5 :
                 //Find student by ID
                 id=getStudentById(input);
                 break;
             case 0:
                 //Exit the App
                 break;
             default:
                 System.out.println("Incorrect Input");
         }

     }while (select !=0);
        System.out.println("Thank you for using app and have a nice time");

    }
    //Method to get id from User
    private static int getStudentById(Scanner inp){
        System.out.println("Enter Student ID");
        int id=inp.nextInt();
        inp.nextLine();
        return id;
    }
}
