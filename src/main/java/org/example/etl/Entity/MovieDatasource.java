package org.example.etl.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "MOVIE_DATASOURCE")
public class MovieDatasource {
    @EmbeddedId
    private MovieDatasourceId id;

    @MapsId("movieName")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MOVIE_NAME", nullable = false)
    private MergeMovie movieName;

    public MovieDatasourceId getId() {
        return id;
    }

    public void setId(MovieDatasourceId id) {
        this.id = id;
    }

    public MergeMovie getMovieName() {
        return movieName;
    }

    public void setMovieName(MergeMovie movieName) {
        this.movieName = movieName;
    }

}