import java.util.ArrayList;

public class Room {
    private ArrayList<UserData> userPool = new ArrayList<>();
    private int roomLimit = 20;
    private String rname;

    public Room(String rname) {
        this.rname = rname;
    }

    public void enter(UserData user) {
        if (userPool.size() < roomLimit) {
            userPool.add(user);
            System.out.println("Entered " + rname + " .");
        } else {
            System.out.println(rname + " is full.");
        }
    }

    public void exit(UserData user) {
        userPool.remove(user);
        System.out.println("Exited " + rname + " .");
    }

}