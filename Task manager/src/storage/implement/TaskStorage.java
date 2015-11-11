package storage.implement;


import storage.interfaces.Storage;
import task.implement.TaskImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public abstract class TaskStorage implements Storage<TaskImpl> {

    //может еще какие методы добавить?
    //типа сохранение последней saveObject loadObject

    public void saveObject(TaskImpl object) {
        
    }

    public void loadObject(TaskImpl object) {
        
    }

    

    
}
