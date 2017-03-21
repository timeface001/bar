package com.fs.config;

import java.util.List;
import java.util.Map;

/**
 * Created by fengsong on 2017/3/9.
 */
public interface BaseDao<T> {
     int save(T entity);
     int update(T entity);
     int deleteById(Long id);
     T findOneByMap(Map<String,Object> paramMap);
     List<T> findByMap(Map<String,Object> paramMap);
     int queryCount(Map<String,Object> paramMap);
     List<T> findAll();
}
