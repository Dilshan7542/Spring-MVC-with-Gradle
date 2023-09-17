package lk.ijse.gradle.service;

import lk.ijse.gradle.dto.ProjectDTO;
import lk.ijse.gradle.dto.TechLeadDTO;
import lk.ijse.gradle.entity.TechLead;

import java.util.List;

public interface TechLeadService {
    TechLeadDTO saveTechLead(TechLeadDTO techLead);
    TechLeadDTO updateTechLead(TechLeadDTO techLead);
    TechLeadDTO searchTechLead(String id);
    void deleteTechLead(String id);
    List<TechLeadDTO> getAllTechLead();
}
