package lk.ijse.gradle.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TechLead implements SuperEntity{
    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "techLead",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    List<Project> projectList;

}
