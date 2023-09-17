package lk.ijse.gradle.dto;

import lk.ijse.gradle.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    String projectID;
    String name;
    String description;
    int memberCount;
    TechLead techLead;
}
