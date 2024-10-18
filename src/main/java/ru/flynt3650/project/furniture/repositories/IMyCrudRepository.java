package ru.flynt3650.project.furniture.repositories;

import java.util.List;

public interface IMyCrudRepository<T, V> {

    void create(T t);

    List<T> readAll();

    T readOne(V id);

    void update(V v, T t);

    void delete(V id);
}
