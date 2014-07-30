package it.valeriovaudi.matchmanager.repository.dao.Interface;

import java.util.List;

public interface GenericDAO<T> {
   
	// general read
    List<T> findALL();
   
   // update method
    void update(T obj);
   
   // reomove method
    void remove(T obj);
   
   // insert method
    void insert(T obj);
   
}

