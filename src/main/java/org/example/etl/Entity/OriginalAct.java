package org.example.etl.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORIGINAL_ACT")
public class OriginalAct {
    @EmbeddedId
    private OriginalActId id;

    public OriginalActId getId() {
        return id;
    }

    public void setId(OriginalActId id) {
        this.id = id;
    }

}