import java.util.List;

public class main {
    public static void main(String[] args) {
        CourseSystem courseSystem = CourseSystem.getInstance();


        Teacher teacher = new Teacher(1, "joy");
        TeachersAssistant ta = new TeachersAssistant(11, "chen");
        Student student1 = new Student(101, "alice");
        Student student2 = new Student(102, "shalom");
        Student student3 = new Student(103, "avi");
        Student student4 = new Student(104, "mor");

        courseSystem.signUp(teacher);
        courseSystem.signUp(ta);

        courseSystem.logIn("joy", 1);

        courseSystem.createCourse(teacher, "Seminar", "Linear algebra", 1001, 20);
        courseSystem.createCourse(ta, "Mandatory", "OOP", 1002,10);
        courseSystem.createCourse(ta, "Seminar", "OOP", 1002,10);

        Course a = courseSystem.getCourse(1001);
        Course b = courseSystem.getCourse(1002);

        StudentPortal studentPortal = new StudentPortal();


        studentPortal.signUp(student1);

        studentPortal.addToCart(a,student1);
        studentPortal.addToCart(b,student1);

        studentPortal.removeFromCart(a, student1);

        studentPortal.signUpToAllInCart(student1);

        courseSystem.createCourse(ta, "Elective", "English", 1010,3);

        Course c = courseSystem.getCourse(1010);

        studentPortal.addToCart(c, student1);
        studentPortal.signUpToCourse(c,student1);
        studentPortal.logOut(student1);

        studentPortal.signUp(student2);
        studentPortal.addToCart(c, student2);
        studentPortal.signUpToCourse(c, student2);

        studentPortal.addToCart(c,student3);
        studentPortal.signUp(student3);
        studentPortal.addToCart(c, student3);
        studentPortal.addToCart(a ,student3);
        studentPortal.addToCart(b, student3);
        studentPortal.signUpToAllInCart(student3);

        studentPortal.signUp(student4);
        studentPortal.addToCart(c, student4);

        studentPortal.removeFromCourse(c, student3);
        studentPortal.printNotifications(student4);

    }
}
