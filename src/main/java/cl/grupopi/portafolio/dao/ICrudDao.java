package cl.grupopi.portafolio.dao;

import java.util.List;

public interface ICrudDao <T>{

    void create(T t);
    void update(T t);
    void delete(Long id);
    T getById(Long id);
    List<T> getAll();
}
