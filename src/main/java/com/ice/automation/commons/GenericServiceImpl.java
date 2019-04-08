package com.ice.automation.commons;

import com.ice.automation.dao.GenericEntityDao;
import com.ice.automation.dao.impl.GenericEntityDaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("genericService")
public class GenericServiceImpl implements GenericService{

	@Autowired
    GenericEntityDaoImpl genericEntityDao = new GenericEntityDaoImpl();

    @Transactional
	public void persist(Object object) {
        genericEntityDao.persist(object);
	}

    @Transactional
    public Object findById(Object object,Long id) {
       return genericEntityDao.queryById(object,id);
    }

    @Transactional
	public void update(Object object) {
        genericEntityDao.merge(object);
	}

	@Transactional
	public void delete(Object object) {
        genericEntityDao.remove(object);
		
	}

    @Transactional
    public <K> Object queryByKey(Object object, String field, K value) {
        return object; // genericEntityDao.queryByKey(object,field,value);
    }

    @Transactional
    public <K> Object queryByMultipleKeys(Object object,Map<String, Object> fields) {
        return  genericEntityDao.queryByFields(object, fields);
    }

    @Transactional
    public <K> boolean exists(Object object, String field, K value) {
        return genericEntityDao.exists(object, field, value);
    }

    @Transactional
    public long countRows(Object object) {
        return genericEntityDao.countRows(object);
    }

    @Transactional
    public Object queryByCompositeKey(Object object, Map<String, Object> fields) {
        return object; // genericEntityDao.queryByCompositeKey(object , fields);
    }

    @Transactional
    public List<Object> queryByCompositeKey(Object object, Map<String, Object> fields, String orderBy) {
        return new ArrayList<Object>(); //genericEntityDao.queryByCompositeKey(object , fields , orderBy);
    }


}
