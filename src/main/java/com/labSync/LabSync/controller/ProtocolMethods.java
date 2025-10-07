package com.labSync.LabSync.controller;

import java.util.List;

public interface ProtocolMethods<T> {

    T post(T entity);

    boolean delete(long id);

    T put(long id, T entity);

    T patch(long id, T entity);

    T getById(int id);

    List<T> getAll();

}
