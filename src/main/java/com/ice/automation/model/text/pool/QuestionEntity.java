package com.ice.automation.model.text.pool;

import com.ice.automation.model.text.TextKeyEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Component
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_questions_id")
    private long id;
    @Column
    private int sequence;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_text_key_id")
    private TextKeyEntity questionMsgKey;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_text_key_id_invalid")
    private TextKeyEntity invalidResponseMsgKey;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pool_schedule_days_id")
    private PoolScheduleInstanceEntity poolScheduleInstanceEntity;
    @OneToOne
    @JoinColumn(name = "next_question_id")
    private QuestionEntity nextQuestion;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnswerEntity> answerEntities = new ArrayList<AnswerEntity>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public TextKeyEntity getQuestionMsgKey() {
        return questionMsgKey;
    }

    public void setQuestionMsgKey(TextKeyEntity questionMsgKey) {
        this.questionMsgKey = questionMsgKey;
    }

    public TextKeyEntity getInvalidResponseMsgKey() {
        return invalidResponseMsgKey;
    }

    public void setInvalidResponseMsgKey(TextKeyEntity invalidResponseMsgKey) {
        this.invalidResponseMsgKey = invalidResponseMsgKey;
    }

    public PoolScheduleInstanceEntity getPoolScheduleInstanceEntity() {
        return poolScheduleInstanceEntity;
    }

    public void setPoolScheduleInstanceEntity(PoolScheduleInstanceEntity poolScheduleInstanceEntity) {
        this.poolScheduleInstanceEntity = poolScheduleInstanceEntity;
    }

    public QuestionEntity getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(QuestionEntity nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }
}
