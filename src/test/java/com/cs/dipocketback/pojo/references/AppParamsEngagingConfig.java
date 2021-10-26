package com.cs.dipocketback.pojo.references;

public class AppParamsEngagingConfig {
    
    private Double daysBetweenReviews;
    private Double daysForReview;
    private Boolean isNewVersionEnabled = false;
    private Boolean isReviewEnabled = false;
    
    public AppParamsEngagingConfig() {
    }

    public AppParamsEngagingConfig(Double daysBetweenReviews, Double daysForReview, Boolean isNewVersionEnabled,
                          Boolean isReviewEnabled) {
        this.daysBetweenReviews = daysBetweenReviews;
        this.daysForReview = daysForReview;
        this.isNewVersionEnabled = isNewVersionEnabled;
        this.isReviewEnabled = isReviewEnabled;
    }

    public void setDaysBetweenReviews(Double daysBetweenReviews) {
        this.daysBetweenReviews = daysBetweenReviews;
    }

    public Double getDaysBetweenReviews() {
        return daysBetweenReviews;
    }

    public void setDaysForReview(Double daysForReview) {
        this.daysForReview = daysForReview;
    }

    public Double getDaysForReview() {
        return daysForReview;
    }

    public void setIsNewVersionEnabled(Boolean isNewVersionEnabled) {
        this.isNewVersionEnabled = isNewVersionEnabled;
    }

    public Boolean getIsNewVersionEnabled() {
        return isNewVersionEnabled;
    }

    public void setIsReviewEnabled(Boolean isReviewEnabled) {
        this.isReviewEnabled = isReviewEnabled;
    }

    public Boolean getIsReviewEnabled() {
        return isReviewEnabled;
    }
    
}
