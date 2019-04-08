package com.ice.automation.dao.impl;

import com.ice.automation.model.text.pool.QuestionEntity;
import com.ice.automation.dao.QuestionEntityDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("questionEntityDao")
public class QuestionEntityDaoImpl extends GenericEntityDaoImpl<QuestionEntity> implements QuestionEntityDao {

    public QuestionEntity getQuestionById(long questionId) {
        return (QuestionEntity) sessionFactory.getCurrentSession().createCriteria(QuestionEntity.class).add(Restrictions.eq("id", questionId)).uniqueResult();
    }
}
