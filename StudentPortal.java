import java.util.List;

public class StudentPortal {
    private final CourseSystem courseSystem;



    public StudentPortal() {
        this.courseSystem = CourseSystem.getInstance();
    }

    public void signUp(Student student) {
        courseSystem.signUp(student);
    }

    public void logIn(Student student) {
        courseSystem.logIn(student.getName(), student.getId());
    }

    public void logOut(Student student) {
        courseSystem.logOut(student);
    }

    public void addToCart(Course c, Student student) {
        courseSystem.addToCart(student, c);
    }

    public void removeFromCart(Course c, Student student) {
        courseSystem.removeFromCart(student, c);
    }

    public void clearCart(Student student) {
        courseSystem.clearCart(student);
    }

    public void signUpToCourse(Course c, Student student) {
        courseSystem.signUpToCourse(student, c);
    }

    public void removeFromCourse(Course c, Student student) {
        courseSystem.removeStudentFromCourse(c, student);
    }

    public void signUpToAllInCart(Student student) {
        courseSystem.signUpToAllInCart(student);
    }

    public void printNotifications(Student student){
        courseSystem.printNotifications(student);
    }
}
