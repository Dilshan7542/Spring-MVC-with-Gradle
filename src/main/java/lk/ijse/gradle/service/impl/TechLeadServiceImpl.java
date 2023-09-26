package lk.ijse.gradle.service.impl;

import lk.ijse.gradle.dto.ProjectDTO;
import lk.ijse.gradle.dto.TechLeadDTO;
import lk.ijse.gradle.entity.Project;
import lk.ijse.gradle.entity.TechLead;
import lk.ijse.gradle.repo.TechLeadRepositories;
import lk.ijse.gradle.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    TechLeadRepositories techLeadRepositories;
    @Autowired
    ModelMapper map;
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLead) {
        if(techLeadRepositories.existsById(techLead.getId())){
            throw new RuntimeException("Tech Lead Already Exists..!");
        }
        techLeadRepositories.save(map.map(techLead,TechLead.class));
        return techLead;
    }

    @Override
    public TechLeadDTO updateTechLead(TechLeadDTO techLead) {
        if(!techLeadRepositories.existsById(techLead.getId())){
            throw new RuntimeException("Tech Lead Not Exists..!");
        }
        techLeadRepositories.save(map.map(techLead,TechLead.class));
        return techLead;
    }

    @Override
    public TechLeadDTO searchTechLead(String id) {
        if(!techLeadRepositories.existsById(id)){
            throw new RuntimeException("Tech Lead Not Exists..!");
        }
        TechLead techLead = techLeadRepositories.findById(id).get();
        entityManager.detach(techLead);
        for (Project project : techLead.getProjectList()) {
            project.setTechLead(new TechLead());
        }
        return map.map(techLead, TechLeadDTO.class);
    }

    @Override
    public void deleteTechLead(String id) {
        if(!techLeadRepositories.existsById(id)){
            throw new RuntimeException("Tech Lead Not Exists..!");
        }
        techLeadRepositories.deleteById(id);
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        List<TechLead> list = techLeadRepositories.findAll();
        for (TechLead techLead : list) {
            techLead.setProjectList(null);

        }
        return  map.map( list,new TypeToken<List<TechLeadDTO>>(){}.getType());
    }
}
