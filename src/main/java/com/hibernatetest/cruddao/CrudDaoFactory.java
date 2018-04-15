package com.hibernatetest.cruddao;

import java.util.HashMap;
import java.util.Map;

public class CrudDaoFactory {
    private Map<Class<? extends Object>, CrudDao> cache = new HashMap<>();

    public <T, K> CrudDao<T, K> getDao(Class<T> tClass) {
        if (cache.containsKey(tClass)) {
            return cache.get(tClass);
        }

        CrudDao<T, K> result = new CrudDao<>(tClass);
        cache.put(tClass, result);
        return result;
    }
}
