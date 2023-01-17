package cl.grupopi.portafolio.models.dao;

import java.util.List;

public interface ICrudDao <T> {
    List<T> getAll();
    T getById(Long id);
    void create(T t);
    void update(T t);
    void delete(T t);
}
