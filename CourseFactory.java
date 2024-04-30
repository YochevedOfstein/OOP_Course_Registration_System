import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CourseFactory {

    private static Map<Integer, Course> existingCourses = new HashMap<>();


    public static Course createCourse(String name, int courseNumber, String courseType, int capacity) {

        if(existingCourses.containsKey(courseNumber)) {
            System.out.println("Course number " + courseNumber + " already exists");
            return existingCourses.get(courseNumber);
        }

        switch(courseType){
            case "Seminar":
                SeminarCourse seminar = new SeminarCourse(name, courseNumber, capacity);
                existingCourses.put(courseNumber, seminar);
                return seminar;
            case "Mandatory":
                MandatoryCourse mandatory = new MandatoryCourse(name, courseNumber, capacity);
                existingCourses.put(courseNumber, mandatory);
                return mandatory;
            case "Elective":
                ElectiveCourse elective = new ElectiveCourse(name, courseNumber, capacity);
                existingCourses.put(courseNumber, elective);
                return elective;
            default:
                throw new IllegalArgumentException("Invalid course type");
        }
    }
}
