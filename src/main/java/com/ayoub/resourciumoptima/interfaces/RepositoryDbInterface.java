package com.ayoub.resourciumoptima.interfaces;

import java.util.List;

public interface RepositoryDbInterface<T>{


    void save(T obj);

    void delete(Long id);

    void update(T obj);

    T findById(Long id);

    List<T> getAll();
}
