package com.ice.automation.dao;

import com.ice.automation.model.text.pool.QuestionEntity;


public interface QuestionEntityDao extends GenericEntityDao<QuestionEntity> {

    QuestionEntity getQuestionById(long questionId);
}
