public interface Observerble {
    public void addObserver(Student s);
    public void removeObserver(Student s);
    public void notifyObservers(String notification);
}
