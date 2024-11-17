package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Immutable;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "MOVIE_AVG_SCORE")
public class MovieAvgScore {
    @Id
    @Size(max = 100)
    @Column(name = "PRODUCT_ID", length = 100)
    private String productId;

    @Size(max = 500)
    @Column(name = "MOVIE_NAME", length = 500)
    private String movieName;

    @Column(name = "AVG_SCORE")
    private Long avgScore;

    public String getProductId() {
        return productId;
    }

    public String getMovieName() {
        return movieName;
    }

    public Long getAvgScore() {
        return avgScore;
    }

    protected MovieAvgScore() {
    }
}