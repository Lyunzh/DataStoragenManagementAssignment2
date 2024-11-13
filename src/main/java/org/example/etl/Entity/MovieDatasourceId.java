package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MovieDatasourceId implements java.io.Serializable {
    private static final long serialVersionUID = 4407175626069637364L;
    @Size(max = 20)
    @NotNull
    @Column(name = "MOVIE_NAME", nullable = false, length = 20)
    private String movieName;

    @Size(max = 20)
    @NotNull
    @Column(name = "ASIN", nullable = false, length = 20)
    private String asin;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieDatasourceId entity = (MovieDatasourceId) o;
        return Objects.equals(this.asin, entity.asin) &&
                Objects.equals(this.movieName, entity.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, movieName);
    }

}