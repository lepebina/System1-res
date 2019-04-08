package com.ice.automation.model.text.pool;

import com.ice.automation.model.text.TextKeyEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;



@Entity  @Component
@Table(name = "questions_answers")
public class AnswerEntity {

    @Id
    @GeneratedValue
    @Column(name = "pk_questions_answers_id")
    private long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_questions_id")
    private QuestionEntity question;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_answer_key_text_key_id")
    private TextKeyEntity answerTextKey;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_answer_text_key_id")
    private TextKeyEntity answerTextMsgKey;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_response_text_key_id")
    private TextKeyEntity responseMsgKey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }

    public TextKeyEntity getAnswerTextKey() {
        return answerTextKey;
    }

    public void setAnswerTextKey(TextKeyEntity answerTextKey) {
        this.answerTextKey = answerTextKey;
    }

    public TextKeyEntity getAnswerTextMsgKey() {
        return answerTextMsgKey;
    }

    public void setAnswerTextMsgKey(TextKeyEntity answerTextMsgKey) {
        this.answerTextMsgKey = answerTextMsgKey;
    }

    public TextKeyEntity getResponseMsgKey() {
        return responseMsgKey;
    }

    public void setResponseMsgKey(TextKeyEntity responseMsgKey) {
        this.responseMsgKey = responseMsgKey;
    }
}
