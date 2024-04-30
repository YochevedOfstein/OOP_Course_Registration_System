import java.util.List;

public class main {
    public static void main(String[] args) {
        CourseSystem courseSystem = CourseSystem.getInstance();

        // Create users
        Teacher teacher = new Teacher(1, "John Doe");
        TeachersAssistant ta = new TeachersAssistant(11, "chen");
        Student student = new Student(101, "Alice");

        // Sign up users
        courseSystem.signUp(teacher);
        courseSystem.signUp(ta);

        // Log in users
       // courseSystem.logIn(teacher);
       // courseSystem.logIn(ta);

        // Create a course
        courseSystem.createCourse(teacher, "Seminar", "Linear algebra", 1001, 20);
        courseSystem.createCourse(ta, "Mandatory", "OOP", 1002,10);
        courseSystem.createCourse(ta, "Seminar", "OOP", 1002,10);

        Course a = courseSystem.getCourse(1001);
        Course b = courseSystem.getCourse(1002);

        StudentPortal studentPortal = new StudentPortal(student);

        studentPortal.signUp();
        studentPortal.logIn();

        studentPortal.addToCart(a);
        studentPortal.addToCart(b);








    }
}
