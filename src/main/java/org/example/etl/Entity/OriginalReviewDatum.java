package org.example.etl.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ORIGINAL_REVIEW_DATA")
public class OriginalReviewDatum {
    @Id
    @Size(max = 8)
    @Column(name = "REVIEW_ID", nullable = false, length = 8)
    private String reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PRODUCT_ID")
    private OriginalMovie product;

    @Size(max = 100)
    @Column(name = "USER_ID", length = 100)
    private String userId;

    @Size(max = 100)
    @Column(name = "PROFILE_NAME", length = 100)
    private String profileName;

    @Size(max = 10)
    @Column(name = "HELPFULNESS", length = 10)
    private String helpfulness;

    @Size(max = 20)
    @Column(name = "SCORE", length = 20)
    private String score;

    @Size(max = 20)
    @Column(name = "TIME", length = 20)
    private String time;

    @Size(max = 500)
    @Column(name = "SUMMARY", length = 500)
    private String summary;

    @Lob
    @Column(name = "TEXT")
    private String text;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public OriginalMovie getProduct() {
        return product;
    }

    public void setProduct(OriginalMovie product) {
        this.product = product;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getHelpfulness() {
        return helpfulness;
    }

    public void setHelpfulness(String helpfulness) {
        this.helpfulness = helpfulness;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}