package org.example.etl.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "MERGE_DIRECT")
public class MergeDirect {
    @EmbeddedId
    private MergeDirectId id;

    public MergeDirectId getId() {
        return id;
    }

    public void setId(MergeDirectId id) {
        this.id = id;
    }

}