import java.sql.*;

public class StudentRepository {

    // Class which will be connected to Database(We need Connection,PreparedStatement)
    private Connection con;
    private Statement statement;
    private PreparedStatement prs;

    // Step 3 -Method to create Connection
    private void getConnection() throws SQLException {
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "Password");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
        //Step 4 -Method to create statement


    }

    void getStatement() {
        try {
            this.statement = con.createStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    private void getPreparedStatement(String query) throws SQLException {
        try {
            this.prs = con.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }

    // Step 6-to create connection
    public void createTable() throws SQLException {
        getConnection(); //create connection
        getStatement(); //to be able to run queries

        try {
            String query = "CREATE TABLE  IF NOT EXIST tbl_student (id SERIAL, name VARCHAR(50), lastname VARCHAR(50), city VARCHAR (50), age INT)";
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void save(Student newStudent) throws SQLException {
        getConnection();
        String query = "INSERT INTO tbl_student(name,lastname,city,age) Values(?,?,?,?)";
        getPreparedStatement(query);
        try {
            prs.setString(1, newStudent.getName());
            prs.setString(2, newStudent.getLastname());
            prs.setString(3, newStudent.getCity());
            prs.setInt(4, newStudent.getAge());
            System.out.println("Student registered");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        } finally {
            try {
                prs.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public void safe(Student newStudent) {

    }


    //step-12. method to bring all students from database
    public void findAll() throws SQLException {
        getConnection();
        String query = "SELECT * FROM tbl_student";
        getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print("id:" + resultSet.getInt("id"));
                System.out.print(" Name:" + resultSet.getString("name"));
                System.out.print(" Lastname:" + resultSet.getString("lastname"));
                System.out.print(" City:" + resultSet.getString("city"));
                System.out.print(" Age:" + resultSet.getInt("age"));
                System.out.println(); //to start from new line for info about next student
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


            }


}





