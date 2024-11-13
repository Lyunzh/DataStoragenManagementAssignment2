package org.example.etl.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORIGINAL_DIRECT")
public class OriginalDirect {
    @EmbeddedId
    private OriginalDirectId id;

    public OriginalDirectId getId() {
        return id;
    }

    public void setId(OriginalDirectId id) {
        this.id = id;
    }

}