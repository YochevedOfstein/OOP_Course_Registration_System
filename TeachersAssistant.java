public class TeachersAssistant extends Staff{



    public TeachersAssistant(int id, String name) {
        super(id, name);

    }

    public void getsUserInfo() {
        System.out.println("Teacher assistants name: " + getName() + ", id: " + getId());
    }


    @Override
    String getType() {
        return "TA";
    }
}
