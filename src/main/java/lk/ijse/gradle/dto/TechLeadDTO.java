package lk.ijse.gradle.dto;

import lk.ijse.gradle.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLeadDTO {
    public TechLeadDTO(String id) {
        this.id = id;
    }

    String id;
    String name;
    String address;
    byte[] image;
    List<ProjectDTO> projectList;

    public TechLeadDTO(String id, String name, String address, byte[] image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
    }
}
