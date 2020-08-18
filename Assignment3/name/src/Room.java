import java.util.ArrayList;
import java.util.List;

public class Room {
    private String room_name;
    private int room_limit = 6;
    private List<UserData> userPool = new ArrayList<>();

    public Room(String room_name) {
        this.room_name = room_name;
    }

    public void enter(UserData user) {
        if (userPool.size() < room_limit) {
            if (!userPool.contains(user)) {
                userPool.add(user);
                System.out.println("Entered " + room_name + " .");
            } else {
                System.out.println("You're already in " + room_name + " !!");
            }
        } else {
            System.out.println(room_name + " is full.");
        }
    }

    public void exit(UserData user) {
        if (userPool.contains(user)) {
            userPool.remove(user);
            System.out.println("Exited " + room_name + " .");
        } else {
            System.out.println("You aren't in " + room_name + " !!");
        }
    }
}