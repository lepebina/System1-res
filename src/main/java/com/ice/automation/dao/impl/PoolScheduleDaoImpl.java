package com.ice.automation.dao.impl;

import com.ice.automation.model.text.pool.PoolScheduleEntity;
import com.ice.automation.model.text.pool.QuestionEntity;
import com.ice.automation.dao.PoolScheduleDao;
import org.springframework.stereotype.Repository;


@Repository("poolScheduleDao")
public class PoolScheduleDaoImpl extends GenericEntityDaoImpl<PoolScheduleEntity> implements PoolScheduleDao {

    public PoolScheduleEntity getPoolScheduleById(long poolScheduleId) {
        return (PoolScheduleEntity) sessionFactory.getCurrentSession()
                                                  .createQuery("select p from PoolScheduleEntity p " +
                                                                       "join fetch p.poolScheduleInstanceEntities e " +
                                                                       "where p.id=:poolScheduleId")
                                                  .setLong("poolScheduleId", poolScheduleId)
                                                  .uniqueResult();
    }

    public QuestionEntity getFirstQuestion(long pollScheduleInstanceId) {
        return (QuestionEntity) sessionFactory.getCurrentSession()
                                              .createQuery("select q from QuestionEntity q " +
                                                                   "join q.poolScheduleInstanceEntity p " +
                                                                   "where p.id=:pollScheduleInstanceId " +
                                                                   "and q.sequence=1")
                                              .setLong("pollScheduleInstanceId", pollScheduleInstanceId)
                                              .uniqueResult();
    }
}
