package com.labSync.LabSync.persistence;

import java.util.List;

public interface DAOMethods<T> {

    void add(T t);

    void edit(T t);

    void delete(T t);

    T findById(long id);

    List<T> findAll();

}
