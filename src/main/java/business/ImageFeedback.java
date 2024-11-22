package business;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ImageFeedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] feedbackImage;

    @ManyToOne
    @JoinColumn(name = "review_id") // Cột `order_id` trong bảng FURNITURE
    private Review review;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFeedbackImage() {
        return feedbackImage;
    }

    public void setFeedbackImage(byte[] feedbackImage) {
        this.feedbackImage = feedbackImage;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
