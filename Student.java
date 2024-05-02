import java.util.ArrayList;
import java.util.List;

public class Student extends User implements Observer{

    private ShoppingCart myCart;
    private List<String> notifications;

    public Student(int id, String name){
        super(id,name);
        this.myCart = new ShoppingCart();
        this.notifications = new ArrayList<>();
    }

    public void getsUserInfo() {
        System.out.println("Students name: " + getName() + "id: " + getId() );
    }

    @Override
    String getType() {
        return "Student";
    }

    @Override
    public void update(String notification) {
        notifications.add(notification);
    }

    public void becomeCourseObserver(Course c){
        c.addObserver(this);
    }

    public ShoppingCart getMyCart(){
        return myCart;
    }

    public boolean hasNotifications(){
        return !notifications.isEmpty();
    }

    public void printNotifications(){
        for(String notification : notifications){
            System.out.println(notification);
        }
    }
}
