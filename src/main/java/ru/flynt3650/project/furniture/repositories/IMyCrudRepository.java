package ru.flynt3650.project.furniture.repositories;

import java.util.List;
import java.util.Optional;

public interface IMyCrudRepository<T, V> {

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
