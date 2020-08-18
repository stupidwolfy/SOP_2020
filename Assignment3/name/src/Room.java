import java.util.ArrayList;

public class Room {
    private ArrayList<UserData> Userpool;
    private int roomLimit = 20;

    public void enter(UserData user){
        if (Userpool.size() < roomLimit){
            Userpool.add(user);
        }
        else{
            System.out.println("This room is full.");
        }
    }

    public void exit(UserData user){
        Userpool.remove(user);
    }

        
}