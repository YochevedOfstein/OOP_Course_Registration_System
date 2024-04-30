import java.util.ArrayList;
import java.util.List;

public class Teacher extends Staff{


    public Teacher(int id, String name) {
        super(id, name);
    }

    @Override
    public String getType() {
        return "Teacher";
    }

    public void getsUserInfo() {
        System.out.println("Teachers name: " + getName() + ", id: " + getId());
    }

}
