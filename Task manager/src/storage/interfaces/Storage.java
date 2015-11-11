package storage.interfaces;

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
    public void loadObject(T object);
}
