import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CourseSystem {
    private static CourseSystem instance;
    private List<Course> courses;
    private List<User> users;
    private List<User> loggedIn;
    private final int maxLoggedIn = 100;

    private CourseSystem(){
        this.courses = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loggedIn = new ArrayList<>();
    }

    public static CourseSystem getInstance(){
        if(instance == null){
            instance = new CourseSystem();
        }
        return instance;
    }

    public void createCourse(User creator, String type, String name, int number, int capacity){
        if(creator instanceof Student){
            System.out.println("Course can only be created by a teacher or a TA, not by a Student");
            return;
        }
        if(capacity < 1){
            System.out.println("Invalid capacity cannot create course");
        }
        else{
            if(!loggedIn.contains(creator)){
                System.out.println("Cannot create course while not logged in");
            }
            else {
                Course newCourse = CourseFactory.createCourse(name, number, type, capacity);
                if (!courses.contains(newCourse)) {
                    courses.add(newCourse);
                    newCourse.addStaffMember((Staff) creator);
                }
            }
        }
    }

    public List<Course> getCourses(){
        return courses;
    }

    public Course getCourse(int coursenum){
        for(Course course : courses){
            if(course.getCourseNumber() == coursenum){
                return course;
            }
        }
        System.out.println("Course not found");
        return null;
    }

    public void signUp(User u){
        if(users.contains(u)){
            System.out.println("User already signed up to system");
        }
        else{
            users.add(u);
            logIn(u.getName(), u.getId());
            System.out.println("Welcome to course system " + u.getName() + "! your username is your name and your password is your id");
        }
    }


    public void logIn(String username, int password){
        for(User user : users){
            if(user.getName() == username && user.getId() == password){
                if(loggedIn.size() == maxLoggedIn){
                    System.out.println("Can't log in - to many users logged in at the moment");
                }
                else{
                    if(loggedIn.contains(user)){
                        System.out.println("User " + user.getName() + " already logged in");
                    }
                    else{
                        loggedIn.add(user);
                        user.connect();
                    }
                }
            }
        }
    }

    public void logOut(User u){
        if(!users.contains(u)){
            System.out.println("No user " + u.getName() + "in system");
        }
        else{
            if(!loggedIn.contains(u)){
                System.out.println("Error - User is not logged in");
            }
            else{
                loggedIn.remove(u);
                u.disconnect();
            }
        }
    }

    public void addToCart(Student u, Course c) {
        if (!u.isConnected()) {
            System.out.println("Can't add to cart - " + u.getName() + " is not connected");
        } else {
            if(c.isFull){
                System.out.println("Course " + c.getCourseNumber() +  " is full - can't add to cart");
                System.out.println("Would you like an update if any room frees up? (Yes/No)");
                Scanner scanner = new Scanner(System.in);
                String ans = scanner.nextLine();
                if (Objects.equals(ans, "Yes")) {
                    if(!c.getObservers().contains(u)){
                        c.addObserver(u);
                        System.out.println(u.getName() + " will receive an update if any room frees up in course " + c.getCourseNumber());
                    }
                }
            }
            else{
                u.getMyCart().addToCart(c);
                System.out.println("Course " + c.getCourseNumber() + " has been added to " + u.getName() + "s cart");
            }
        }
    }

    public void removeFromCart(Student u, Course c) {
        if (!u.isConnected()) {
            System.out.println(u.getName() + " not connected - must log in first");
        } else {
             u.getMyCart().removeFromCart(c);
        }
    }

    public void clearCart(Student u) {
        if (!u.isConnected()) {
            System.out.println(u.getName() + " not connected - must log in first");
        } else {
            u.getMyCart().clearCart();
        }
    }

    public void signUpToCourse(Student u, Course c) {
        if (!u.isConnected()) {
            System.out.println(u.getName() + " not connected - must log in first");
        } else {
            if (!u.getMyCart().getCartContent().contains(c)) {
                System.out.println("Course " + c.getName() + " is not in shopping cart");
            } else {
                System.out.println(u.getName() + " signed up to course " + c.getCourseNumber());
                c.addStudent(u);
                removeFromCart(u,c);
            }
        }
    }

    public void removeStudentFromCourse(Course c, Student u){
        c.removeStudent(u);
    }

    public void signUpToAllInCart(Student u) {
        if (!u.isConnected()) {
            System.out.println(u.getName() + " not connected - must log in first");
        } else {
            List<Course> cart = u.getMyCart().getCartContent();
            if(cart.isEmpty()){
                System.out.println("Shopping cart is empty");
            }
            for(Course c : cart) {
                c.addStudent(u);
            }
            System.out.println(u.getName() + "signed up to all courses in his cart");
            clearCart(u);
        }
    }

    public void printNotifications(Student u) {
        if (!u.isConnected()) {
            System.out.println(u.getName() + " not connected - must log in first");
        }
        else{
            if(!u.hasNotifications()){
                System.out.println(u.getName() + " doesn't have notifications");
            }
            else{
                System.out.println(u.getName() + "s notifications:");
                u.printNotifications();
            }
        }
    }
}
