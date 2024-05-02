public class ElectiveCourse extends Course{


    public ElectiveCourse(String name, int courseNumber, int capacity){
        super(name, courseNumber, capacity);
    }

    @Override
    public String getCourseType() {
        return "Elective";
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Elective course: " + getName() + ", course number: " + getCourseNumber() + ", maximum capacity: " + getCapacity() + ", number of student: " + numOfStudents());
    }
}
