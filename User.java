public abstract class User {

    private final int id;
    private final String name;

    private boolean connected = false;

    public User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean isConnected(){
        return connected;
    }
    public void disconnect(){
        connected = false;
    }
    public void connect(){
        connected = true;
    }
    public int getId(){
        return id;
    }


    abstract String getType();

    abstract void getsUserInfo();

}
