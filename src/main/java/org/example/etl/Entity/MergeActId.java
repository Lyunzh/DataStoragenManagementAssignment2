package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class MergeActId implements java.io.Serializable {
    private static final long serialVersionUID = 2936040729565866774L;
    @Size(max = 20)
    @NotNull
    @Column(name = "MOVIE_NAME", nullable = false, length = 20)
    private String movieName;

    @Size(max = 20)
    @NotNull
    @Column(name = "ACTOR_NAME", nullable = false, length = 20)
    private String actorName;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MergeActId entity = (MergeActId) o;
        return Objects.equals(this.actorName, entity.actorName) &&
                Objects.equals(this.movieName, entity.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName, movieName);
    }

}