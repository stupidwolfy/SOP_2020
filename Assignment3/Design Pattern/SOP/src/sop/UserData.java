package sop;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UserData extends prototype{

    private String Name;
    private int dob;

    public UserData() {

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