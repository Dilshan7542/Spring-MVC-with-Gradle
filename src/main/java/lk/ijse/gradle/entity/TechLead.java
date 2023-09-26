package lk.ijse.gradle.entity;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@DynamicUpdate
public class TechLead implements SuperEntity {
    @Id
    String id;
    @JoinColumn(nullable = false)
    String name;
    @JoinColumn(nullable = false)
    String address;
    @Lob
    @JoinColumn(nullable = false)
    byte[] image;
    @OneToMany(mappedBy = "techLead",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Project> projectList;

}
