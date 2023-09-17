package lk.ijse.gradle.service.impl;

import lk.ijse.gradle.dto.TechLeadDTO;
import lk.ijse.gradle.entity.TechLead;
import lk.ijse.gradle.repo.TechLeadRepositories;
import lk.ijse.gradle.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    TechLeadRepositories techLeadRepositories;
    @Autowired
    ModelMapper map;
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
        return map.map(techLeadRepositories.findById(id),TechLeadDTO.class);
    }

    @Override
    public void deleteTechLead(String id) {

    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        return null;
    }
}
