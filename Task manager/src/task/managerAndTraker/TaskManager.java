package task.managerAndTraker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import storage.implement.TaskStorage;
import task.interfaces.Task;
import threadPool.ThreadPool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Дот
 */
public class TaskManager {
    private NearTaskTracker tracker;
    TaskStorage storage;
    List<Task> tasks;
    
    public void load(){
        
    }
    public void close(){
        
    }
    public void removeTask(Task task){
        
                this.tasks.remove(task);
        
    }
    
    public void removeTaskByPosition(int index){
        
                this.tasks.remove(index);
        
    }
    
    public void removeAllTasksByDate(Date date){
        
                for(Task t:this.tasks){
                    if(t.getTime().equals(date)){
                        this.tasks.remove(t);
                    }
                }
        
    }
    public void addTask(Task task){
        this.tasks.add(task);
        //sort
    }
    public List<Task> getAllTasks(){
        return this.tasks;
    }
    
    public List<Task> getFutureTasks(){
        //задачи на след сутки??
        return tasks;
    }
    
    public List<Task> getOverdueTasks(){
        List<Task> tmp=new ArrayList<Task>();
        
        for(Task t:tasks){
            
            if(t.getStatus()==t.OVERDUE){
                tmp.add(t);
            }
        }
        return tmp;
    }

    public Task getNearTask(){
        return tracker.getNearTask();
    }
    public NearTaskTracker getNearTaskTracker() {
        return tracker;
    }

    
    public void setNearTaskTracker(NearTaskTracker nearTaskTracker) {
        this.tracker = nearTaskTracker;
    }
    
    
    
    
}
