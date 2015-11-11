package task.implement;


import task.interfaces.Task;
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
public class TaskImpl implements Serializable, Task{
    private Date timeOfBeginning;
     private String description;
     private String name;
  
    public TaskImpl(Date someTime){
        setTime(someTime);
    }
    
    public TaskImpl(Date someTime, String someDescription){
        setTime(someTime);
        setDescription(someDescription);
    }
    
    public Date getTime(){
        return this.timeOfBeginning;
    }
    public void setTime(Date SomeTime){
        this.timeOfBeginning=SomeTime;
    }
    
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String someDescription){
        this.description=someDescription;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String someName){
        this.name=someName;
    }
     public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if(!super.equals(o)) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) {
            return false;
        }
        TaskImpl e =(TaskImpl)o;
        return (this.timeOfBeginning.equals(e.timeOfBeginning)&this.name.equals(e.name)&this.description.equals(e.description));
     }
     
     public int hashCode(){ // подумать как сделать
         return (description+name).hashCode()+timeOfBeginning.hashCode();
     }
}
