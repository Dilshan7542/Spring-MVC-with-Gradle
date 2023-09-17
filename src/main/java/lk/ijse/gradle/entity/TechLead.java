package lk.ijse.gradle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
    @OneToMany(mappedBy = "techLead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Project> projectList;

}
