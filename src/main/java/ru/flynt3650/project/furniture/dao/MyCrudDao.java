package ru.flynt3650.project.furniture.dao;

import java.util.List;

public interface MyCrudDao<T, V> {

    // Create
    void create(T t);

    // Read
    List<T> readAll();

    T readOne(V id);

    // Update
    void update(V v, T t);

    // Delete
    void delete(V id);
}
