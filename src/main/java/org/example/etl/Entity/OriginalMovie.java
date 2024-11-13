package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "ORIGINAL_MOVIE")
public class OriginalMovie {
    @Id
    @Size(max = 30)
    @Column(name = "ASIN", nullable = false, length = 30)
    private String asin;

    @Size(max = 500)
    @Column(name = "MOVIE_NAME", length = 500)
    private String movieName;

    @Size(max = 100)
    @Column(name = "STYLE", length = 100)
    private String style;

    @Size(max = 1)
    @ColumnDefault("0")
    @Column(name = "IF_MISS", length = 1)
    private String ifMiss;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getIfMiss() {
        return ifMiss;
    }

    public void setIfMiss(String ifMiss) {
        this.ifMiss = ifMiss;
    }

}