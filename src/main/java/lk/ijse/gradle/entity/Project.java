package lk.ijse.gradle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@DynamicUpdate
public class Project implements SuperEntity {
    @Id
    String projectID;
    String name;
    String description;
    int memberCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "techLeadID",referencedColumnName = "id")
    TechLead techLead;
}
