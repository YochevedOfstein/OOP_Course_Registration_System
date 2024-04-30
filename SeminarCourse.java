public class SeminarCourse extends Course implements CourseType{


    public SeminarCourse(String name, int courseNumber, int capacity){
        super(name, courseNumber, capacity);
    }

    @Override
    public String getCourseType(){
        return "Seminar";
    }


    @Override
    public void displayCourseInfo() {
        System.out.println("Seminar course: " + getName() + ", course number: " + getCourseNumber());
    }
}
