package storage.interfaces;

import java.util.Collection;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Дот
 */
public interface Storage<T> {

    public void saveObject(T object);

    public T loadObject();

    public void saveCollectionObject(Collection<T> collectionObject);

    public Collection<T> loadCollectionObject();
}
