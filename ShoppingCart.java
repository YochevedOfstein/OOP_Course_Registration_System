import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Course> Mycart;

    public ShoppingCart(){
        this.Mycart = new ArrayList<>();
    }

    public void addToCart(Course c){
        if(c.isFull){
            System.out.println("Course is full - can't add to cart");
        }
        else{
            Mycart.add(c);
            System.out.println("Course has been added to cart");
        }
    }
    public void removeFromCart(Course c){
        if(!Mycart.contains(c)){
            System.out.println("Course is not in cart");
        }
        else{
            Mycart.remove(c);
        }
    }
    public void clearCart(){
        Mycart.clear();
        System.out.println("Shopping cart has been cleared");
    }

    public boolean isEmpty(){
        return Mycart.isEmpty();
    }

    public List<Course> getCartContent(){
        return Mycart;
    }

}
