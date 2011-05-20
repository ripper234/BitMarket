package com.bitmarket.services.dal;

import java.util.List;

public interface Repository<T> {
    T read(long id);
    List<T> readAll();
}
