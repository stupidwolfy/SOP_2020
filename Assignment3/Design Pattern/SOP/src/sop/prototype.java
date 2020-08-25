/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sop;

/**
 *
 * @author Nirawit
 */
public abstract class prototype implements Cloneable{
    

    public String calculate(UserData user){
        return "Your age is "+(2020-user.getDob());
    }
    
    public prototype clone() throws CloneNotSupportedException {
        return (prototype) super.clone();
  }
}
