package com.Genericity.GenericityInterface;

public interface data<T> {
    void add(T t);
    void delete(T t);
    void update(T t);
    T query(int id);
}
