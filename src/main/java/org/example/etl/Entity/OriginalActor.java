package org.example.etl.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ORIGINAL_ACTOR")
public class OriginalActor {
    @Id
    @Size(max = 400)
    @Column(name = "ACTOR_NAME", nullable = false, length = 400)
    private String actorName;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

}