package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "MERGE_MOVIE")
public class MergeMovie {
    @Id
    @Size(max = 20)
    @Column(name = "MOVIE_NAME", nullable = false, length = 20)
    private String movieName;

    @Size(max = 20)
    @Column(name = "STYLE", length = 20)
    private String style;

    @Column(name = "RELEASE_TIME")
    private LocalDate releaseTime;

    @Size(max = 20)
    @Column(name = "TIME_SOURCE", length = 20)
    private String timeSource;

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

    public LocalDate getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(LocalDate releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getTimeSource() {
        return timeSource;
    }

    public void setTimeSource(String timeSource) {
        this.timeSource = timeSource;
    }

}