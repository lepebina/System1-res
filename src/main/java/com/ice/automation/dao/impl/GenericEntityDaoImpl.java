package com.ice.automation.dao.impl;

import com.ice.automation.dao.GenericEntityDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("genericEntityDao")
public class GenericEntityDaoImpl<O> implements GenericEntityDao<O> {

    @Autowired
    protected SessionFactory sessionFactory;

    public O persist(O object) {
        //sessionFactory.getCurrentSession().persist(object);
        return object;
    }

    @SuppressWarnings("unchecked")
    public O merge(O object) {
        return (O) sessionFactory.getCurrentSession().merge(object);
    }

    public void remove(O object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public void evict(O object) {
        sessionFactory.getCurrentSession().evict(object);
    }

    public long countRows(O object)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.setProjection(Projections.rowCount());
        return ((Number) criteria.uniqueResult()).longValue();
    }


    public <K> boolean exists(O object,String field, K value)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.eq(field, value));
        criteria.setProjection(Projections.rowCount());

        return ((Number) criteria.uniqueResult()).intValue() >= 1;
    }

    public boolean exists(O object,Map<String, Object> fields)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.allEq(fields));
        criteria.setProjection(Projections.rowCount());

        return ((Number) criteria.uniqueResult()).intValue() >= 1;
    }

    @SuppressWarnings("unchecked")
    public Object queryByCompositeKey(O object,Map<String, Object> fields)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.allEq(fields));
        return object; // (Object) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Object> queryByCompositeKey(O object,Map<String, Object> fields, String orderBy)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.allEq(fields));
        criteria.addOrder(Order.asc(orderBy));
        return criteria.list();
    }

    /*
     * @brief Load a list of entities, filtered by an association's id
     */
    @SuppressWarnings("unchecked")
    public <K> List<Object> queryAllByAssociationId(O object,String associationPath, long id)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());

        Criteria sub = criteria.createCriteria(associationPath);
        sub.add(Restrictions.eq("id", id));

        return criteria.list();
    }

    /*
     * @brief Load a list of all entities
     */
    @SuppressWarnings("unchecked")
    public <K> List<Object> queryAll(Object object)
    {
        return sessionFactory.getCurrentSession().createCriteria(object.getClass()).list();
    }

    /*
     * @brief Load a list of entities, indexed by a single field of any type
     *
     * If the first argument of ...args is true, it means we need to get all
     * that are not equal to the value K, otherwise all that are equal
     */
    @SuppressWarnings("unchecked")
    public <K> List<Object> queryByField(O object,String field, K value, boolean ...args)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());

        boolean notEqualsQuery = (args.length > 0) && args[0];

        if (notEqualsQuery) {
            if (value != null) {
                criteria.add(Restrictions.ne(field, value));
            } else {
                criteria.add(Restrictions.isNotNull(field));
            }
        } else {
            if (value == null) {
                criteria.add(Restrictions.isNull(field));
            } else {
                criteria.add(Restrictions.eq(field, value));
            }
        }
        return criteria.list();
    }

    /*
     * @brief Load a list of entities, indexed by multiple fields of any type
     */
    @SuppressWarnings("unchecked")
    public List<Object> queryByFields(O object,Map<String, Object> fields)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.allEq(fields));
        return criteria.list();
    }

    /*
     * @brief Load an entity, indexed with its primary key
     */
    @SuppressWarnings("unchecked")
    public Object queryById(O object,long id)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Object) session.get(object.getClass(), id);
    }

    /*
     * @brief Load many entities, indexed with its primary key
     */
    @SuppressWarnings("unchecked")
    public List<Object> queryByIds(O object,List<Long> ids)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());

        criteria.add(Restrictions.in("id", ids));

        return criteria.list();
    }

    /*
     * @brief Load an entity, indexed with a unique key of any type
     */
    @SuppressWarnings("unchecked")
    public <K> Object queryByKey(O object,String field, K value)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());
        criteria.add(Restrictions.eq(field, value));
        return (Object) criteria.uniqueResult();
    }

    /*
     * @brief Load many entities, indexed with a list of unique keys of any type
     */
    @SuppressWarnings("unchecked")
    public <K> List<Object> queryByMultipleKeyValues(O object,String field, List<K> values)
    {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(object.getClass());

        criteria.add(Restrictions.in(field, values));
        return criteria.list();
    }




}
