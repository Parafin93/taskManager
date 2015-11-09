
import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Дот
 */
public class Task implements Serializable, Taskable{
    Date TimeOfBeginning;
    String Description;
    //ID_List
    public Task(Date SomeTime){
        SetTime(SomeTime);
    }
    
    public Task(Date SomeTime, String SomeDescription){
        SetTime(SomeTime);
        SetDescription(SomeDescription);
    }
    
    public Date GetTime(){
        return this.TimeOfBeginning;
    }
    public void SetTime(Date SomeTime){
        this.TimeOfBeginning=SomeTime;
    }
    
    public String GetDescription(){
        return this.Description;
    }
    public void SetDescription(String SomeDescription){
        this.Description=SomeDescription;
    }
}
