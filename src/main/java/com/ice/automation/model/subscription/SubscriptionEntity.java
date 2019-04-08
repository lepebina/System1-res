package com.ice.automation.model.subscription;

import com.ice.automation.model.text.TextKeyEntity;
import com.ice.automation.model.text.TextScheduleEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity  @Component
@Table(name = "subscription")
public class SubscriptionEntity {
    private static final long serialVersionUID = -8393617567654002781L;

    @Id
    @GeneratedValue
    @Column(name = "pk_subscription_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_active")
    private boolean enabled;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "free_period_days")
    private int freePeriodDays;
    @Column(name = "content_on_optin")
    private boolean contentOnOptin;
    @Column(name = "cost_weight")
    private double costWeight;
    @Column(name = "content_id", nullable = false)
    private Integer contentId;
    @Column(name = "content_provider")
    private String contentProvider;

    // messages
    @OneToOne
    @JoinColumn(name = "fk_welcome_text_schedule_id")
    private TextScheduleEntity welcomeTextSchedule;
    @OneToOne
    @JoinColumn(name = "fk_static_message_text_schedule_id")
    private TextScheduleEntity staticMessageTextSchedule;

    // replies
    @ManyToOne
    @JoinColumn(name = "fk_invalid_text_key")
    private TextKeyEntity invalidText;
    @ManyToOne
    @JoinColumn(name = "fk_score_text_key")
    private TextKeyEntity scoreText;
    @ManyToOne
    @JoinColumn(name = "fk_help_text_key")
    private TextKeyEntity helpText;
    // state replies
    @ManyToOne
    @JoinColumn(name = "fk_subscribe_text_key")
    private TextKeyEntity subscribeText;
    @ManyToOne
    @JoinColumn(name = "fk_already_subscribed_text_key")
    private TextKeyEntity alreadySubscribedText;
    @ManyToOne
    @JoinColumn(name = "fk_unsubscribe_text_key")
    private TextKeyEntity unsubscribeText;
    @ManyToOne
    @JoinColumn(name = "fk_already_unsubscribed_text_key")
    private TextKeyEntity alreadyUnSubscribedText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getFreePeriodDays() {
        return freePeriodDays;
    }

    public void setFreePeriodDays(int freePeriodDays) {
        this.freePeriodDays = freePeriodDays;
    }

    public boolean isContentOnOptin() {
        return contentOnOptin;
    }

    public void setContentOnOptin(boolean contentOnOptin) {
        this.contentOnOptin = contentOnOptin;
    }

    public double getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(double costWeight) {
        this.costWeight = costWeight;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContentProvider() {
        return contentProvider;
    }

    public void setContentProvider(String contentProvider) {
        this.contentProvider = contentProvider;
    }

    public TextScheduleEntity getWelcomeTextSchedule() {
        return welcomeTextSchedule;
    }

    public void setWelcomeTextSchedule(TextScheduleEntity welcomeTextSchedule) {
        this.welcomeTextSchedule = welcomeTextSchedule;
    }

    public TextScheduleEntity getStaticMessageTextSchedule() {
        return staticMessageTextSchedule;
    }

    public void setStaticMessageTextSchedule(TextScheduleEntity staticMessageTextSchedule) {
        this.staticMessageTextSchedule = staticMessageTextSchedule;
    }

    public TextKeyEntity getInvalidText() {
        return invalidText;
    }

    public void setInvalidText(TextKeyEntity invalidText) {
        this.invalidText = invalidText;
    }

    public TextKeyEntity getScoreText() {
        return scoreText;
    }

    public void setScoreText(TextKeyEntity scoreText) {
        this.scoreText = scoreText;
    }

    public TextKeyEntity getHelpText() {
        return helpText;
    }

    public void setHelpText(TextKeyEntity helpText) {
        this.helpText = helpText;
    }

    public TextKeyEntity getSubscribeText() {
        return subscribeText;
    }

    public void setSubscribeText(TextKeyEntity subscribeText) {
        this.subscribeText = subscribeText;
    }

    public TextKeyEntity getAlreadySubscribedText() {
        return alreadySubscribedText;
    }

    public void setAlreadySubscribedText(TextKeyEntity alreadySubscribedText) {
        this.alreadySubscribedText = alreadySubscribedText;
    }

    public TextKeyEntity getUnsubscribeText() {
        return unsubscribeText;
    }

    public void setUnsubscribeText(TextKeyEntity unsubscribeText) {
        this.unsubscribeText = unsubscribeText;
    }

    public TextKeyEntity getAlreadyUnSubscribedText() {
        return alreadyUnSubscribedText;
    }

    public void setAlreadyUnSubscribedText(TextKeyEntity alreadyUnSubscribedText) {
        this.alreadyUnSubscribedText = alreadyUnSubscribedText;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (!(obj instanceof SubscriptionEntity)) { return false; }
        SubscriptionEntity other = (SubscriptionEntity) obj;
        if (id == null) {
            if (other.id != null) { return false; }
        } else if (!id.equals(other.id)) { return false; }
        if (name == null) {
            if (other.name != null) { return false; }
        } else if (!name.equals(other.name)) { return false; }
        return true;
    }
}
