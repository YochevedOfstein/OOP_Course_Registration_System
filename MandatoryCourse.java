import java.util.List;

public class MandatoryCourse extends Course {



    public MandatoryCourse(String name, int courseNumber, int capacity){
        super(name, courseNumber, capacity);
    }

    @Override
    public String getCourseType() {
        return "Mandatory";
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Mandatory course: " + getName() + ", course number: " + getCourseNumber() + ", maximum capacity: " + getCapacity() + ", number of student: " + numOfStudents());
    }


}
