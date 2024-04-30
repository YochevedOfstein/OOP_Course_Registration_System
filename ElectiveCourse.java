public class ElectiveCourse extends Course implements CourseType{


    public ElectiveCourse(String name, int courseNumber, int capacity){
        super(name, courseNumber, capacity);
    }

    @Override
    public String getCourseType() {
        return "Elective";
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Elective course: " + getName() + ", course number: " + getCourseNumber());
    }
}
