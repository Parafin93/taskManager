
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Дот
 */
public class Contact implements Serializable, Contactable{
    int ID;
    int Telephone;
    String Description;
    String FIO;
    
    public Contact(String SomeFIO){
        SetFIO(SomeFIO);
    }
    
    public Contact(String SomeFIO, String SomeDescription){
        SetFIO(SomeFIO);
        SetDescription(SomeDescription);
    }
    
    public Contact(String SomeFIO, String SomeDescription, int SomeTelephone){
        SetFIO(SomeFIO);
        SetDescription(SomeDescription);
        SetTelephone(SomeTelephone);
    }
    public int GetID(){
        return this.ID;
    }
    public void SetID(){
        
    }
    
    public void SetDescription(String SomeDescription){
        this.Description=SomeDescription;
    }
    
    public String GetDescription(){
        return this.Description;
    }
    
    public void SetFIO(String SomeFIO){
        this.FIO=SomeFIO;
    }
    
    public String GetFIO(){
        return this.FIO;
    }
    
    public void SetTelephone(int SomeTelephone){
        this.Telephone=SomeTelephone;
    }
    
    public int GetTelephone(){
        return this.Telephone;
    }
}
