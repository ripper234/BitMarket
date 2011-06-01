package com.bitmarket.services.dal;

import java.util.List;

public interface Repository<T> {
    void save(T item);
    T read(long id);
    List<T> readAll();
}
