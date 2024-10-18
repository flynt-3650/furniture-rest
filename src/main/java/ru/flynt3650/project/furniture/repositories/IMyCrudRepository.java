package ru.flynt3650.project.furniture.repositories;

import java.util.List;
import java.util.Optional;

public interface IMyCrudRepository<T, V> {

    void create(T t);

    List<T> readAll();

    Optional<T> readOne(V id);

    void update(V v, T t);

    void delete(V id);
}
