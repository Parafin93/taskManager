package storage.implement;


import java.io.Serializable;
import storage.interfaces.Storage;
import task.implement.TaskImpl;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public abstract class TaskStorage implements Storage<TaskImpl>, Serializable {

    //может еще какие методы добавить?
    //типа хранение последней сохраненной/загруженной таски

    public void saveObject(TaskImpl object) {
        
    }

    public void loadObject(TaskImpl object) {
        
    }

    

    
}
