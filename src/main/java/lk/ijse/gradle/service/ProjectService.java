package lk.ijse.gradle.service;

import lk.ijse.gradle.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO saveProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(ProjectDTO projectDTO);
    ProjectDTO searchProject(String id);
    void deleteProject(String id);
    List<ProjectDTO> getAllProject();
}
