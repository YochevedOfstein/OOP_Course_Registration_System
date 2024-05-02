import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Course implements Observerble{

    private String name;
    private int courseNumber;
    private int capacity;
    private List<Student> students;
    private List<Observer> observers;
    private List<Staff> staff;
    protected boolean isFull = false;

    public Course(String name, int courseNumber, int capacity){
        this.courseNumber = courseNumber;
        this.name = name;
        this.capacity = capacity;
        this.students = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.staff = new ArrayList<>();
    }

    public void addStudent(Student s){
        if(students.contains(s)){
            System.out.println("Student already signed up to course");
            return;
            }
        if(isFull){
            System.out.println("Course is full- should we let you know if a spot frees up?");
            System.out.println("Yes- press 1, No- press 2");
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if(ans == 1){
                if(!observers.contains(s)){
                    observers.add(s);
                }
            }
        }
        else{
            students.add(s);
            if(students.size() == capacity){
                isFull = true;
            }
        }
    }

    public void removeStudent(Student s){
        if(!students.contains(s)){
            System.out.println("Student never signed up for course");
            return;
        }
        students.remove(s);
        if(isFull){
            isFull = false;
            String str = "Available spot in course: " + getName() + ", " + getCourseNumber();
            notifyObservers(str);
        }
    }

    public String getName(){
        return name;
    }

    public int getCourseNumber(){
        return courseNumber;
    }

    public int getCapacity(){
        return capacity;
    }

    public int numOfStudents(){
        return students.size();
    }

    public List<Observer> getObservers(){
        return observers;
    }

    public void removeObserver(Student s){
        observers.remove(s);
    }
    public void addObserver(Student s){
        observers.add(s);
    }
    public void notifyObservers(String notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }

    public void addStaffMember(Staff s){
        if(staff.contains(s)){
            System.out.println("Teacher/TA already a member of the courses staff");
        }
        staff.add(s);
    }

    abstract void displayCourseInfo();

    abstract String getCourseType();
}
