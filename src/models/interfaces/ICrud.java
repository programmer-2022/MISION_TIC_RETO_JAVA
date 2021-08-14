package models.interfaces;

import java.util.LinkedList;

public interface ICrud<T> {
    
    boolean create(T obj);
    LinkedList<T> readAll();
    boolean update(T obj);
    boolean delete(Object id);
    T read(Object id);
}