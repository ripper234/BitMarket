package com.bitmarket.services.dal;

import org.apache.commons.lang.NotImplementedException;
import org.hibernate.Session;
import org.totallycommon.util.Action1;
import org.totallycommon.util.Func1;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public abstract class HibernateRepositoryBase<T> implements Repository<T> {
    @Inject
    protected DbUtil dbUtil;

    private final Class<T> clazz;

    protected HibernateRepositoryBase(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(Iterable<T> elements) {
        for (T element : elements) {
            final T theElement = element;
            dbUtil.doWithSession(new Action1<Session>() {
                @Override
                public void doSomething(Session session) {
                    session.save(theElement);
                }
            });
        }
    }

    @Override
    public void updates(Iterable<T> elements) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(List<Long> ids) {
        throw new NotImplementedException();
    }

    // single item methods
    @Override
    public void save(T element) {
        save(Arrays.asList(element));
    }

    @Override
    public void update(T element) {
        save(Arrays.asList(element));
    }

    @Override
    public void delete(long id) {
        delete(Arrays.asList(id));
    }

    @Override
    public T get(final long id) {
        return dbUtil.doWithSession(new Func1<T, Session>() {
            @SuppressWarnings({"RedundantCast"})
            @Override
            public T doSomething(Session session) {
                final Object result = session.get(clazz, (Long) id);
                //noinspection unchecked
                return (T) result;
            }
        });
    }

    @Override
    public T read(long id) {
        throw new NotImplementedException();
    }

    @Override
    public List<T> readAll() {
        throw new NotImplementedException();
    }
}

