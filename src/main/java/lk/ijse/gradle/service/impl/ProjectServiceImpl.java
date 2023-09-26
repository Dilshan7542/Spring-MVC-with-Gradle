package lk.ijse.gradle.service.impl;

import lk.ijse.gradle.dto.ProjectDTO;
import lk.ijse.gradle.entity.Project;
import lk.ijse.gradle.repo.ProjectRepositories;
import lk.ijse.gradle.service.ProjectService;
import org.hibernate.Session;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepositories projectRepo;
    @Autowired
    ModelMapper map;
    @PersistenceContext
    EntityManager entityManager;

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
        if(!projectRepo.existsById(id)){
            throw new RuntimeException("Project Not Exists..!");
        }
        Project project = projectRepo.findById(id).get();
        entityManager.detach(project);
        project.getTechLead().setProjectList(null);
        return map.map(project,ProjectDTO.class);
    }

    @Override
    public void deleteProject(String id) {
        if(!projectRepo.existsById(id)){
            throw new RuntimeException("Project Not Exists..!");
        }
        System.out.println(id);
        projectRepo.delete(projectRepo.findById(id).get());
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        List<Project> list = projectRepo.findAll();
        for (Project project : list) {
            project.getTechLead().setProjectList(null);
        }

        return map.map(list,new TypeToken<List<ProjectDTO>>(){}.getType());
    }
}
