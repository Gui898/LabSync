package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProtocolMethods<T> {

    ResponseEntity<T> post(T entity);

    ResponseEntity<Void> delete(long id);

    ResponseEntity<T> put(long id, T entity);

    ResponseEntity<T> patch(long id, T entity);

    ResponseEntity<T> getById(int id);

    ResponseEntity<List<T>> getAll();

}
