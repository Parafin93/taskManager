/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.implement.extend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import storage.implement.TaskStorage;
import task.implement.TaskImpl;
import task.interfaces.Task;

/**
 *
 * @author Денис
 */
public class SerialasiableTaskStorage extends TaskStorage implements Serializable {

    @Override
    public void saveObject(Task object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task loadObject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveCollectionObject(Collection<Task> collectionObject) {
       /* collectionObject=new ArrayList<Task>();
        collectionObject.add(new TaskImpl());*/
    }

    @Override
    public Collection<Task> loadCollectionObject() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



   
    //
} 
