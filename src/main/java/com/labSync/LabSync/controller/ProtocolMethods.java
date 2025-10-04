package com.labSync.LabSync.controller;

import java.util.List;

public interface ProtocolMethods<T> {

    T post(T entity);

    boolean delete(T entity);

    T put(T entity);

    T patch(T entity);

    T getById(int id);

    List<T> getAll();

}
