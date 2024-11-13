package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ORIGINAL_DIRECTOR")
public class OriginalDirector {
    @Id
    @Size(max = 300)
    @Column(name = "DIRECTOR_NAME", nullable = false, length = 300)
    private String directorName;

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

}