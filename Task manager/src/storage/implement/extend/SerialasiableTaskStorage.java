/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.implement.extend;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.implement.TaskStorage;
import task.implement.TaskImpl;
import task.interfaces.Task;

/**
 *
 * @author Денис
 */
public class SerialasiableTaskStorage extends TaskStorage implements Serializable {

    static FileOutputStream fos;
    
    static ObjectOutputStream oos;
    private String path;
    static FileInputStream fis;
    static ObjectInputStream oin;

    public SerialasiableTaskStorage() {
        path = "out.txt";
        init();
    }
    public void init(){
        try {
            
            fos = new FileOutputStream(path);

            oos = new ObjectOutputStream(fos);
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeSave(){
        try {
            
            oos.close();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void flush(){
        try {
            oos.flush();
            fos.flush();
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeLoad(){
        try {
            
            oin.close();
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void saveObject(Task object) {
        try {
            Task t=object;
            //fos = new FileOutputStream(path);

            //oos = new ObjectOutputStream(fos);
            
            oos.writeObject(t);            
                        
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Task loadObject() {
        
        try {
            //fis = new FileInputStream(path);
            //oin = new ObjectInputStream(fis);
            
             Task t = (Task) oin.readObject();
            
            //oin.close();
            //fis.close();
            return t;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void saveCollectionObject(Collection<Task> collectionObject) {
        try {
           
            for (Task t : collectionObject) {
                oos.writeObject(t);
            }

            } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Collection<Task> loadCollectionObject() {
        Collection<Task> tempCollection = new ArrayList<Task>();
        try {
            
           
            
            while (oin.available() > 0) {
                
                Object ob=oin.readObject();
                
                Task t = (Task) ob;
                tempCollection.add(t);
            }
            
            return tempCollection;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempCollection;
    }
    ////добавить методы 
    //типа хранение последней сохраненной/загруженной таски

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path + "out.txt";
    }
}
