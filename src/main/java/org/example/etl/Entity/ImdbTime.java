package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "IMDB_TIME")
public class ImdbTime {
    @Id
    @Size(max = 20)
    @Column(name = "ASIN", nullable = false, length = 20)
    private String asin;

    @Size(max = 50)
    @Column(name = "TIME", length = 50)
    private String time;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}