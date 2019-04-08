package com.ice.automation.commons;

import java.util.List;
import java.util.Map;

public interface GenericService {

	void persist(Object object);

    Object findById(Object object,Long id);

	void update(Object object);

	void delete(Object object);

    <K> Object queryByKey(Object object,String field, K value);

    <K> Object queryByMultipleKeys(Object object,Map<String, Object> fields);

    <K> boolean exists(Object object,String field, K value);

    long countRows(Object object);

    Object queryByCompositeKey(Object object,Map<String, Object> fields);

    List<Object> queryByCompositeKey(Object object,Map<String, Object> fields,String orderBy);


}
