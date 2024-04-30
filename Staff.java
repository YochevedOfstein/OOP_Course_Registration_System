import java.util.ArrayList;
import java.util.List;

public abstract class Staff extends User{

    private List<Course> courseList;

    public Staff(int id, String name) {
        super(id, name);
        this.courseList = new ArrayList<>();
    }

    @Override
    abstract String getType();

    public void addCourse(Course course){
        courseList.add(course);
    }

    abstract void getsUserInfo();
}
