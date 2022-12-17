package dao;

import java.util.List;


public interface IDao <T>{
    
    default boolean create(T o){
              throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

	boolean delete(T o);

	boolean update(T o);

    /**
     *
     * @param id
     * @return
     */
    default	T findById(int id){
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

default	List<T> findAll(){
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
}
