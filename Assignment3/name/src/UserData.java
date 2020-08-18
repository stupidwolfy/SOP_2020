public class UserData {

    private String Name;
    private int dob;

    private static UserData instance;

    private UserData() {

    }

    public static UserData getInstance() {
        if (instance == null)
            instance = new UserData();
        return instance;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals (Object otherObject){
        if(!(otherObject instanceof UserData)){
            return false;
        }
        if(!((UserData)otherObject).getName().equals(this.Name)){
            return false;
        }
        if(((UserData)otherObject).getDob() != this.dob){
            return false;
        }
        return true;
    }

    
}