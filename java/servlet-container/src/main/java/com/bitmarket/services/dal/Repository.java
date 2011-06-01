package com.bitmarket.services.dal;

import java.util.List;

public interface Repository<T> {
    void save(T element);
    void save(Iterable<T> element);

    void update(T element);
    void updates(Iterable<T> elements);

    void delete(long id);
    void delete(List<Long> ids);

    T get(long id);
    T read(long id);
    List<T> readAll();
}
