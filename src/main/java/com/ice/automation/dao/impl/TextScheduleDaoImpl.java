package com.ice.automation.dao.impl;

import com.ice.automation.model.text.TextScheduleEntity;
import com.ice.automation.model.text.TextScheduleInstanceEntity;
import com.ice.automation.dao.TextScheduleDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@SuppressWarnings("unchecked")
@Repository("textScheduleDao")
public class TextScheduleDaoImpl extends GenericEntityDaoImpl<TextScheduleEntity> implements TextScheduleDao {

    @Transactional(readOnly = true)
    public List<TextScheduleInstanceEntity> getAllForDay(Date day) {
        return (List<TextScheduleInstanceEntity>)
                sessionFactory.getCurrentSession().createQuery("select i from TextScheduleInstanceEntity i " +
                                                                       "left join fetch i.textScheduleEntity e " +
                                                                       "left join fetch i.textKeyEntity t " +
                                                                       "where i.order is NULL " +
                                                                       "and i.date >= :day ")
                              .setCacheable(true)
                              .setTimestamp("day", day)
                              .list();
    }

    public TextScheduleInstanceEntity getTextScheduleByIdAndOrder(long textScheduleId, int order) {
        return (TextScheduleInstanceEntity)
                sessionFactory.getCurrentSession().createQuery("select i from TextScheduleInstanceEntity i " +
                                                                       "left join fetch i.textScheduleEntity e " +
                                                                       "left join fetch i.textKeyEntity t " +
                                                                       "where t.id=:textScheduleId " +
                                                                       "and i.order = :orderParam")
                              .setLong("textScheduleId", textScheduleId)
                              .setInteger("orderParam", order)
                              .uniqueResult();
    }

    //    @Transactional(readOnly = true)
    public TextScheduleInstanceEntity getForDay(String textKey, Date day) {
        return (TextScheduleInstanceEntity)
                sessionFactory.getCurrentSession().createQuery("select i from TextScheduleInstanceEntity i " +
                                                                       "left join fetch i.textScheduleEntity e " +
                                                                       "left join fetch i.textKeyEntity t " +
                                                                       "where t.key=:keyParam " +
                                                                       "and i.startDate >= :dayFrom " +
                                                                       "and i.endDate <= :dayTo")
                              .setTimestamp("dayFrom", day)
                              .setTimestamp("dayTo", day)
                              .uniqueResult();
    }

    public TextScheduleInstanceEntity getForOrder(String textKey, int order) {
        return (TextScheduleInstanceEntity)
                sessionFactory.getCurrentSession().createQuery("select i from TextScheduleInstanceEntity i " +
                                                                       "left join fetch i.textScheduleEntity e " +
                                                                       "left join fetch i.textKeyEntity t " +
                                                                       "where t.key=:keyParam " +
                                                                       "and i.order=:orderParam")
                              .setString("keyParam", textKey)
                              .setInteger("orderParam", order)
                              .uniqueResult();
    }
}
