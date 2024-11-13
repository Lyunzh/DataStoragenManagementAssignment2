package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class OriginalActId implements java.io.Serializable {
    private static final long serialVersionUID = -9064488147577659883L;
    @Size(max = 30)
    @NotNull
    @Column(name = "ASIN", nullable = false, length = 30)
    private String asin;

    @Size(max = 400)
    @NotNull
    @Column(name = "ACTOR_NAME", nullable = false, length = 400)
    private String actorName;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
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
        OriginalActId entity = (OriginalActId) o;
        return Objects.equals(this.asin, entity.asin) &&
                Objects.equals(this.actorName, entity.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, actorName);
    }

}