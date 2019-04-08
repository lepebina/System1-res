package com.ice.automation.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public interface GenericEntityDao<O> {

    O persist(O object);

    O merge(O object);

    void remove(O object);

    void evict(O object);

    long countRows(O object);

    <K> boolean exists(O object,String field, K value);

    boolean exists(O object,Map<String, Object> fields);

    Object queryByCompositeKey(O object,Map<String, Object> fields);

    List<Object> queryByCompositeKey(O object,Map<String, Object> fields, String orderBy);

    <K> List<Object> queryByField(O object,String field, K value, boolean ...args);

    List<Object> queryByFields(O object,Map<String, Object> fields);

    Object queryById(O object,long id);

    List<Object> queryByIds(O object,List<Long> ids);

    <K> Object queryByKey(O object,String field, K value);





}
