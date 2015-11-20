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
import task.interfaces.Task;

/**
 *
 * @author Денис
 */
public class SerialasiableTaskStorage extends TaskStorage implements Serializable {

    FileOutputStream fos;
    
    ObjectOutputStream oos;
    private String path;
    FileInputStream fis;
    ObjectInputStream oin;

    public SerialasiableTaskStorage() {
        path = "tasks.txt";
    }
    public void closeS() throws IOException{
        oos.close();
        fos.close();
        
    }
    public void closeL() throws IOException{
        
        oin.close();
        fis.close();
    }
    @Override
    public void saveObject(Task object) {
        try {
            
            fos = new FileOutputStream(path);

            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(object);
            
            oos.flush();
            fos.flush();
            
            //oos.close();
            //fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Task loadObject() {
        try {
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
            
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
            fos = new FileOutputStream(path);

            oos = new ObjectOutputStream(fos);
            for (Task t : collectionObject) {
                oos.writeObject(t);
            }

            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Collection<Task> loadCollectionObject() {
        try {
            Collection<Task> tempCollection = new ArrayList<Task>();
            fis = new FileInputStream(path);
            oin = new ObjectInputStream(fis);
            long i=0;
            while (oin.available() > 0) {
                oin.skip(i);
                Object ob=oin.readObject();
                i+=ob.toString().getBytes().length;
                Task t = (Task) ob;
                tempCollection.add(t);
            }
            oin.close();
            fis.close();
            return tempCollection;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SerialasiableTaskStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        this.path = path + "tasks.txt";
    }
}
