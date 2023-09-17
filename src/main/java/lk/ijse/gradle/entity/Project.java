package lk.ijse.gradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project implements SuperEntity {
    @Id
    String projectID;
    String name;
    String description;
    int memberCount;
    @ManyToOne
    @JoinColumn(name = "techLeadID")
    TechLead techLead;
}
