/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.factory;

import storage.implement.TaskStorage;
import storage.implement.extend.SerialasiableTaskStorage;

/**
 *
 * @author Денис
 */
public class StorageFactory {

    private static volatile StorageFactory instance;

    private StorageFactory() {
    }

    public static StorageFactory getInstance() {
        if (instance == null) {
            synchronized (StorageFactory.class) {
                if (instance == null) {
                    instance = new StorageFactory();
                }
            }
        }
        return instance;
    }

    public TaskStorage getStorage(int type) {
        if(type==1){
            return new SerialasiableTaskStorage();
        }

        return new SerialasiableTaskStorage(); // пока что так
    }
}
