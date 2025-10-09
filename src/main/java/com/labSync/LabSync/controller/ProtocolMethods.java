package com.labSync.LabSync.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProtocolMethods<T> {

    ResponseEntity<String> post(T entity);

    ResponseEntity<String> delete(long id);

    ResponseEntity<String> put(long id, T entity);

    ResponseEntity<String> patch(long id, T entity);

    ResponseEntity<T> getById(int id);

    ResponseEntity<List<T>> getAll();

}
