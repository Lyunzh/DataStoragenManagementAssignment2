package org.example.etl.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MERGE_ACT")
public class MergeAct {
    @EmbeddedId
    private MergeActId id;

    public MergeActId getId() {
        return id;
    }

    public void setId(MergeActId id) {
        this.id = id;
    }

}