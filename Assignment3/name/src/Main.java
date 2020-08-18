// Download gson
// https://search.maven.org/remotecontent?filepath=com/google/code/gson/gson/2.8.6/gson-2.8.6.jar

//import java.sql.Connection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(String args[]) {

    Scanner keyboard = new Scanner(System.in);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Room library;

    try {
      Reader reader = new FileReader("libdata.json");
      library = gson.fromJson(reader, Room.class);
    } catch (FileNotFoundException ex) {
      library = new Room("library");
    }

    UserData userData = UserData.getInstance();

    System.out.print("Enter name:");
    userData.setName(keyboard.nextLine());

    System.out.print("Enter birth year:");
    userData.setDob(Integer.parseInt(keyboard.nextLine()));

    int year = 2020 - userData.getDob();
    System.out.println("Your Age is: " + year);

    boolean keeploop = true;
    while (keeploop) {
      System.out.print("1-Enter 2-Exit 3-cancel: ");
      switch (keyboard.nextLine()) {
        case "1":
          library.enter(userData);
          break;
        case "2":
          library.exit(userData);
          break;
        default:
          keeploop = false;
          break;
      }
      try {
        Writer writer = new FileWriter("libdata.json");
        gson.toJson(library, writer);

        writer.flush(); // flush data to file
        writer.close(); // close write
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    }
    keyboard.close();

  }
}
