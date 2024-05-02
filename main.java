import java.util.List;

public class main {
    public static void main(String[] args) {
        CourseSystem courseSystem = CourseSystem.getInstance();

        // Create users
        Teacher teacher = new Teacher(1, "joy");
        TeachersAssistant ta = new TeachersAssistant(11, "chen");
        Student student1 = new Student(101, "alice");
        Student student2 = new Student(102, "shalom");
        Student student3 = new Student(103, "avi");
        Student student4 = new Student(104, "mor");

        // Sign up users
        courseSystem.signUp(teacher);
        courseSystem.signUp(ta);

        // Trying to log in a user that's already logged in
        courseSystem.logIn("joy", 1);

        // Create a course
        courseSystem.createCourse(teacher, "Seminar", "Linear algebra", 1001, 20);
        courseSystem.createCourse(ta, "Mandatory", "OOP", 1002,10);
        courseSystem.createCourse(ta, "Seminar", "OOP", 1002,10);

        Course a = courseSystem.getCourse(1001);
        Course b = courseSystem.getCourse(1002);

        StudentPortal studentPortal1 = new StudentPortal(student1);
        StudentPortal studentPortal2 = new StudentPortal(student2);
        StudentPortal studentPortal3 = new StudentPortal(student3);
        StudentPortal studentPortal4 = new StudentPortal(student4);

        studentPortal1.signUp();

        studentPortal1.addToCart(a);
        studentPortal1.addToCart(b);

        studentPortal1.removeFromCart(a);

        studentPortal1.signUpToAllInCart();

        courseSystem.createCourse(ta, "Elective", "English", 1010,3);

        Course c = courseSystem.getCourse(1010);

        studentPortal1.addToCart(c);
        studentPortal1.signUpToCourse(c);
        studentPortal1.logOut();

        studentPortal2.signUp();
        studentPortal2.addToCart(c);
        studentPortal2.signUpToCourse(c);

        studentPortal3.addToCart(c);
        studentPortal3.signUp();
        studentPortal3.addToCart(c);
        studentPortal3.addToCart(a);
        studentPortal3.addToCart(b);
        studentPortal3.signUpToAllInCart();

        studentPortal4.signUp();
        studentPortal4.addToCart(c);

        studentPortal3.removeFromCourse(c);
        studentPortal4.printNotifications();








    }
}
