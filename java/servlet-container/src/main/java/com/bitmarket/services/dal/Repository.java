package com.bitmarket.services.dal;

public interface Repository<T> {
    T read(long id);
}
