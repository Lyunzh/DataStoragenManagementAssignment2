package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MergeDirectId implements java.io.Serializable {
    private static final long serialVersionUID = -8124480459080272720L;
    @Size(max = 20)
    @NotNull
    @Column(name = "MOVIE_NAME", nullable = false, length = 20)
    private String movieName;

    @Size(max = 20)
    @NotNull
    @Column(name = "DIRECTOR_NAME", nullable = false, length = 20)
    private String directorName;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MergeDirectId entity = (MergeDirectId) o;
        return Objects.equals(this.directorName, entity.directorName) &&
                Objects.equals(this.movieName, entity.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorName, movieName);
    }

}