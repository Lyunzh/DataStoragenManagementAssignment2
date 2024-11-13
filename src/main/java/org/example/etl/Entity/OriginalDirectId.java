package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class OriginalDirectId implements java.io.Serializable {
    private static final long serialVersionUID = 298592433587348338L;
    @Size(max = 30)
    @NotNull
    @Column(name = "ASIN", nullable = false, length = 30)
    private String asin;

    @Size(max = 300)
    @NotNull
    @Column(name = "DIRECTOR_NAME", nullable = false, length = 300)
    private String directorName;

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
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
        OriginalDirectId entity = (OriginalDirectId) o;
        return Objects.equals(this.directorName, entity.directorName) &&
                Objects.equals(this.asin, entity.asin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorName, asin);
    }

}