package com.xcloud.qixinspy.db;

import java.util.List;

public interface IBaseDao<T> {

    int insert(T t);

    int deleteById(T t);

    int updateById(T t);

    T findById(String id);

    List<T> findAll();

    List<T> findByCondition(T cond);

}
