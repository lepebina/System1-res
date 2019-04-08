//package com.ice.automation.model.activity;
//
//import com.ice.automation.commons.JsonObjectMapperUtils;
//import org.codehaus.jackson.map.ObjectMapper;
//
//import javax.persistence.*;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//

//@Entity  @Component
//@Table(name = "activity_session_profile")
//public class ActivitySessionProfileEntity {
//
//    @Transient
//    private final ObjectMapper objectMapper = new JsonObjectMapperUtils();
//
//    @Id
//    @Column(name = "pk_activity_session_profile")
//    @GeneratedValue
//    private long id;
//    @Column
//    private String msisdn;
//    @Column(name = "activity_id")
//    private long activityId;
//    @Column(name = "last_question_id")
//    private long lastQuestionId;
//    @Column(name = "replies")
//    private String replies;
//
//    @Transient
//    private Map<Long, Long> repliesPerQuestion;
//
//    public void addReplyToQuestion(long questionId, long answerId) {
//        getRepliesPerQuestion().put(questionId, answerId);
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getMsisdn() {
//        return msisdn;
//    }
//
//    public void setMsisdn(String msisdn) {
//        this.msisdn = msisdn;
//    }
//
//    public long getActivityId() {
//        return activityId;
//    }
//
//    public void setActivityId(long activityId) {
//        this.activityId = activityId;
//    }
//
//    public long getLastQuestionId() {
//        return lastQuestionId;
//    }
//
//    public void setLastQuestionId(long lastQuestionId) {
//        this.lastQuestionId = lastQuestionId;
//    }
//
//    public String getReplies() {
//        return replies;
//    }
//
//    public void setReplies(String replies) {
//        this.replies = replies;
//    }
//
//    @SuppressWarnings("unchecked")
//    public Map<Long, Long> getRepliesPerQuestion() {
//        if (repliesPerQuestion == null) {
//            try {
//                if (replies == null) {
//                    this.repliesPerQuestion = new HashMap<Long, Long>();
//                } else {
//                    this.repliesPerQuestion = objectMapper.readValue(replies, Map.class);
//                }
//            } catch (IOException e) {
//                throw new IllegalArgumentException(String.format("Malformed object '%s'", replies));
//            }
//        }
//        return repliesPerQuestion;
//    }
//
//    public void setRepliesPerQuestion(Map<Long, Long> repliesPerQuestion) {
//        this.repliesPerQuestion = repliesPerQuestion;
//    }
//}
