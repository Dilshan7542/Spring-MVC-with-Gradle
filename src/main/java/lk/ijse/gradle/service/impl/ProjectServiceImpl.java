package lk.ijse.gradle.service.impl;

import lk.ijse.gradle.dto.ProjectDTO;
import lk.ijse.gradle.entity.Project;
import lk.ijse.gradle.repo.ProjectRepositories;
import lk.ijse.gradle.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepositories projectRepo;
    @Autowired
    ModelMapper map;
    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        if(projectRepo.existsById(projectDTO.getProjectID())){
            throw new RuntimeException("Project Already Exists..!");
        }
        projectRepo.save(map.map(projectDTO, Project.class));
        return projectDTO;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        if(!projectRepo.existsById(projectDTO.getProjectID())){
            throw new RuntimeException("Project Not Exists..!");
        }
        projectRepo.save(map.map(projectDTO, Project.class));
        return projectDTO;
    }

    @Override
    public ProjectDTO searchProject(String id) {
        return map.map(projectRepo.findById(id),ProjectDTO.class);
    }

    @Override
    public void deleteProject(String id) {

    }

    @Override
    public List<ProjectDTO> getAllProject() {
        return null;
    }
}
