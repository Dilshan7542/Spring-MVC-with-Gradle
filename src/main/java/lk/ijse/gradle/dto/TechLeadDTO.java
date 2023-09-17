package lk.ijse.gradle.dto;

import lk.ijse.gradle.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLeadDTO {
    String id;
    String name;
    List<Project> projectList;
}
