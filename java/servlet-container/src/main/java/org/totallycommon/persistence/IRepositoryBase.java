package org.totallycommon.persistence;

import java.util.List;

public interface IRepositoryBase<T> {
    void save(T element);
    void save(Iterable<T> element);

    void update(T element);
    void updates(Iterable<T> elements);

    void delete(long id);
    void delete(List<Long> ids);
    
    T get(long id);
}
