import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    //String of a URL containing the assigned host number and database name
    private static final String url = "jdbc:postgresql://localhost:5432/Assignment3_Question1";

    //String of the local pgAdmin user
    private static final String user = "postgres";

    //String of the local pgAdmin password
    private static final String password = "admin";

    //Connection class utilized for connecting to database
    private Connection connection;

    /**
     * This function attempts to connect to the database
     * based on the pre-defined URL, user, and password.
     */
    private void connect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            System.out.println("Exception occurred while connecting to database.");
        }
    }

    /**
     * This function attempts to access the database and
     * corresponding students table to retrieve and display
     * all currently present records.
     */
    public void getAllStudents(){
        try{
            //Attempt to connect to the database given the pre-determined url, user, and password
            connect();
            Statement statement = connection.createStatement();
            //Send query which retrieves all info from students table, sorted by student ID
            statement.executeQuery("SELECT * FROM students ORDER BY student_id");
            //Store the resulting information in a resultSet for printing
            ResultSet resultSet = statement.getResultSet();

            while(resultSet.next()){
                //Format table data for each student and print to system
                System.out.print("Student ID: " + resultSet.getInt("student_id"));
                System.out.print("  Name: " + resultSet.getString("first_name") + " ");
                System.out.print(resultSet.getString("last_name"));
                System.out.print("  Email address: " + resultSet.getString("email"));
                System.out.println("  Enrollment date: "+ resultSet.getString("enrollment_date"));
            }
        } catch(Exception e){}
    }

    /**
     * This function takes as input all necessary information to
     * define a new student, then attempts to insert a new student
     * with the corresponding info. A new student ID is generated
     * based on the auto_increment present in the table.
     *
     * @param first_name The first name of the student to be added.
     * @param last_name The last name of the student to be added.
     * @param email The email of the student to be added.
     * @param enrollment_date The enrollment date of the student to be added.
     */
    public void addStudent(String first_name, String last_name, String email, String enrollment_date){
        try{
            //Attempt to connect to the database given the pre-determined url, user, and password
            connect();
            Statement statement = connection.createStatement();
            //Send query which inserts a new student into the table with the given parameters
            statement.executeQuery("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('" +
                    first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "');");
        } catch(Exception e){}
    }

    /**
     * This function takes as input a student ID and an email,
     * then attempts to update the database with the email corresponding
     * to the given ID.
     *
     * @param student_id The ID of the student to be updated.
     * @param new_email The given email to replace the current email.
     */
    public void updateStudentEmail(int student_id, String new_email){
        try{
            //Attempt to connect to the database given the pre-determined url, user, and password
            connect();
            Statement statement = connection.createStatement();
            //Send query which updates the email address for a student with the given student ID
            statement.executeQuery("UPDATE students SET email = '" + new_email + "' WHERE student_id = "+ student_id + ";");
        } catch(Exception e){}
    }

    /**
     * This function takes as input a student ID and attempts to
     * delete the record in the database which corresponds to
     * the given ID.
     *
     * @param student_id The ID of the student to be deleted
     */
    public void deleteStudent(int student_id){
        try{
            //Attempt to connect to the database given the pre-determined url, user, and password
            connect();
            Statement statement = connection.createStatement();
            //Send query which deletes all entries in the student table where the given ID equals the student ID
            statement.executeQuery("DELETE FROM students WHERE student_id = '" + student_id + "';");
        }catch(Exception e){}
    }

    /**
     * Simple function which delays the current thread for a
     * pre-determined period of time to allow for greater
     * readability during program execution.
     */
    public void sleep(){
        //Attempts to sleep the current thread for approx 1 sec
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e ) {
            e.printStackTrace();
            System.exit(1);
        }
        //Utilized for clear distinction between retrievals of the printed database
        System.out.println("-----------------------------------------------------" +
                "----------------------------------------------------");
    }

    /**
     * Main executable function which is utilized to demonstrate
     * the effect of each function in a formatted output to the system.
     *
     * @param args Default parameter of executable main function
     */
    public static void main(String[] args){
        Main main = new Main();
        main.getAllStudents();
        main.sleep();
        main.addStudent("Jesse", "Pinkman", "jesse.pinkman@example.com", "2023-09-04");
        main.getAllStudents();
        main.updateStudentEmail(1, "test.change@example.com");
        main.sleep();
        main.getAllStudents();
        main.deleteStudent(4);
        main.sleep();
        main.getAllStudents();
    }
}
