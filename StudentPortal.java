import java.util.List;

public class StudentPortal {
    private final CourseSystem courseSystem;
    private final Student student;


    public StudentPortal(Student student) {
        this.student = student;
        this.courseSystem = CourseSystem.getInstance();
    }

    public void signUp() {
        courseSystem.signUp(student);
    }

    public void logIn() {
        courseSystem.logIn(student.getName(), student.getId());
    }

    public void addToCart(Course c) {
        courseSystem.addToCart(student, c);
    }

    public void removeFromCart(Course c) {
        courseSystem.removeFromCart(student, c);
    }

    public void clearCart() {
        courseSystem.clearCart(student);
    }

    public void signUpToCourse(Course c) {
        courseSystem.signUpToCourse(student, c);
    }

    public void signUpToAllInCart() {
        courseSystem.signUpToAllInCart(student);
    }
}
